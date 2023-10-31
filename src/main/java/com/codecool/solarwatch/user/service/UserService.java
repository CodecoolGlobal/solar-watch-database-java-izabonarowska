package com.codecool.solarwatch.user.service;

import com.codecool.solarwatch.user.model.User;
import com.codecool.solarwatch.user.model.UserCredentialsDTO;
import com.codecool.solarwatch.user.model.UserCredentialsDTOMapper;
import com.codecool.solarwatch.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static final String USER_ROLE = "USER";
    private static final String ADMIN_AUTHORITY = "ROLE_ADMIN";
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserCredentialsDTO> findCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserCredentialsDTOMapper::map);
    }

    public List<String> findAllUserEmails(){
        return userRepository.findAllUsersByRoles(USER_ROLE)
                .stream()
                .map(User::getEmail)
                .toList();
    }

    @Transactional
    public void deleteUserByEmail(String email){
        if(isCurrentlyUserAdmin()){
            userRepository.deleteByEmail(email);
    }
}

    private boolean isCurrentlyUserAdmin() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equalsIgnoreCase(ADMIN_AUTHORITY));
    }
    }
