package com.contable.backoffice.companies.leads.applications;

import com.contable.account.companies.domain.CompanyCreatorRepository;
import com.contable.backoffice.companies.leads.domain.LeadsCreatorRepository;
import com.contable.shared.domain.bus.DomainEventSubscriber;
import com.contable.shared.domain.companies.CompanyCreated;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@DomainEventSubscriber({CompanyCreated.class})
public class PutCompanyOnCompanyCreated {

    private final LeadsCreatorRepository leadsCreatorRepository;
    private final CompanyCreatorRepository companyCreatorRepository;

    public PutCompanyOnCompanyCreated(LeadsCreatorRepository leadsCreatorRepository,
                                      CompanyCreatorRepository companyCreatorRepository) {
        this.leadsCreatorRepository = leadsCreatorRepository;
        this.companyCreatorRepository = companyCreatorRepository;
    }

    @EventListener
    public void on(CompanyCreated event) {
        var company = companyCreatorRepository.findByIdentity(event.getIdentity()).orElseThrow();
        var lead = leadsCreatorRepository.findById(company.getOwnerId()).orElseThrow();
        lead.addCompany(company);
        this.leadsCreatorRepository.save(lead);
    }
}
