package com.contable.backoffice.companies.leads.domain;

import com.contable.account.companies.domain.Company;
import com.contable.shared.domain.AggregateRoot;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name = "backoffice_leads", schema = "PUBLIC")
public class Lead extends AggregateRoot {

    @Id
    private String leadId;

    private String name;

    private String lastname;

    private String email;

    private String phone;

    @Type(JsonType.class)
    @Column(columnDefinition = "json", name = "company")
    private List<Company> company;

    private Boolean isSignUpload;

    private Boolean isFirstProductCreated;

    private Boolean isFirstSaleDone;

    protected Lead() {
    }

    public Lead(
            String leadId,
            String name,
            String lastname,
            String email,
            String phone,
            List<Company> company,
            Boolean isSignUpload,
            Boolean isFirstProductCreated,
            Boolean isFirstSaleDone
    ) {
        this.leadId = leadId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.isSignUpload = isSignUpload;
        this.isFirstProductCreated = isFirstProductCreated;
        this.isFirstSaleDone = isFirstSaleDone;
    }

}
