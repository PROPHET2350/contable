package com.contable.backoffice.companies.leads.domain;

import java.util.Optional;

public interface LeadsFinderRepository {

    Optional<Lead> findById(String id);
}
