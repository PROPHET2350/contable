package com.contable.account.owner.infrastructure.peristence;

import com.contable.account.owner.domain.Owner;
import com.contable.account.owner.domain.OwnerCreateRepository;
import com.contable.account.owner.domain.OwnerMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class JPAOwnerCreateRepositoryTest {

    @Autowired
    private OwnerCreateRepository repository;

    Owner owner = OwnerMother.create("id", "jorge@gmail.com");

    @Test
    void create_a_valid_owner() {
        repository.save(owner);
        System.out.println(owner.getId());
    }

    @Test
    void return_an_existing_owner() {
        repository.save(owner);
        Assertions.assertEquals(Optional.of(owner), repository.findByEmail(owner.getEmail()));
    }

    @Test
    void return_not_existing_owner() {
        Assertions.assertFalse(repository.findByEmail("jorgse@gmail.com").isPresent());
    }
}