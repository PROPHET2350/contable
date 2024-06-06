package com.contable.backoffice.security.employee.infrastructure.httpControllers;


import com.contable.backoffice.security.employee.application.EmployeeCreateService;
import com.contable.backoffice.security.employee.application.EmployeeMutationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class MutationEmployeeController {

    @Autowired
    private EmployeeCreateService creator;
    @Autowired
    private EmployeeMutationService mutator;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/employee")
    @PreAuthorize("hasAnyAuthority('add_employee')")
    public ResponseEntity<?> add(@RequestBody @Valid EmployeeRequest request) {
        creator.save(request.toDomain(encoder));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid EmployeeRequest request) {
        mutator.update(request.toDomain(encoder));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/employee/{id}")
    @PreAuthorize("hasAnyAuthority('delete_employee')")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        mutator.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
