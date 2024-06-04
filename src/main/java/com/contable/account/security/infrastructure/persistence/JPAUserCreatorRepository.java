package com.contable.account.security.infrastructure.persistence;

import com.contable.account.security.domain.User;
import com.contable.account.security.domain.UserCreatorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JPAUserCreatorRepository implements UserCreatorRepository {

    private final JPAImplUserRepository repository;

    public JPAUserCreatorRepository(JPAImplUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.repository.findByUsername(username);
    }
}
