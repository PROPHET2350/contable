CREATE TABLE IF NOT EXISTS public.account_user
(
    id       VARCHAR(255) NOT NULL,
    username VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_account_user PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.account_users_companies
(
    company_id VARCHAR(255) NOT NULL,
    user_id    VARCHAR(255) NOT NULL,
    CONSTRAINT pk_account_users_companies PRIMARY KEY (company_id, user_id)
);