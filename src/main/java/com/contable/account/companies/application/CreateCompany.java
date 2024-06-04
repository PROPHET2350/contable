package com.contable.account.companies.application;

import com.contable.account.companies.domain.Company;
import com.contable.account.companies.domain.CompanyCreatorRepository;
import com.contable.account.companies.domain.IdentityTakenException;
import com.contable.account.owner.application.CreateOwner;
import com.contable.shared.domain.bus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateCompany {

    private final CompanyCreatorRepository repository;
    private final EventBus bus;

    public CreateCompany(CompanyCreatorRepository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public void save(Company company) {
        if (this.repository.findByIdentity(company.getIdentity()).isPresent())
            throw new IdentityTakenException("The identity " + company.getIdentity() + " is already taken");
        try {

            this.repository.save(company);
            bus.publish(company.pullDomainEvents());
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(CreateOwner.class);
        }

    }

}
