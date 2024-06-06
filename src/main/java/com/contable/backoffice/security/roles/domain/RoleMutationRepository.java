package com.contable.backoffice.security.roles.domain;

public interface RoleMutationRepository {

    void update(Role role);

    void deleteById(String id);
}
