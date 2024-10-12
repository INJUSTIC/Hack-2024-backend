CREATE TABLE users
(
    id               UUID                NOT NULL,
    username              VARCHAR(255) UNIQUE NOT NULL,
    password           VARCHAR(255)        NOT NULL,
    role               VARCHAR(10)         NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users_info
(
    id               UUID                NOT NULL,
    username              VARCHAR(255) UNIQUE NOT NULL,
    firstname          VARCHAR(255)        NOT NULL,
    lastname           VARCHAR(255)        NOT NULL,
    user_id            UUID,
    PRIMARY KEY (id)
);