package com.contable.shared.domain.leads;

import com.contable.shared.domain.bus.DomainEvent;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;


public class LeadsCreated extends DomainEvent {

    private final String leadsEmail;
    private final String leadsRuc;

    public LeadsCreated(
            String aggregateId,
            String leadsEmail,
            String leadsRuc
    ) {
        super(
                aggregateId,
                UUID.randomUUID().toString(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
        );
        this.leadsEmail = leadsEmail;
        this.leadsRuc = leadsRuc;
    }

    @Override
    public String eventName() {
        return "contable.backoffice.leads.create";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return null;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }

    public String getLeadsEmail() {
        return leadsEmail;
    }

    public String getLeadsRuc() {
        return leadsRuc;
    }
}
