package com.contable.backoffice.security.roles.application;

import com.contable.backoffice.security.roles.domain.Role;
import com.contable.backoffice.security.roles.domain.RoleMutationRepository;
import com.contable.backoffice.security.roles.domain.RolesFinderRepository;
import org.springframework.stereotype.Service;

@Service
public class MutationRoleService {

    private final RoleMutationRepository roleMutationRepository;
    private final RolesFinderRepository finder;

    public MutationRoleService(RoleMutationRepository roleMutationRepository, RolesFinderRepository finder) {
        this.roleMutationRepository = roleMutationRepository;
        this.finder = finder;
    }

    public void update(Role role) {
        finder.findById(role.getId()).orElseThrow(
                () -> new IllegalArgumentException("the role with id " + role.getId() + " does not exist")
        );
        this.roleMutationRepository.update(role);
    }

    public void deleteById(String id) {
        var role = finder.findById(id).orElseThrow(
                () -> new IllegalArgumentException("the role with id " + id + " does not exist")
        );

        if (!role.getDeletable())
            throw new IllegalArgumentException("the role " + role.getName() + " cannot be deleted");
        this.roleMutationRepository.deleteById(id);
    }
}
