package com.contable.account.owner.infrastructure.peristence;

import com.contable.account.owner.domain.Owner;
import com.contable.account.owner.domain.OwnerFinderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPAOwnerFinderRepository implements OwnerFinderRepository {
    private final JPAImplOwnerRepository repository;

    public JPAOwnerFinderRepository(JPAImplOwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Owner> findOwnerById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Owner> getAll() {
        return this.repository.findAll();
    }
}
