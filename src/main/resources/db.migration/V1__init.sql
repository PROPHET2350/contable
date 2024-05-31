CREATE TABLE backoffice_leads
(
    lead_id  VARCHAR(255) NOT NULL,
    name     VARCHAR(255),
    lastname VARCHAR(255),
    email    VARCHAR(255),
    identity VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_backoffice_leads PRIMARY KEY (lead_id)
);

CREATE TABLE core_owner
(
    id       VARCHAR(255) NOT NULL,
    name     VARCHAR(255),
    lastname VARCHAR(255),
    email    VARCHAR(255),
    identity VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_core_owner PRIMARY KEY (id)
);