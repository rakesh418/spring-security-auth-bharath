package com.lex418.couponservice.repo;

import com.lex418.couponservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findUserByEmail(String email);
}
