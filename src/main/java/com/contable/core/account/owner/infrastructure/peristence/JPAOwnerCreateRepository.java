package com.contable.core.account.owner.infrastructure.peristence;

import com.contable.core.account.owner.domain.Owner;
import com.contable.core.account.owner.domain.OwnerCreateRepository;
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
    public Optional<Owner> findByEmailOrIdentity(String email, String identity) {
        return this.jpaImplOwnerRepository.findFirstByEmailOrIdentity(email, identity);
    }
}
