CREATE TABLE IF NOT EXISTS public.back_office_permissions(
        id               VARCHAR(255) NOT NULL,
        displayName      VARCHAR(255) NOT NULL,
        description      VARCHAR(255),
        permissionName   VARCHAR(255) NOT NULL,
        CONSTRAINT pk_back_office_permissions PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.back_office_roles(
        id              VARCHAR(255) NOT NULL,
        name            VARCHAR(255) NOT NULL,
        is_deletable    BOOLEAN,
        CONSTRAINT pk_back_office_roles PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.back_office_employees(
        id       VARCHAR(255) NOT NULL,
        name     VARCHAR(255) NOT NULL,
        email    VARCHAR(255) NOT NULL,
        phone    VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        CONSTRAINT pk_back_office_employees PRIMARY KEY (id)
);



CREATE TABLE IF NOT EXISTS public.back_office_roles_permissions
(
    role_id       VARCHAR(255) NOT NULL,
    permission_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_back_office_roles_permissions PRIMARY KEY (role_id, permission_id)
);

CREATE TABLE IF NOT EXISTS public.back_office_roles_employees
(
    employee_id VARCHAR(255) NOT NULL,
    role_id     VARCHAR(255) NOT NULL,
    CONSTRAINT pk_back_office_roles_employees PRIMARY KEY (employee_id, role_id)
);

INSERT INTO public.back_office_roles (id,name,is_deletable) VALUES ('26231073-3076-44ea-a5cc-9ee375db6e71','Admin',false)