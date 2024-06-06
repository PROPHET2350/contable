package com.contable.account.security.domain;

public class LoginResponse {

    public String token;

    public User user;

    public LoginResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public LoginResponse() {
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", user=" + user.toString() +
                '}';
    }
}
