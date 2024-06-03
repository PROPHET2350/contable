package com.contable.shared.domain;

import com.contable.shared.domain.bus.DomainEvent;
import com.contable.shared.domain.bus.EventBus;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

public class UnitTest {
    protected EventBus eventBus;

    @BeforeEach
    protected void setUp() {
        eventBus = Mockito.mock(EventBus.class);
    }


    public void shouldHavePublished(List<DomainEvent> domainEvents) {
        Mockito.verify(eventBus, Mockito.atLeastOnce()).publish(domainEvents);
    }

    public void shouldHavePublished(DomainEvent domainEvent) {
        shouldHavePublished(Collections.singletonList(domainEvent));
    }
}
