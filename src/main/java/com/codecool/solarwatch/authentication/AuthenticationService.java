package com.codecool.solarwatch.authentication;

import com.codecool.solarwatch.security.config.JwtService;
import com.codecool.solarwatch.user.model.User;
import com.codecool.solarwatch.user.model.UserRole;
import com.codecool.solarwatch.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        boolean userExists = userRepository.existsByEmail(request.getEmail());

        if (userExists) {
            return null;
        }

        var user = new User();
        String[] emailParts = request.getEmail().split("@");

        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        UserRole userRoles = new UserRole();
        userRoles.setName("USER");
        userRoles.setDescription("Dostęp tylko do odczytu");
        Set<UserRole> setOfRoles = new HashSet<>();
        setOfRoles.add(userRoles);
        user.setRoles(setOfRoles);
        userRepository.save(user);

        String jwt = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwt)
                .userId(user.getId())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userRepository.findByEmail(request.getEmail());

        String jwt = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwt)
                .userId(user.getId())
                .build();
    }
}
