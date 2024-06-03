package com.contable.server.tenant;

import jakarta.validation.constraints.NotNull;

public interface TenantResolver<T> {

    String resolve(@NotNull T object);
}
