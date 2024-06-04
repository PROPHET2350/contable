package com.contable.account.owner.infrastructure.httpControllers;

import com.contable.account.owner.domain.Owner;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public class OwnerRequest {
    public String id;
    @NotBlank(message = "The name field is required")
    public String name;
    @NotBlank(message = "The last name field is required")
    public String lastname;
    @NotBlank(message = "The email field is required")
    @Email(message = "The email field is not valid")
    public String email;
    @NotBlank(message = "The phone field is required")
    @Pattern(regexp = "^[0-9]*$", message = "The phone field only accept digits")
    public String phone;

    public OwnerRequest() {
    }

    public Owner toDomain() {
        return Owner.create(id != null ? id : UUID.randomUUID().toString(), name, lastname, email, phone);
    }
}
