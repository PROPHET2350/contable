package com.contable.server.tenant;

public class TenantContext {

    private static final ThreadLocal<String> tenantName = new InheritableThreadLocal<>();

    public static void setTenantName(String name) {
        tenantName.set(name);
    }

    public static String getTenantName() {
        return tenantName.get();
    }

    public static void clear() {
        tenantName.remove();
    }
}
