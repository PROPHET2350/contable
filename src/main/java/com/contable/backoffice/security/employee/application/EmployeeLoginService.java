package com.contable.backoffice.security.employee.application;

import com.contable.backoffice.security.employee.domain.AdminLoginResponse;
import com.contable.backoffice.security.employee.domain.EmployeeLoginRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeLoginService {

    private final EmployeeLoginRepository employeeLoginRepository;

    public EmployeeLoginService(EmployeeLoginRepository employeeLoginRepository) {
        this.employeeLoginRepository = employeeLoginRepository;
    }

    public AdminLoginResponse login(String email, String password) {
        return this.employeeLoginRepository.login(email, password);
    }
}
