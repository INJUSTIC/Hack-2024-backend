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
    information       VARCHAR(255)        NOT NULL,
    specialization   VARCHAR(255)        NOT NULL,
    email              VARCHAR(255)        NOT NULL,
    phone              VARCHAR(255)        NOT NULL,
    user_id            UUID,
    PRIMARY KEY (id)
);

CREATE TABLE skills
(
    id               UUID                NOT NULL,
    content        VARCHAR(255)        NOT NULL,
    user_info_id            UUID,
    PRIMARY KEY (id)
);

CREATE TABLE educations
(
    id               UUID                NOT NULL,
    content        VARCHAR(255)        NOT NULL,
    user_info_id            UUID,
    PRIMARY KEY (id)
);

CREATE TABLE experiences
(
    id               UUID                NOT NULL,
    content        VARCHAR(255)        NOT NULL,
    user_info_id            UUID,
    PRIMARY KEY (id)
);

DROP TABLE users_info;
