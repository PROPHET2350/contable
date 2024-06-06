package com.contable.backoffice.security.employee.infrastructure.persistence;

import com.contable.backoffice.security.employee.domain.EmployeeCreatorRepository;
import com.contable.backoffice.security.employee.domain.Employees;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JPAEmployeeCreatorRepository implements EmployeeCreatorRepository {

    private final JPAImplEmployeesRepository jpaImplEmployeesRepository;

    public JPAEmployeeCreatorRepository(JPAImplEmployeesRepository jpaImplEmployeesRepository) {
        this.jpaImplEmployeesRepository = jpaImplEmployeesRepository;
    }

    @Override
    public void save(Employees employees) {
        this.jpaImplEmployeesRepository.save(employees);
    }

    @Override
    public Optional<Employees> findByEmail(String email) {
        return this.jpaImplEmployeesRepository.findByEmail(email);
    }
}
