package com.codecool.solarwatch.user.service;

import com.codecool.solarwatch.user.model.UserCredentialsDTO;
import com.codecool.solarwatch.user.model.UserCredentialsDTOMapper;
import com.codecool.solarwatch.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserCredentialsDTO> findCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserCredentialsDTOMapper::map);
    }
}
