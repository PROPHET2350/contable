package com.contable.backoffice.security.employee.infrastructure.httpControllers;

import com.contable.backoffice.security.employee.application.EmployeeLoginService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AdminLoginController {

    @Autowired
    private EmployeeLoginService employeeLoginService;

    @PostMapping("/admin/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
        var response = employeeLoginService.login(loginRequest.username, loginRequest.password);
        SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(System.out::println);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

final class LoginRequest {
    @NotBlank(message = "username cannot be blank")
    @Email(message = "Not valid email")
    public String username;
    @NotBlank(message = "Password cannot be blank")
    public String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest() {
    }

    public String getEmail() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}