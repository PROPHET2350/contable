package com.contable.backoffice.companies.leads.applications;

import com.contable.account.owner.domain.OwnerFinderRepository;
import com.contable.backoffice.companies.leads.domain.Lead;
import com.contable.backoffice.companies.leads.domain.LeadsCreatorRepository;
import com.contable.shared.domain.bus.DomainEventSubscriber;
import com.contable.shared.domain.owners.OwnerCreated;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@DomainEventSubscriber({OwnerCreated.class})
public class CreateLeadsOnOwnerCreated {

    private final LeadsCreatorRepository leadsCreatorRepository;
    private final OwnerFinderRepository ownerFinderRepository;

    public CreateLeadsOnOwnerCreated(
            LeadsCreatorRepository leadsCreatorRepository,
            OwnerFinderRepository ownerFinderRepository
    ) {
        this.leadsCreatorRepository = leadsCreatorRepository;
        this.ownerFinderRepository = ownerFinderRepository;
    }

    @EventListener
    public void on(OwnerCreated event) {
        var owner = this.ownerFinderRepository.findOwnerById(event.aggregateId()).orElseThrow();
        this.leadsCreatorRepository.save(new Lead(
                owner.getId(),
                owner.getName(),
                owner.getLastname(),
                owner.getEmail(),
                owner.getPhone(),
                Collections.emptyList(),
                false,
                false,
                false
        ));
    }

}
