package com.contable.account.security.application;

import com.contable.account.companies.domain.CompanyCreatorRepository;
import com.contable.account.security.domain.UserCreatorRepository;
import com.contable.shared.domain.bus.DomainEventSubscriber;
import com.contable.shared.domain.companies.CompanyCreated;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@DomainEventSubscriber({CompanyCreated.class})
public class AddCompanyToUserOnCompanyCreated {

    private final CompanyCreatorRepository companyCreatorRepository;
    private final UserCreatorRepository userCreatorRepository;

    public AddCompanyToUserOnCompanyCreated(CompanyCreatorRepository companyCreatorRepository, UserCreatorRepository userCreatorRepository) {
        this.companyCreatorRepository = companyCreatorRepository;
        this.userCreatorRepository = userCreatorRepository;
    }

    @EventListener
    public void on(CompanyCreated event) {
        var company = this.companyCreatorRepository.findByIdentity(event.getIdentity()).orElseThrow();
        var user = this.userCreatorRepository.findByUsername(company.getOwnerEmail());
        if (user.isPresent()) {
            user.get().addCompany(company);
            this.userCreatorRepository.save(user.get());
        }
    }

}
