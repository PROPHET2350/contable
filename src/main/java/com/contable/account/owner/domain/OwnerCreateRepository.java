package com.contable.account.owner.domain;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerCreateRepository {
    void save(Owner owner);

    Optional<Owner> findByEmail(String email);
}
