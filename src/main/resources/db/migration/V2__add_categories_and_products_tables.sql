create table categories
(
    id   tinyint auto_increment
        primary key,
    name varchar(255) not null
);

create table products
(
    id          bigint auto_increment
        primary key,
    name        varchar(255) not null,
    price       tinyint      null,
    description TEXT         not null,
    category_id tinyint      not null,
    constraint products___fk
        foreign key (category_id) references categories (id)
);

