package com.contable.server.tenant;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class HeaderTenantInterceptor implements HandlerInterceptor {

    private final HeaderTenantResolver headerTenantResolver;

    public HeaderTenantInterceptor(HeaderTenantResolver headerTenantResolver) {
        this.headerTenantResolver = headerTenantResolver;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception {
        var tenantName = this.headerTenantResolver.resolve(request);
        TenantContext.setTenantName(tenantName);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView
    ) throws Exception {
        clear();
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex
    ) throws Exception {
        clear();
    }

    private void clear() {
        TenantContext.clear();
    }
}
