package com.contable.backoffice.security.roles.infrastructure.persistence;

import com.contable.backoffice.security.roles.domain.Role;
import com.contable.backoffice.security.roles.domain.RoleCreatorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JPARoleCreatorRepository implements RoleCreatorRepository {

    private final JPAImplRoleRepository jpaImplRoleRepository;

    public JPARoleCreatorRepository(JPAImplRoleRepository jpaImplRoleRepository) {
        this.jpaImplRoleRepository = jpaImplRoleRepository;
    }

    @Override
    public void save(Role role) {
        this.jpaImplRoleRepository.save(role);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return this.jpaImplRoleRepository.findByName(name);
    }
}
