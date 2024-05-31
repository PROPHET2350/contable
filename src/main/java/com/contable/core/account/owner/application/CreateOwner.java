package com.contable.core.account.owner.application;

import com.contable.core.account.owner.domain.Owner;
import com.contable.core.account.owner.domain.OwnerAlreadyCreateException;
import com.contable.core.account.owner.domain.OwnerCreateRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateOwner {

    private final OwnerCreateRepository ownerCreateRepository;

    public CreateOwner(OwnerCreateRepository ownerCreateRepository) {
        this.ownerCreateRepository = ownerCreateRepository;
    }

    public void save(Owner owner) {
        this.ownerCreateRepository.findByEmailOrIdentity(owner.getEmail(), owner.getIdentity()).ifPresent(
                owner1 -> {
                    var message = owner1.getEmail().equals(owner.getEmail()) ? "The email " + owner.getEmail() + " is already exists" :
                            "The identity " + owner.getIdentity() + " is already exists";
                    throw new OwnerAlreadyCreateException(message);
                }
        );
        try {
            ownerCreateRepository.save(owner);
        } catch (Exception e) {

        }
    }
}
