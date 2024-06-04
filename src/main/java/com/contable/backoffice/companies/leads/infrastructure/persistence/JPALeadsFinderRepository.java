package com.contable.backoffice.companies.leads.infrastructure.persistence;

import com.contable.backoffice.companies.leads.domain.Lead;
import com.contable.backoffice.companies.leads.domain.LeadsFinderRepository;

import java.util.Optional;

public class JPALeadsFinderRepository implements LeadsFinderRepository {

    private final JPAImplLeadsRepository repository;

    public JPALeadsFinderRepository(JPAImplLeadsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Lead> findById(String id) {
        return repository.findById(id);
    }
}
