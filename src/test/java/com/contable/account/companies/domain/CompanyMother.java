package com.contable.account.companies.domain;

import com.contable.account.owner.domain.Owner;
import net.datafaker.Faker;

import java.util.UUID;

public class CompanyMother {


    public static Company random(String identity, Owner owner) {
        var faker = new Faker();

        return Company.create(
                UUID.randomUUID().toString(),
                faker.name().name(),
                faker.funnyName().name(),
                identity,
                faker.address().fullAddress(),
                false,
                "",
                owner
        );
    }
}