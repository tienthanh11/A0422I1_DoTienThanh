create database user_management;
use user_management;

create table users (
	id int(3) not null auto_increment,
    name varchar(120) not null,
    email varchar(220) not null,
    country varchar(120),
    primary key (id)
);

insert into users (name, email, country) 
values  ('Minh', 'minh@codegym.vn', 'Việt Nam'), ('Kante','kante@che.uk','Kenia');

select * from users;
select * from users where id = 2;
select * from users where country = 'Việt Nam';
select * from users order by name;

