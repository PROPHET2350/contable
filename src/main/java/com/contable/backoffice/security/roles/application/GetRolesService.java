package com.contable.backoffice.security.roles.application;

import com.contable.backoffice.security.roles.domain.Role;
import com.contable.backoffice.security.roles.domain.RolesFinderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetRolesService {

    private final RolesFinderRepository finder;

    public GetRolesService(RolesFinderRepository finder) {
        this.finder = finder;
    }

    public List<Role> getAll() {
        return this.finder.getAll();
    }

    public Role findById(String id) {
        return this.finder.findById(id).orElseThrow(
                () -> new IllegalArgumentException("The role with id " + id + " does not exist")
        );
    }
}
