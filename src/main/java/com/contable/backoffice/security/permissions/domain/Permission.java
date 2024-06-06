package com.contable.backoffice.security.permissions.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "back_office_permissions", schema = "PUBLIC")
public class Permission {

    @Id
    private String id;

    private String displayName;

    private String description;

    private String permissionName;

    protected Permission() {
    }

    public Permission(
            String id,
            String displayName,
            String description,
            String permissionName
    ) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
        this.permissionName = permissionName;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public String getPermissionName() {
        return permissionName;
    }
}

