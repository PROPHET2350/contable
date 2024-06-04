package com.contable.account.companies.infrastructure.persistence;

import com.contable.account.companies.domain.Company;
import com.contable.account.companies.domain.CompanyCreatorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JPACompanyCreatorRepository implements CompanyCreatorRepository {

    private final JPAImplCompanyRepository repository;

    public JPACompanyCreatorRepository(JPAImplCompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Company company) {
        this.repository.save(company);
    }

    @Override
    public Optional<Company> findByIdentity(String identity) {
        return this.repository.findByIdentity(identity);
    }
}
