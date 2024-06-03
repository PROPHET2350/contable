package com.contable.server.config.interceptors;

import com.contable.server.tenant.HeaderTenantInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final HeaderTenantInterceptor headerTenantInterceptor;

    public WebConfig(HeaderTenantInterceptor headerTenantInterceptor) {
        this.headerTenantInterceptor = headerTenantInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerTenantInterceptor);
    }
}
