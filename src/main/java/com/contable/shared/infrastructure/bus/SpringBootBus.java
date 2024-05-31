package com.contable.shared.infrastructure.bus;

import com.contable.shared.domain.bus.DomainEvent;
import com.contable.shared.domain.bus.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringBootBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    public SpringBootBus(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent event){
        this.publisher.publishEvent(event);
    }
}
