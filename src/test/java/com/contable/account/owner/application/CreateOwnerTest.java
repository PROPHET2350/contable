package com.contable.account.owner.application;

import com.contable.account.owner.domain.Owner;
import com.contable.account.owner.domain.OwnerAlreadyCreateException;
import com.contable.account.owner.domain.OwnerCreateRepository;
import com.contable.account.owner.domain.OwnerMother;
import com.contable.shared.domain.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreateOwnerTest extends UnitTest {

    private CreateOwner creator;
    private OwnerCreateRepository ownerCreateRepository;

    @BeforeEach
    public void setup() {
        ownerCreateRepository = Mockito.mock(OwnerCreateRepository.class);
        creator = new CreateOwner(ownerCreateRepository, eventBus);
    }


    @Test
    void create_valid_owner() {
        Owner owner = OwnerMother.random("jorge@gmail.com");
        creator.save(owner);
        Mockito.verify(ownerCreateRepository, Mockito.atLeastOnce()).save(owner);
    }

    @Test()
    void create_owner_with_taken_email() {
        Owner owner = OwnerMother.random("jorge@gmail.com");
        Owner owner2 = OwnerMother.random("jorge@gmail.com");
        creator.save(owner);
        creator.save(owner2);
        Mockito.when(creator).thenThrow(OwnerAlreadyCreateException.class);
    }

    @Test
    void create_owner_with_taken_identity() {
        Owner owner = OwnerMother.random("jorge@gmail.com");
        Owner owner2 = OwnerMother.random("luis@gmail.com");
        creator.save(owner);
        creator.save(owner2);
        Mockito.when(creator).thenThrow(OwnerAlreadyCreateException.class);
    }
}