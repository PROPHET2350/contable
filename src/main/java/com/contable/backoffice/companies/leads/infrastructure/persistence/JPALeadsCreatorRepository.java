package com.contable.backoffice.companies.leads.infrastructure.persistence;

import com.contable.backoffice.companies.leads.domain.Lead;
import com.contable.backoffice.companies.leads.domain.LeadsCreatorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JPALeadsCreatorRepository implements LeadsCreatorRepository {

    private final JPAImplLeadsRepository repository;

    public JPALeadsCreatorRepository(JPAImplLeadsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Lead lead) {
        this.repository.save(lead);
    }

    @Override
    public Optional<Lead> findById(String id) {
        return repository.findById(id);
    }
}
