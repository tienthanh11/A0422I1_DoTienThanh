create database user_management;
use user_management;

create table users (
	id int(3) not null auto_increment,
    name varchar(120) not null,
    email varchar(220) not null,
    country varchar(120),
    primary key (id)
);

create table permision (
	id int(11) primary key,
    name varchar(50)
);

create table user_permision (
	user_id int(11),
	permision_id int(11)
);

insert into users (name, email, country) 
values  ('Minh', 'minh@codegym.vn', 'Việt Nam'), ('Kante','kante@che.uk','Kenia');

insert into permision (id, name)
values (1, 'add'), (2, 'edit'), (3, 'delete'), (4, 'view');

select * from users;
select * from users where id = 2;
select * from users where country = 'Việt Nam';
select * from users order by name;
select * from permision;
select * from user_permision;
select * from EMPLOYEE;
 
delimiter $$
create procedure get_user_by_id(in user_id int)
begin
	select users.name, users.email, users.country
    from users
    where users.id = user_id;
end $$
delimiter ;

delimiter $$
create procedure insert_user (
	in user_name varchar(50),
    in user_email varchar(50),
    in user_country varchar(50)
)
begin
	insert into users(name, email, country)
    value (user_name, user_email, user_country);
end $$
delimiter ;

DELIMITER $$
CREATE PROCEDURE sp_get_all_users(IN user_id INT)
BEGIN
	SELECT users.`name`, users.email, users.country
    FROM users
    WHERE users.id = user_id;
END $$
DELIMITER ;

