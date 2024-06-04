package com.contable.account.companies.infrastructure.persistence;

import com.contable.account.companies.domain.Company;
import com.contable.account.companies.domain.CompanyCreatorRepository;
import com.contable.account.companies.domain.CompanyMother;
import com.contable.account.owner.domain.Owner;
import com.contable.account.owner.domain.OwnerCreateRepository;
import com.contable.account.owner.domain.OwnerMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JPACompanyCreatorRepositoryTest {

    @Autowired
    private CompanyCreatorRepository repository;

    @Autowired
    private OwnerCreateRepository ownerRepository;

    Owner owner = OwnerMother.random("jorgeluis33ariosa@gmail.com");
    Company company = CompanyMother.random("1757568637001", owner);

    @Test
    void create_a_valid_company() {
        this.ownerRepository.save(owner);
        this.repository.save(company);
        Assertions.assertTrue(this.repository.findByIdentity(company.getIdentity()).isPresent());
    }

    @Test
    void return_not_existing_company() {
        Assertions.assertFalse(this.repository.findByIdentity("29841616").isPresent());
    }
}