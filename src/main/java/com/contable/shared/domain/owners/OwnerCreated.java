package com.contable.shared.domain.owners;

import com.contable.shared.domain.bus.DomainEvent;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

public class OwnerCreated extends DomainEvent {
    private final String ownerEmail;

    public OwnerCreated(
            String aggregateId,
            String ownerEmail
    ) {
        super(
                aggregateId,
                UUID.randomUUID().toString(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
        );
        this.ownerEmail = ownerEmail;
    }


    @Override
    public String eventName() {
        return "contable.account.owner.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return null;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }
}
