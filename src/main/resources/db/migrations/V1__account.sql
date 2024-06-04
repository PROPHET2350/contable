CREATE TABLE public.backoffice_leads
(
    lead_id                  VARCHAR(255) NOT NULL,
    name                     VARCHAR(255),
    lastname                 VARCHAR(255),
    email                    VARCHAR(255),
    phone                    VARCHAR(255),
    companies                JSON,
    is_sign_upload           BOOLEAN,
    is_first_product_created BOOLEAN,
    is_first_sale_done       BOOLEAN,
    CONSTRAINT pk_backoffice_leads PRIMARY KEY (lead_id)
);

CREATE TABLE public.account_companies
(
    id                  VARCHAR(255) NOT NULL,
    commercial_name     VARCHAR(255),
    business_name       VARCHAR(255),
    identity            VARCHAR(255),
    address             VARCHAR(255),
    is_accounting_force BOOLEAN,
    rimpe               VARCHAR(255),
    owner_id            VARCHAR(255),
    CONSTRAINT pk_account_companies PRIMARY KEY (id)
);

CREATE TABLE public.account_owner
(
    id       VARCHAR(255) NOT NULL,
    name     VARCHAR(255),
    lastname VARCHAR(255),
    email    VARCHAR(255),
    phone    VARCHAR(255),
    CONSTRAINT pk_account_owner PRIMARY KEY (id)
);

ALTER TABLE public.account_companies
    ADD CONSTRAINT uc_account_companies_identity UNIQUE (identity);

ALTER TABLE public.account_companies
    ADD CONSTRAINT FK_ACCOUNT_COMPANIES_ON_OWNER FOREIGN KEY (owner_id) REFERENCES public.account_owner (id);