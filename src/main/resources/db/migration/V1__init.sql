BEGIN;

create table products
(
id bigserial primary key not null,
names varchar not null,
price decimal not null,
created_date_time timestamp not null,
updated_date_time timestamp not null
);


create table order_items
(
id bigserial primary key not null,
product_id bigint not null,
product_price decimal not null,
quantity int not null
);

create table users
(
id bigserial primary key not null,
names varchar not null,
email varchar not null,
);

create table roles
(
id bigserial primary key not null,
names varchar not null
);

create table users_roles
(
user_id bigint not null,
role_id bigint not null,
primary key (user_id, role_id),
foreign key (user_id) references users (id),
foreign key (role_id) references roles (id)
);
