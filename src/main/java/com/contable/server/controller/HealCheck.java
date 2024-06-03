package com.contable.server.controller;

import com.contable.server.tenant.resolver.TenantContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class HealCheck {

    @GetMapping("/tenant")
    public String tenant() {
        return TenantContext.getTenantName();
    }
}
