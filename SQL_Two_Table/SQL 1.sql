CREATE TABLE CUSTOMERS (
    id int primary key auto_increment,
    name  varchar(255) not null,
    surname varchar(255) not null,
    age int not null,
    phone_number varchar(255) not null
);
INSERT INTO CUSTOMERS (NAME, SURNAME, AGE, PHONE_NUMBER)
VALUES ('ALEXEY', 'MEDVEDEV', 34, +7960023344),
    ('ALEXANDR', 'VOLKOV', 44, +79887809854);
