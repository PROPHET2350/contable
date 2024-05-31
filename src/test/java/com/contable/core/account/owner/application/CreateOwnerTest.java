package com.contable.core.account.owner.application;

import com.contable.core.account.owner.domain.Owner;
import com.contable.core.account.owner.domain.OwnerCreateRepository;
import com.contable.core.account.owner.domain.OwnerMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreateOwnerTest {
    
    @Autowired
    private OwnerCreateRepository ownerCreateRepository;


    @Test
    void create_valid_owner() {
        Owner owner = OwnerMother.random("jorge@gmail.com", "1757568637");
        ownerCreateRepository.save(owner);
        ownerCreateRepository.findByEmailOrIdentity("jorge@gmail.com", "1757568637");
        Assertions.assertTrue(ownerCreateRepository.findByEmailOrIdentity("jorge@gmail.com", "1757568637").isPresent());
    }

    @Test
    void create_owner_with_taken_email() {
    }

    @Test
    void create_owner_with_taken_identity() {
    }
}