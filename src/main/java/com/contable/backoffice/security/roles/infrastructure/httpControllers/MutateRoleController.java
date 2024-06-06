package com.contable.backoffice.security.roles.infrastructure.httpControllers;

import com.contable.backoffice.security.roles.application.MutationRoleService;
import com.contable.backoffice.security.roles.application.RoleCreateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class MutateRoleController {

    @Autowired
    private MutationRoleService mutationRoleService;

    @Autowired
    private RoleCreateService roleCreateService;

    @PreAuthorize("hasAnyAuthority('update_role')")
    public ResponseEntity<?> update(@PathVariable("uuid") String uuid, @RequestBody @Valid RoleRequest request) {
        mutationRoleService.update(request.toDomain());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @PostMapping("/role")
    public ResponseEntity<?> index(@RequestBody @Valid RoleRequest request) {
        this.roleCreateService.save(request.toDomain());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('delete_role')")
    public ResponseEntity<?> delete(@PathVariable("uuid") String uuid) {
        this.mutationRoleService.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

