package com.contable.core.account.owner.domain;

import com.contable.shared.domain.AggregateRoot;
import com.contable.shared.domain.owners.OwnerCreated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "core_owner")
public class Owner extends AggregateRoot {

    @Id
    private String id;

    private String name;

    private String lastname;

    private String email;

    private String identity;

    private String password;

    private Owner() {
    }

    public Owner(String id, String name, String lastname, String email, String identity, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.identity = identity;
        this.password = password;
    }

    public static Owner create(
            String id,
            String name,
            String lastname,
            String email,
            String identity,
            String password
    ) {
        var owner = new Owner(id, name, lastname, email, identity, password);
        owner.record(new OwnerCreated(id, email, identity));
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

    public String getIdentity() {
        return identity;
    }
}
