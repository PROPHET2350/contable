package com.contable.backoffice.security.employee.domain;

public interface EmployeeMutationRepository {

    void update(Employees employees);

    void deleteById(String id);
}
