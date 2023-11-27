package com.codecool.solarwatch.user.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public record UserCredentialsDTO(String email, String password, Set<String> roles) {
}
