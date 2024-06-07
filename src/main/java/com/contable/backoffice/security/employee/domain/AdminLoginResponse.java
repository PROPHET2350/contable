package com.contable.backoffice.security.employee.domain;

public class AdminLoginResponse {
    public String token;

    public Employees user;

    public AdminLoginResponse(String token, Employees user) {
        this.token = token;
        this.user = user;
    }
}
