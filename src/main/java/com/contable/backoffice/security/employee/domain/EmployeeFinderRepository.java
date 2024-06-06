package com.contable.backoffice.security.employee.domain;

import java.util.List;
import java.util.Optional;

public interface EmployeeFinderRepository {

    List<Employees> getAll();

    Optional<Employees> findById(String id);
}
