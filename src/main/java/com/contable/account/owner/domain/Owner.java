package com.contable.account.owner.domain;

import com.contable.shared.domain.AggregateRoot;
import com.contable.shared.domain.owners.OwnerCreated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "account_owner", schema = "PUBLIC")
public class Owner extends AggregateRoot {

    @Id
    private String id;

    private String name;

    private String lastname;

    private String email;

    private String phone;

    protected Owner() {
    }

    public Owner(
            String id,
            String name,
            String lastname,
            String email,
            String phone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

    public static Owner create(
            String id,
            String name,
            String lastname,
            String email,
            String phone
    ) {
        var owner = new Owner(id, name, lastname, email, phone);
        owner.record(new OwnerCreated(id, email));
        return owner;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id) && Objects.equals(name, owner.name) && Objects.equals(lastname, owner.lastname) && Objects.equals(email, owner.email) && Objects.equals(phone, owner.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, email, phone);
    }
}
