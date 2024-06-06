package com.contable.backoffice.security.employee.infrastructure.persistence;

import com.contable.backoffice.security.employee.domain.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPAImplEmployeesRepository extends JpaRepository<Employees, String> {

    Optional<Employees> findByEmail(String username);
}