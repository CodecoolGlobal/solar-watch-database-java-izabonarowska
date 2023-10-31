package com.codecool.solarwatch.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    Do strony głównej mają dostęp wszyscy
//    Do wszystkich adresów rozpoczynających się od /admin/ mają dostęp tylko użytkownicy z rolą ADMIN
//    Do wszystkich zasobów, których ścieżka rozpoczyna się od /user-panel/ dostęp mają tylko użytkownicy z rolą USER
//    Żądania POST wysyłane pod adres /calculate mogą wykonywać tylko użytkownicy z rolą USER, lub ADMIN
//    Wszystkie pozostałe żądania wymagają uwierzytelnienia z dowolną rolą.

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                request -> request
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/img/**", "/styles/**").permitAll()
                        .requestMatchers("/secured/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/sun/**").hasAuthority("ROLE_USER")
                        .requestMatchers(HttpMethod.POST, "/sun").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated());
        http.formLogin(login -> login.loginPage("/login").permitAll());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
