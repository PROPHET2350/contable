package com.contable.core.account.owner.infrastructure.peristence;

import com.contable.core.account.owner.domain.Owner;
import com.contable.core.account.owner.domain.OwnerCreateRepository;
import com.contable.core.account.owner.domain.OwnerMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class JPAOwnerCreateRepositoryTest {

    @Autowired
    private OwnerCreateRepository repository;
    Owner owner = OwnerMother.create("id", "jorge@gmail.com", "1757568637");

    @Test
    void create_a_valid_owner() {
        repository.save(owner);
        System.out.println(owner.getId());
    }

    @Test
    void return_an_existing_owner() {
        repository.save(owner);
        Assertions.assertEquals(Optional.of(owner), repository.findByEmailOrIdentity(owner.getEmail(), owner.getIdentity()));
    }

    @Test
    void return_not_existing_owner() {
        System.out.println(owner.getId());
        Assertions.assertFalse(repository.findByEmailOrIdentity("jorgse@gmail.com", "17575686337").isPresent());
    }
}