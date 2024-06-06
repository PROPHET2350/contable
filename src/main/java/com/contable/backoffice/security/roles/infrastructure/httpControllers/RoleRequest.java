package com.contable.backoffice.security.roles.infrastructure.httpControllers;

import com.contable.backoffice.security.permissions.domain.Permission;
import com.contable.backoffice.security.roles.domain.Role;

import java.util.Set;

public class RoleRequest {
    public String id;
    public String name;
    public Set<Permission> permissions;

    public RoleRequest(
            String id,
            String name,
            Set<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }

    public Role toDomain() {
        return new Role(id, name, permissions, true);
    }

    public RoleRequest() {
    }
}
