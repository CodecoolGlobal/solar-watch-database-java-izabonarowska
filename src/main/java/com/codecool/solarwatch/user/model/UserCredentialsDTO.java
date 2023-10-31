package com.codecool.solarwatch.user.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserCredentialsDTO {
    private final String email;
    private final String password;
    private final Set<String> roles;

    public UserCredentialsDTO(String email, String password, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
