package com.contable.backoffice.security.employee.domain;

import java.util.Optional;

public interface EmployeeCreatorRepository {
    void save(Employees employees);

    Optional<Employees> findByEmail(String email);
}
