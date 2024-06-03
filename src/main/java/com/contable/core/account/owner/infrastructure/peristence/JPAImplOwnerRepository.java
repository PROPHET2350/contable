package com.contable.core.account.owner.infrastructure.peristence;

import com.contable.core.account.owner.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface JPAImplOwnerRepository extends JpaRepository<Owner, String>, JpaSpecificationExecutor<Owner> {
    Optional<Owner> findFirstByEmailOrIdentity(String email, String identity);
}