create table categories
(
    id         bigserial primary key,
    title      varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into categories (title) values ('Food');

create table products
(
    id          bigserial primary key,
    title       varchar(255),
    price       numeric(8, 2) not null,
    category_id bigint references categories (id),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

insert into products (title, price, category_id)
values ('Milk', 95, 1),
       ('Bread', 28, 1),
       ('Cheese', 420, 1),
       ('Cheese2', 420, 1),
       ('Cheese3', 420, 1),
       ('Cheese4', 420, 1),
       ('Cheese5', 420, 1),
       ('Cheese6', 420, 1),
       ('Cheese7', 420, 1),
       ('Cheese8', 420, 1);