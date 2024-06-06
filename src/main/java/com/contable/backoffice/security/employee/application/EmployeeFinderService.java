package com.contable.backoffice.security.employee.application;

import com.contable.backoffice.security.employee.domain.EmployeeFinderRepository;
import com.contable.backoffice.security.employee.domain.Employees;
import com.contable.shared.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeFinderService {

    private final EmployeeFinderRepository finder;

    public EmployeeFinderService(EmployeeFinderRepository finder) {
        this.finder = finder;
    }

    public Employees findById(String id) {
        return this.finder.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("The employee with id " + id + " does not exist")
        );
    }

    public List<Employees> getAll() {
        return this.finder.getAll();
    }
}
