package com.codecool.solarwatch.user.repository;

import com.codecool.solarwatch.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findAllUsersByRoles(String name);
    void deleteByEmail(String name);
}
