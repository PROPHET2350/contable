package com.contable.account.security.infrastructure.httpControllers;

import com.contable.account.security.application.UserLogin;
import com.contable.account.security.domain.LoginResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserLogin userLogin;

    public UserController(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        var response = this.userLogin.login(request.getUsername(), request.getPassword());
        System.out.println(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

final class LoginRequest {
    @NotBlank(message = "The username is required")
    public String username;
    @NotBlank(message = "The password is required")
    public String password;

    public LoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}