package com.contable.backoffice.companies.leads.domain;

import com.contable.shared.domain.AggregateRoot;
import com.contable.shared.domain.leads.LeadsCreated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "backoffice_leads")
public class Lead extends AggregateRoot {

    @Id
    private String leadId;

    private String name;

    private String lastname;

    private String email;

    private String identity;

    private String password;

    protected Lead() {
    }

    protected Lead(
            String leadId,
            String name,
            String lastname,
            String email,
            String identity
    ) {
        this.leadId = leadId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.identity = identity;
    }

    public static Lead create(
            String leadId,
            String name,
            String lastname,
            String email,
            String identity
    ) {
        var lead = new Lead(leadId, name, lastname, email, identity);
        lead.record(new LeadsCreated(leadId, email, identity));
        return lead;
    }
}
