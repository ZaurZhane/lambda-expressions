INSERT INTO CUSTOMERS (NAME, SURNAME, AGE, PHONE_NUMBER)
VALUES ('ALEXEY', 'MEDVEDEV', 34, +7960023344),
    ('ALEXANDR', 'VOLKOV', 44, +79887809854),
    ('IVAN', 'PETROV', 24, +79885466854);

INSERT INTO ORDERS (date, customer_id, product_name, amount)
VALUES ('08.04.2024', 1, 'Телевизор', 1),
       ('08.04.2024', 2, 'Телефон', 1),
       ('07.04.2024', 3, 'Наушники', 1),
       ('07.04.2024', 2, 'Клавиатура', 1),
       ('05.04.2024', 3, 'Мышка', 1);