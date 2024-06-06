package com.contable.account.companies.domain;

import com.contable.account.owner.domain.Owner;
import com.contable.shared.domain.AggregateRoot;
import com.contable.shared.domain.companies.CompanyCreated;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "account_companies", schema = "PUBLIC")
@JsonSerialize
public class Company extends AggregateRoot implements Serializable {
    @Id
    private String id;

    private String commercialName;

    private String businessName;

    @Column(unique = true)
    private String identity;

    private String address;

    private Boolean isAccountingForce;

    private String rimpe;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @JsonIgnore
    private Owner owner;

    protected Company() {
    }

    private Company(
            String id,
            String commercialName,
            String businessName,
            String identity,
            String address,
            Boolean isAccountingForce,
            String rimpe,
            Owner owner
    ) {
        this.id = id;
        this.commercialName = commercialName;
        this.businessName = businessName;
        this.identity = identity;
        this.address = address;
        this.isAccountingForce = isAccountingForce;
        this.rimpe = rimpe;
        this.owner = owner;
    }

    public static Company create(
            String id,
            String commercialName,
            String businessName,
            String identity,
            String address,
            Boolean isAccountingForce,
            String rimpe,
            Owner owner
    ) {
        var company = new Company(
                id,
                commercialName,
                businessName,
                identity,
                address,
                isAccountingForce,
                rimpe,
                owner
        );
        company.record(new CompanyCreated(id, identity));
        return company;
    }

    public String getId() {
        return id;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getIdentity() {
        return identity;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getAccountingForce() {
        return isAccountingForce;
    }

    public String getRimpe() {
        return rimpe;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getOwnerId() {
        return owner.getId();
    }

    public String getOwnerEmail() {
        return owner.getEmail();
    }
}
