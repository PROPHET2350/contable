package com.contable.account.companies.application;

import com.contable.account.companies.domain.Company;
import com.contable.account.companies.domain.CompanyCreatorRepository;
import com.contable.account.companies.domain.CompanyMother;
import com.contable.account.companies.domain.IdentityTakenException;
import com.contable.account.owner.domain.OwnerMother;
import com.contable.shared.domain.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreateCompanyTest extends UnitTest {

    private CreateCompany createCompany;
    private CompanyCreatorRepository repository;

    @BeforeEach
    public void setup() {
        repository = Mockito.mock(CompanyCreatorRepository.class);
        createCompany = new CreateCompany(repository, eventBus);
    }

    @Test
    void create_a_valid_company() {
        Company company = CompanyMother.random("1757568637001", OwnerMother.random("1757568637"));
        createCompany.save(company);
        Mockito.verify(repository, Mockito.atLeastOnce()).save(company);
    }

    @Test
    void create_a_company_with_taken_identity() {
        Company company = CompanyMother.random("1757568637001", OwnerMother.random("1757568637"));
        Company company2 = CompanyMother.random("1757568637001", OwnerMother.random("1757568637"));
        createCompany.save(company);
        createCompany.save(company2);
        Mockito.when(createCompany).thenThrow(IdentityTakenException.class);
    }
}