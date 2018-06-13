create table customers(id serial primary key,
first_name varchar(50),last_name varchar(50),
created_date timestamp default current_timestamp,
modified_date timestamp null,status boolean);
