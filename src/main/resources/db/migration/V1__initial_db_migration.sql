create table users
(
    id       bigint auto_increment
        primary key,
    name     varchar(255) not null,
    email    varchar(255) not null unique ,
    password varchar(255) not null
);

create table tags
(
    id   bigint auto_increment
        primary key,
    name varchar(255) not null
);

create table profiles
(
    id             bigint       not null
        primary key,
    phone_number   varchar(255) not null,
    bio            varchar(255) not null,
    loyalty_points tinyint      not null,
    date_of_birth  date         null,
    constraint profiles_users_id_fk
        foreign key (id) references users (id)
);

create table addresses
(
    id     bigint auto_increment
        primary key,
    street varchar(255) not null,
    city   varchar(255) not null,
    zip    varchar(255) null,
    state  varchar(255) null,
    constraint addresses_users_id_fk
        foreign key (id) references users (id)
);


create table users_tags
(
    user_id bigint not null,
    tag_id  bigint not null,
    constraint users_tags_pk
        primary key (user_id, tag_id),
    constraint users_tags_tags_id_fk
        foreign key (tag_id) references tags (id),
    constraint users_tags_users_id_fk
        foreign key (user_id) references users (id)
);


