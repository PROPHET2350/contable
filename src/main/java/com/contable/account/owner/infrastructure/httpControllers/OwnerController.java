package com.contable.account.owner.infrastructure.httpControllers;

import com.contable.account.owner.application.CreateOwner;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class OwnerController {

    private final CreateOwner createOwner;

    public OwnerController(CreateOwner createOwner) {
        this.createOwner = createOwner;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid OwnerRequest request) {
        createOwner.save(request.toDomain());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
