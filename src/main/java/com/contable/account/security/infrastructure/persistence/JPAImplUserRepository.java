package com.contable.account.security.infrastructure.persistence;

import com.contable.account.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPAImplUserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}