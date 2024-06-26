package com.contable.backoffice.companies.leads.domain;

import java.util.Optional;

public interface LeadsCreatorRepository {

    void save(Lead lead);

    Optional<Lead> findById(String id);
}
