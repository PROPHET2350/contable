package com.contable.account.security.application;

import com.contable.account.owner.domain.OwnerFinderRepository;
import com.contable.account.security.domain.User;
import com.contable.account.security.domain.UserCreatorRepository;
import com.contable.shared.domain.bus.DomainEventSubscriber;
import com.contable.shared.domain.owners.OwnerCreated;
import net.datafaker.Faker;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@DomainEventSubscriber({OwnerCreated.class})
public class CreateUserOnOwnerCreated {

    private final UserCreatorRepository repository;
    private final OwnerFinderRepository ownerFinderRepository;
    private final PasswordEncoder encoder;

    public CreateUserOnOwnerCreated(
            UserCreatorRepository repository,
            OwnerFinderRepository ownerFinderRepository,
            PasswordEncoder encoder
    ) {
        this.repository = repository;
        this.ownerFinderRepository = ownerFinderRepository;
        this.encoder = encoder;
    }

    @EventListener
    public void on(OwnerCreated event) {
        if (this.repository.findByUsername(event.getOwnerEmail()).isEmpty()) {
            var owner = this.ownerFinderRepository.findOwnerById(event.aggregateId()).orElseThrow();
            Faker faker = new Faker();
            var pass = faker.internet().password();
            System.out.println("user password --------: " + pass);
            this.repository.save(new User(owner.getId(), owner.getEmail(), encoder.encode("asd"), new HashSet<>()));
        }
    }
}
