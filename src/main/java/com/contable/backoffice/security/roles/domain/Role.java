package com.contable.backoffice.security.roles.domain;

import com.contable.backoffice.security.permissions.domain.Permission;
import com.contable.shared.domain.AggregateRoot;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "back_office_roles", schema = "PUBLIC")
public class Role extends AggregateRoot {

    @Id
    private String id;

    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "back_office_roles_permissions",
            schema = "PUBLIC",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions = new HashSet<>();

    private Boolean isDeletable;

    protected Role() {
    }

    public Role(
            String id,
            String name,
            Set<Permission> permissions,
            Boolean isDeletable
    ) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
        this.isDeletable = isDeletable;
    }

    public static Role create(
            String id,
            String name,
            Set<Permission> permissions,
            Boolean isDeletable
    ) {
        return new Role(
                id,
                name,
                permissions,
                isDeletable
        );
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Boolean getDeletable() {
        return isDeletable;
    }
}

