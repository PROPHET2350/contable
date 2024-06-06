package com.contable.backoffice.security.permissions.infrastructure;

import com.contable.backoffice.security.permissions.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAImplPermissionRepository extends JpaRepository<Permission, String> {
}