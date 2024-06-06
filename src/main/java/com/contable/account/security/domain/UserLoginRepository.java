package com.contable.account.security.domain;

public interface UserLoginRepository {
    LoginResponse login(String username, String password);
}
