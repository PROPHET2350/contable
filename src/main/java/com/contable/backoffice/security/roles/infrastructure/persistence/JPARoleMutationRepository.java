package com.contable.backoffice.security.roles.infrastructure.persistence;

import com.contable.backoffice.security.roles.domain.Role;
import com.contable.backoffice.security.roles.domain.RoleMutationRepository;
import org.springframework.stereotype.Service;

@Service
public class JPARoleMutationRepository implements RoleMutationRepository {

    private final JPAImplRoleRepository jpaImplRoleRepository;

    public JPARoleMutationRepository(JPAImplRoleRepository jpaImplRoleRepository) {
        this.jpaImplRoleRepository = jpaImplRoleRepository;
    }

    @Override
    public void update(Role role) {
        this.jpaImplRoleRepository.save(role);
    }

    @Override
    public void deleteById(String id) {
        this.jpaImplRoleRepository.deleteById(id);
    }
}
