package com.contable.account.owner.domain;

import java.util.List;
import java.util.Optional;

public interface OwnerFinderRepository {
    Optional<Owner> findOwnerById(String id);

    List<Owner> getAll();
}
