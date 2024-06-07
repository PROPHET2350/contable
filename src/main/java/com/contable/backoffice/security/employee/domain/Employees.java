package com.contable.backoffice.security.employee.domain;

import com.contable.backoffice.security.roles.domain.Role;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "back_office_employees", schema = "PUBLIC")
public class Employees {
    @Id
    private String id;

    private String name;

    private String email;

    private String phone;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "back_office_roles_employees",
            schema = "PUBLIC",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    protected Employees() {
    }

    private Employees(
            String id,
            String name,
            String email,
            String phone,
            String password,
            Set<Role> roles
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roles = roles;
    }

    public static Employees create(
            String id,
            String name,
            String email,
            String phone,
            String password,
            Set<Role> roles
    ) {
        return new Employees(
                id,
                name,
                email,
                phone,
                password,
                roles
        );
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
