package com.contable.account.security.domain;

import java.util.Optional;

public interface UserCreatorRepository {

    void save(User user);

    Optional<User> findByUsername(String username);
}
