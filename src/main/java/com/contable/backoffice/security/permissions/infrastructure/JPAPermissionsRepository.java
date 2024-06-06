package com.contable.backoffice.security.permissions.infrastructure;

import com.contable.backoffice.security.permissions.domain.Permission;
import org.springframework.stereotype.Service;

@Service
public class JPAPermissionsRepository {

    private final JPAImplPermissionRepository jpaImplPermissionRepository;

    public JPAPermissionsRepository(JPAImplPermissionRepository jpaImplPermissionRepository) {
        this.jpaImplPermissionRepository = jpaImplPermissionRepository;
    }

    public void save(Permission permission) {
        this.jpaImplPermissionRepository.save(permission);
    }
}
