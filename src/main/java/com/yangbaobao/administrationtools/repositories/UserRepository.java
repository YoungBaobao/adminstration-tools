package com.yangbaobao.administrationtools.repositories;

import com.yangbaobao.administrationtools.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // find user by email address
    Optional<User> findByEmail(String email);
}
