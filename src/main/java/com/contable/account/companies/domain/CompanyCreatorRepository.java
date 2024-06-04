package com.contable.account.companies.domain;

import java.util.Optional;

public interface CompanyCreatorRepository {
    void save(Company company);

    Optional<Company> findByIdentity(String identity);
}
