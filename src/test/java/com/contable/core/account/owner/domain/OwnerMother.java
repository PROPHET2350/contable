package com.contable.core.account.owner.domain;

import net.datafaker.Faker;

import java.util.UUID;

public class OwnerMother {

    public static Owner random(String email, String identity) {
        var faker = new Faker();
        return Owner.create(
                UUID.randomUUID().toString(),
                faker.name().name(),
                faker.name().lastName(),
                email,
                identity,
                faker.internet().password());
    }
}
