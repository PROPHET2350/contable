package com.contable.account.companies.infrastructure.persistence;

import com.contable.account.companies.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPAImplCompanyRepository extends JpaRepository<Company, String> {
    Optional<Company> findByIdentity(String identity);
}