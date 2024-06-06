package com.contable.backoffice.security.employee.domain;

public interface EmployeeLoginRepository {
    AdminLoginResponse login(String username, String password);
}
