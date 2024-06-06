package com.contable.account.companies.infrastructure.httpControllers;

import com.contable.account.companies.domain.Company;
import com.contable.account.owner.domain.Owner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CompanyRequest {
    public String id;

    public String commercialName;

    @NotBlank(message = "The business name is required")
    public String businessName;

    @NotBlank(message = "The identity name is required")
    public String identity;

    @NotBlank(message = "The address name is required")
    public String address;

    public Boolean isAccountingForce = false;

    public String rimpe;

    @NotNull(message = "The owner name is required")
    public Owner owner;

    public CompanyRequest() {
    }

    public CompanyRequest(
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

    public Company toDomain() {
        return Company.create(
                id != null ? id : UUID.randomUUID().toString(),
                commercialName,
                businessName,
                identity,
                address,
                isAccountingForce,
                rimpe,
                owner
        );
    }

    @Override
    public String toString() {
        return "CompanyRequest{" +
                "id='" + id + '\'' +
                ", commercialName='" + commercialName + '\'' +
                ", businessName='" + businessName + '\'' +
                ", identity='" + identity + '\'' +
                ", address='" + address + '\'' +
                ", isAccountingForce=" + isAccountingForce +
                ", rimpe='" + rimpe + '\'' +
                ", owner=" + owner +
                '}';
    }
}
