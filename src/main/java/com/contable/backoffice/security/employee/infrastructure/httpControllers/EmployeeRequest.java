package com.contable.backoffice.security.employee.infrastructure.httpControllers;

import com.contable.backoffice.security.employee.domain.Employees;
import com.contable.backoffice.security.roles.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.UUID;

public class EmployeeRequest {
    public String id = UUID.randomUUID().toString();
    @NotBlank(message = "The first name is required")
    public String firstName;
    @NotBlank(message = "The last name is required")
    public String lastName;
    @NotBlank(message = "The email is required")
    @Email(message = "The email is not valid")
    public String email;
    @NotBlank(message = "The phone is required")
    @Pattern(regexp = "^[0-9]*$", message = "The phone number only accept digits")
    public String phone;
    @NotEmpty(message = "The role cannot be empty")
    public Set<Role> roles;

    public EmployeeRequest() {
    }

    public Employees toDomain(PasswordEncoder passwordEncoder) {
        return Employees.create(id, firstName, lastName, email, phone, passwordEncoder.encode(email), roles);
    }

}
