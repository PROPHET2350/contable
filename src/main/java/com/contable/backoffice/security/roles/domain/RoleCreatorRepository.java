package com.contable.backoffice.security.roles.domain;

import java.util.Optional;

public interface RoleCreatorRepository {
    void save(Role role);

    Optional<Role> findByName(String name);
}
