package com.contable.backoffice.security.employee.infrastructure.persistence;

import com.contable.backoffice.security.employee.domain.EmployeeFinderRepository;
import com.contable.backoffice.security.employee.domain.Employees;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPAEmployeeFinderRepository implements EmployeeFinderRepository {

    private final JPAImplEmployeesRepository repository;

    public JPAEmployeeFinderRepository(JPAImplEmployeesRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Employees> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Employees> findById(String id) {
        return this.repository.findById(id);
    }
}
