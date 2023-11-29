package com.codecool.solarwatch.user.model;


import java.util.Set;

public record UserCredentialsDTO(String email, String password, Set<String> roles) {
}
