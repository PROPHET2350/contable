package com.contable.backoffice.security.employee.domain;

import com.contable.backoffice.security.roles.domain.Role;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "back_office_employees", schema = "PUBLIC")
public class Employees {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "back_office_roles_employees",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    protected Employees() {
    }

    private Employees(
            String id,
            String firstName,
            String lastName,
            String email,
            String phone,
            String password,
            Set<Role> roles
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roles = roles;
    }

    public static Employees create(
            String id,
            String firstName,
            String lastName,
            String email,
            String phone,
            String password,
            Set<Role> roles
    ) {
        return new Employees(
                id,
                firstName,
                lastName,
                email,
                phone,
                password,
                roles
        );
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
