package com.contable.account.owner.infrastructure.peristence;

import com.contable.account.owner.domain.Owner;
import com.contable.account.owner.domain.OwnerCreateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JPAOwnerCreateRepository implements OwnerCreateRepository {

    private final JPAImplOwnerRepository jpaImplOwnerRepository;

    public JPAOwnerCreateRepository(JPAImplOwnerRepository jpaImplOwnerRepository) {
        this.jpaImplOwnerRepository = jpaImplOwnerRepository;
    }


    @Override
    public void save(Owner owner) {
        this.jpaImplOwnerRepository.save(owner);
    }

    @Override
    public Optional<Owner> findByEmail(String email) {
        return this.jpaImplOwnerRepository.findFirstByEmail(email);
    }
}
