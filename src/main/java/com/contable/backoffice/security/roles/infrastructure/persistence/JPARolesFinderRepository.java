package com.contable.backoffice.security.roles.infrastructure.persistence;

import com.contable.backoffice.security.roles.domain.Role;
import com.contable.backoffice.security.roles.domain.RolesFinderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPARolesFinderRepository implements RolesFinderRepository {

    private final JPAImplRoleRepository jpaImplRoleRepository;

    public JPARolesFinderRepository(JPAImplRoleRepository jpaImplRoleRepository) {
        this.jpaImplRoleRepository = jpaImplRoleRepository;
    }

    @Override
    public List<Role> getAll() {
        return this.jpaImplRoleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(String id) {
        return this.jpaImplRoleRepository.findById(id);
    }
}
