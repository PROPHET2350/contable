package com.contable.account.security.application;

import com.contable.account.security.domain.LoginResponse;
import com.contable.account.security.domain.UserLoginRepository;
import org.springframework.stereotype.Service;

@Service
public class UserLogin {

    private final UserLoginRepository repository;

    public UserLogin(UserLoginRepository repository) {
        this.repository = repository;
    }

    public LoginResponse login(String username, String password) {
        return this.repository.login(username, password);
    }
}
