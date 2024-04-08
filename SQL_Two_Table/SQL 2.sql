CREATE TABLE ORDERS (
    id int primary key auto_increment,
    date timestamp not null,
    customer_id int references customers (id),
    product_name varchar(255) not null,
    amount int not null
);
INSERT INTO ORDERS (date, customer_id, product_name, amount)
VALUES ('08.04.2024', 1, 'Телевизор', 1),
       ('08.04.2024', 2, 'Телефон', 1),
       ('07.04.2024', 1, 'Наушники', 1),
       ('07.04.2024', 2, 'Клавиатура', 1),
       ('05.04.2024', 2, 'Мышка', 1);