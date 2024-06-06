package com.contable.backoffice.security.roles.domain;

import java.util.List;
import java.util.Optional;

public interface RolesFinderRepository {
    List<Role> getAll();

    Optional<Role> findById(String id);
}
