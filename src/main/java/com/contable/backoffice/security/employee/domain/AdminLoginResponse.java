package com.contable.backoffice.security.employee.domain;

public class AdminLoginResponse {
    public String token;

    public Employees profile;

    public AdminLoginResponse(String token, Employees profile) {
        this.token = token;
        this.profile = profile;
    }
}
