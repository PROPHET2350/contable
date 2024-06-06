package com.contable.backoffice.security.roles.infrastructure.persistence;

import com.contable.backoffice.security.roles.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPAImplRoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(String name);
}