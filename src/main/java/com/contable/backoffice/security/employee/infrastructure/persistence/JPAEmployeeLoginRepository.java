package com.contable.backoffice.security.employee.infrastructure.persistence;

import com.contable.backoffice.security.employee.domain.AdminLoginResponse;
import com.contable.backoffice.security.employee.domain.EmployeeLoginRepository;
import com.contable.backoffice.security.employee.domain.Employees;
import com.contable.shared.domain.JWTUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JPAEmployeeLoginRepository implements EmployeeLoginRepository {

    private final JPAImplEmployeesRepository jpaImplEmployeesRepository;

    private final PasswordEncoder passwordEncoder;

    private final JWTUtils jwtUtils;

    private Employees loadEmployees;

    public JPAEmployeeLoginRepository(
            JPAImplEmployeesRepository jpaImplEmployeesRepository,
            PasswordEncoder passwordEncoder,
            JWTUtils jwtUtils
    ) {
        this.jpaImplEmployeesRepository = jpaImplEmployeesRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public AdminLoginResponse login(String username, String password) {
        Authentication authentication = this.authenticate(username, password);
        var token = jwtUtils.createToken(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new AdminLoginResponse(token, this.loadEmployees);
    }

    private Employees loadUserByUsername(String username) throws UsernameNotFoundException {
        var employee = jpaImplEmployeesRepository.findByEmail(username)
                .orElseThrow(() -> new IllegalArgumentException("The user " + username + " does not exist."));
        loadEmployees = employee;
        return employee;
    }

    private Authentication authenticate(String username, String password) {
        this.loadUserByUsername(username);
        var userDetails = this.loadUserByUsername(username);
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        userDetails.getRoles().forEach(
                role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getName())))
        );
        userDetails.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getPermissionName())));

        return new UsernamePasswordAuthenticationToken(username, password, authorityList);
    }
}

