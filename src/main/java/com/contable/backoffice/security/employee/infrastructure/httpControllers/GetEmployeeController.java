package com.contable.backoffice.security.employee.infrastructure.httpControllers;

import com.contable.backoffice.security.employee.application.EmployeeFinderService;
import com.contable.backoffice.security.employee.domain.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class GetEmployeeController {

    @Autowired
    private EmployeeFinderService service;

    @GetMapping("/employees")
    @PreAuthorize("hasAnyAuthority('list_employees')")
    public ResponseEntity<List<Employees>> list() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    @PreAuthorize("hasAnyAuthority('view_employee')")
    public ResponseEntity<Employees> single(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
}
