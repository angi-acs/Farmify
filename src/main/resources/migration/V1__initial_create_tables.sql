CREATE SCHEMA farmapp;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SET search_path = farmapp, pg_catalog;

create sequence farmapp.hibernate_sequence start with 1 increment by 1;

create table product (
	id uuid primary key,
	name varchar(50) not null,
	quantity varchar(50) not null,
	price int not null

);


