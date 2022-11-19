create database if not exists demo_ontap_2;
use demo_ontap_2;

create table if not exists `status` (
	status_id int primary key auto_increment,
    status_name varchar(25)
);
insert into `status` (status_name)
values ('Văn phòng chia sẻ'), ('Văn phòng trọn gói');
select * from `status`;

create table if not exists type_office (
	type_office_id int primary key auto_increment,
    type_office_name varchar(25)
);
insert into type_office (type_office_name)
values ('Trống'), ('Hạ tầng'), ('Đầy đủ');
select * from type_office;

create table if not exists `ground` (
	id varchar(25) primary key,
    area double,
    status_id int,
    floors int,
    type_office_id int,
    `description` varchar(50),
    rental_price double,
    start_date date,
    end_date date,
    foreign key (status_id) references `status` (status_id),
    foreign key (type_office_id) references type_office (type_office_id)
);
insert into `ground`(id,  area, status_id, floors, type_office_id, `description`, rental_price, start_date, end_date) 
values ("ABC-12-AAA",2,1,4,1,"abc",10000000,"2022/10/10","2021/11/10"),
	   ("ABC-13-BBB",3,2,6,2,"bcd",20000000,"2022/11/10","2021/10/10"),
	   ("ABC-14-CCC",4,2,8,3,"hihi",30000000,"2022/12/10","2021/12/10"),
	   ("ABC-15-DDD",5,1,15,1,"haha",2000000,"2022/09/10","2021/08/10");
select * from `ground`;
select * from `ground` order by area asc;
select * from `ground` where id = 'ABC-15-DDD' order by area asc;