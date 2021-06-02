-- create database ecomerce_mcit_db; 
use ecomerce_mcit_db;
create table eproduct_data( id bigint primary key auto_increment, name varchar(100),
 price decimal(10,2), created_at timestamp default now(), modified_at timestamp default now());