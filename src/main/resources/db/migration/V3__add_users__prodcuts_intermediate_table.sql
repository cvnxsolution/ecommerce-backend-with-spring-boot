create table users_products
(
    user_id    bigint not null,
    product_id bigint not null,
    constraint users_products_pk
        primary key (user_id, product_id),
    constraint users_products_products_id_fk
        foreign key (product_id) references products (id),
    constraint users_products_users_id_fk
        foreign key (user_id) references users (id)
);

