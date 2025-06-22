alter table addresses
    add user_id bigint not null after id;

alter table addresses
    drop foreign key addresses_users_id_fk;

alter table addresses
    add constraint addresses_users_id_fk
        foreign key (user_id) references users (id);

