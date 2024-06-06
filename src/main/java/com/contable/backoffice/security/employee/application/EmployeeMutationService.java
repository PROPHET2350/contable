package com.contable.backoffice.security.employee.application;

import com.contable.backoffice.security.employee.domain.EmployeeFinderRepository;
import com.contable.backoffice.security.employee.domain.EmployeeMutationRepository;
import com.contable.backoffice.security.employee.domain.Employees;
import com.contable.shared.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMutationService {

    private final EmployeeMutationRepository repository;
    private final EmployeeFinderRepository finder;

    public EmployeeMutationService(EmployeeMutationRepository repository, EmployeeFinderRepository finder) {
        this.repository = repository;
        this.finder = finder;
    }

    public void update(Employees employees) {
        finder.findById(employees.getId()).orElseThrow(
                () -> new ResourceNotFoundException("The employee with id " + employees.getId() + " does not exist")
        );
        repository.update(employees);
    }

    public void delete(String id) {
        finder.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("The employee with id " + id + " does not exist")
        );
        repository.deleteById(id);
    }
}
