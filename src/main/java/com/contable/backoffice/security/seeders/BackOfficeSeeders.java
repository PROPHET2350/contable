package com.contable.backoffice.security.seeders;

import com.contable.backoffice.security.employee.domain.EmployeeCreatorRepository;
import com.contable.backoffice.security.employee.domain.Employees;
import com.contable.backoffice.security.roles.domain.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
public class BackOfficeSeeders {

    private final PasswordEncoder encoder;
    private final EmployeeCreatorRepository repository;

    public BackOfficeSeeders(PasswordEncoder encoder, EmployeeCreatorRepository repository) {
        this.encoder = encoder;
        this.repository = repository;
    }

    @Bean
    CommandLineRunner initAdmin() {
        return args -> {
            var role = Role.create("26231073-3076-44ea-a5cc-9ee375db6e71", "Admin", new HashSet<>(), false);
            var admin = Employees.create("1afbe3ae-99eb-4ee2-8487-1be397a39a53", "Nelson Gamboa", "admind@cangoo.com.ec", "0992503092", encoder.encode("BBF-2024"), new HashSet<>());
            repository.save(admin);
        };
    }
}
