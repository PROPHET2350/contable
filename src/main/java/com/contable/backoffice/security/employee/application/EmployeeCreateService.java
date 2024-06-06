package com.contable.backoffice.security.employee.application;

import com.contable.backoffice.security.employee.domain.EmployeeCreatorRepository;
import com.contable.backoffice.security.employee.domain.Employees;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCreateService {

    private final EmployeeCreatorRepository creatorRepository;

    public EmployeeCreateService(EmployeeCreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }

    public void save(Employees employees) {
        if (this.creatorRepository.findByEmail(employees.getEmail()).isPresent())
            throw new IllegalArgumentException("The email " + employees.getEmail() + " is already taken");
        this.creatorRepository.save(employees);
    }
}
