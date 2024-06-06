package com.contable.account.companies.infrastructure.httpControllers;

import com.contable.account.companies.application.CreateCompany;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class CompanyController {

    private final CreateCompany createCompany;

    public CompanyController(CreateCompany createCompany) {
        this.createCompany = createCompany;
    }

    @PostMapping("/company/add")
    public ResponseEntity<?> add(@RequestBody @Valid CompanyRequest request) {
        System.out.println(request.toString());
        createCompany.save(request.toDomain());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
