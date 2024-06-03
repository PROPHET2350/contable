package com.contable.server.tenant.resolver;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class HeaderTenantResolver implements TenantResolver<HttpServletRequest> {

    @Override
    public String resolve(HttpServletRequest request) {
        return request.getHeader("X-tenantName");
    }
}
