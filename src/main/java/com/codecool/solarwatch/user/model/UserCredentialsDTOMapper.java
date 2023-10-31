package com.codecool.solarwatch.user.model;


import java.util.stream.Collectors;
import java.util.Set;
public class UserCredentialsDTOMapper {
    public static UserCredentialsDTO map(User user){
        String email = user.getEmail();
        String password = user.getPassword();
        Set<String> roles = user.getRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toSet());
        return new UserCredentialsDTO(email, password, roles);
    }
}
