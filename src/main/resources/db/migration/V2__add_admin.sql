INSERT INTO users (id, archive, email, name, password, role)
VALUES (1, false, 'mail@mail.ru', 'admin', '$2a$10$.pNYBSROarIXPQcPGQX2yuS8562vJhQa/w6gVpAROW017IFhL/fMm', 'ADMIN');

ALTER SEQUENCE user_seq RESTART WITH 2;