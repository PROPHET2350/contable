package com.contable.account.owner.application;

import com.contable.account.owner.domain.Owner;
import com.contable.account.owner.domain.OwnerAlreadyCreateException;
import com.contable.account.owner.domain.OwnerCreateRepository;
import com.contable.shared.domain.bus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateOwner {

    private final OwnerCreateRepository ownerCreateRepository;
    private final EventBus bus;
    Logger logger = LoggerFactory.getLogger(CreateOwner.class);

    public CreateOwner(OwnerCreateRepository ownerCreateRepository, EventBus bus) {
        this.ownerCreateRepository = ownerCreateRepository;
        this.bus = bus;
    }

    public void save(Owner owner) {
        if (this.ownerCreateRepository.findByEmail(owner.getEmail()).isPresent())
            throw new OwnerAlreadyCreateException("The email " + owner.getEmail() + " is already exists");
        try {
            ownerCreateRepository.save(owner);
            bus.publish(owner.pullDomainEvents());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
