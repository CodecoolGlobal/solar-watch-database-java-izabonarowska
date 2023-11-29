package com.codecool.solarwatch.user.repository;

import com.codecool.solarwatch.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     void deleteByEmail(String email);
    boolean existsByEmail(String email);

    User findByEmail(String email);
}
