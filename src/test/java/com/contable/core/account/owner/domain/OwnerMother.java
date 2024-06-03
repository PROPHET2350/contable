package com.contable.core.account.owner.domain;

import com.contable.shared.domain.owners.OwnerCreated;
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
    public static Owner create(String id,String email, String identity) {
        var faker = new Faker();
        return Owner.create(
                id,
                faker.name().name(),
                faker.name().lastName(),
                email,
                identity,
                faker.internet().password());
    }

    public static OwnerCreated eventFromOwner(Owner owner) {
        return new OwnerCreated(UUID.randomUUID().toString(), owner.getEmail(), owner.getIdentity());
    }
}
