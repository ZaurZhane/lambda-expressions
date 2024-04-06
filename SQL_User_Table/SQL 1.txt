CREATE TABLE PERSONS (
	name varchar(255) not null, 
	surname varchar(255) not null, 
	age int varchar(255) not null,
    phone_number varchar(255),
    city_of_living varchar(255),
    primary key (name, surname, age)
);

INSERT INTO PERSONS (NAME, SURNAME, AGE, PHONE_NUMBER, CITY_OF_LIVING)
VALUES ('ANDREI', 'MEDVEDEV', 34, +7960023344, 'MOSCOW');
    ('ALEXANDR', 'VOLKOV', 44, +79887809854, 'KRASNODER');
