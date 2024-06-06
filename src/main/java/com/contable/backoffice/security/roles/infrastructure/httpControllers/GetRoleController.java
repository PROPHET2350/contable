package com.contable.backoffice.security.roles.infrastructure.httpControllers;

import com.contable.backoffice.security.roles.application.GetRolesService;
import com.contable.backoffice.security.roles.domain.Role;
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
public class GetRoleController {

    @Autowired
    private GetRolesService getRolesService;

    @GetMapping("/roles")
    @PreAuthorize("hasAnyAuthority('list_roles')")
    public ResponseEntity<List<Role>> list() {
        return new ResponseEntity<>(getRolesService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/role/{id}")
    @PreAuthorize("hasAnyAuthority('view_role')")
    public ResponseEntity<Role> single(@PathVariable String id) {
        return new ResponseEntity<>(getRolesService.findById(id), HttpStatus.OK);
    }
}
