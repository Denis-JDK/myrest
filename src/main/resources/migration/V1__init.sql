BEGIN;

CREATE SEQUENCE account_id_seq;
CREATE SEQUENCE user_id_seq;
DROP TABLE "ACCOUNTS" C
CREATE TABLE accounts (id integer not null default nextval ('account_id_seq') primary key, user_id integer not null, numbers integer not null, amount decimal not null);
INSERT INTO accounts (id, user_id, numbers, amount) values
(1, 1,12345678, 345),
(2, 2,54566778, 547);

CREATE TABLE users (id integer not null default nextval ('product_id_seq') primary key, title varchar(255), patronymic varchar(255), surname varchar(255),
 telephone_number varchar(255), email varchar(255), birthday date) ;
--FOREIGN KEY (category_id) REFERENCES category (id)
INSERT INTO users (id, title, patronymic, surname, telephone_number, email, birthday) values
(1, 'User1','Patronymic1','Surname1', '74654543','email1', '2020-12-22');