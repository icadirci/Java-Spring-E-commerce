package com.shoppro.shoppro_auth.repository;

import com.shoppro.shoppro_auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findById(int id);
    Optional<User> findByUsername(String username);
}
