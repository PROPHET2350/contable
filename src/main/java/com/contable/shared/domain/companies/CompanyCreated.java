package com.contable.shared.domain.companies;

import com.contable.shared.domain.bus.DomainEvent;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

public class CompanyCreated extends DomainEvent {

    private final String identity;

    public CompanyCreated(String aggregateId, String identity) {
        super(aggregateId, UUID.randomUUID().toString(), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
        this.identity = identity;
    }

    @Override
    public String eventName() {
        return "contable.account.company.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return null;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }

    public String getIdentity() {
        return identity;
    }
}
