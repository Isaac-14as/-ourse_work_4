drop table if exists orders cascade;
drop table if exists orders_details cascade;
drop table if exists products cascade;
drop table if exists users cascade;
drop sequence if exists bucket_seq;
drop sequence if exists category_seq;
drop sequence if exists order_details_seq;
drop sequence if exists order_seq;
drop sequence if exists product_seq;
drop sequence if exists user_seq;
create sequence bucket_seq start 1 increment 1;
create sequence category_seq start 1 increment 1;
create sequence order_details_seq start 1 increment 1;
create sequence order_seq start 1 increment 1;
create sequence product_seq start 1 increment 1;
create sequence user_seq start 1 increment 1;
create table buckets
(
    id      int8 not null,
    user_id int8,
    primary key (id)
);
create table buckets_products
(
    bucket_id  int8 not null,
    product_id int8 not null
);
create table categories
(
    id    int8 not null,
    title varchar(255),
    primary key (id)
);
create table order_details
(
    id         int8 not null,
    amount     numeric(19, 2),
    price      numeric(19, 2),
    product_id int8,
    primary key (id)
);
create table orders
(
    id      int8 not null,
    address varchar(255),
    created timestamp,
    status  varchar(255),
    sum     numeric(19, 2),
    updated timestamp,
    user_id int8,
    primary key (id)
);
create table orders_details
(
    order_id   int8 not null,
    details_id int8 not null
);
create table products
(
    id          int8 not null,
    category    int4 not null,
    description text,
    img_id      varchar(255),
    price       numeric(19, 2),
    title       varchar(255),
    primary key (id)
);
create table users
(
    id       int8    not null,
    archive  boolean not null,
    email    varchar(255),
    name     varchar(255),
    password varchar(255),
    role     varchar(255),
    primary key (id)
);
alter table if exists orders_details
    add constraint UK_kk6y3pyhjt6kajomtjbhsoajo unique (details_id);
alter table if exists buckets
    add constraint FKnl0ltaj67xhydcrfbq8401nvj foreign key (user_id) references users;
alter table if exists buckets_products
    add constraint FKloyxdc1uy11tayedf3dpu9lci foreign key (product_id) references products;
alter table if exists buckets_products
    add constraint FKc49ah45o66gy2f2f4c3os3149 foreign key (bucket_id) references buckets;
alter table if exists order_details
    add constraint FK4q98utpd73imf4yhttm3w0eax foreign key (product_id) references products;
alter table if exists orders
    add constraint FK32ql8ubntj5uh44ph9659tiih foreign key (user_id) references users;
alter table if exists orders_details
    add constraint FKbblrq2kcscnyr9fsv8ptp98wy foreign key (details_id) references order_details;
alter table if exists orders_details
    add constraint FK5o977kj2vptwo70fu7w7so9fe foreign key (order_id) references orders;