package com.contable.backoffice.security.roles.application;

import com.contable.backoffice.security.roles.domain.Role;
import com.contable.backoffice.security.roles.domain.RoleCreatorRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleCreateService {

    private final RoleCreatorRepository roleCreatorRepository;

    public RoleCreateService(RoleCreatorRepository roleCreatorRepository) {
        this.roleCreatorRepository = roleCreatorRepository;
    }

    public void save(Role role) {
        this.roleCreatorRepository.findByName(role.getName()).ifPresent(role1 -> {
                    throw new IllegalArgumentException("The name " + role.getName() + " is already taken");
                }
        );
        try {
            this.roleCreatorRepository.save(role);
        } catch (Exception e) {

        }
    }
}
