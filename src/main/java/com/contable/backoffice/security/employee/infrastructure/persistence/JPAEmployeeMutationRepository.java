package com.contable.backoffice.security.employee.infrastructure.persistence;

import com.contable.backoffice.security.employee.domain.EmployeeMutationRepository;
import com.contable.backoffice.security.employee.domain.Employees;
import org.springframework.stereotype.Service;

@Service
public class JPAEmployeeMutationRepository implements EmployeeMutationRepository {

    private final JPAImplEmployeesRepository jpaImpl;

    public JPAEmployeeMutationRepository(JPAImplEmployeesRepository jpaImpl) {
        this.jpaImpl = jpaImpl;
    }

    @Override
    public void update(Employees employees) {
        jpaImpl.save(employees);
    }

    @Override
    public void deleteById(String id) {
        jpaImpl.deleteById(id);
    }
}
