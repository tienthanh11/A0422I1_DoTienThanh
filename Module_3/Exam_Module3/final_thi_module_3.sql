create database final_thi_module_3;
use final_thi_module_3;

create table payment (
	payment_id int auto_increment primary key,
    payment_name varchar(50)
);
insert into payment (payment_name)
values ('Theo Tháng'), ('Theo Quý'), ('Theo Năm');
select * from payment;


create table room  (
	room_id int auto_increment primary key,
    room_name varchar(50),
    room_sdt varchar(50),
    room_ngaybatdau varchar(50),
    payment_id int,
    room_ghichu varchar(50),
    foreign key(payment_id) references payment(payment_id)
);

insert into room (room_name, room_sdt, room_ngaybatdau, payment_id, room_ghichu)
values ('Nguyễn Văn A', '0123456789', '10-10-2020', 1, 'Phòng có điều hoà'),
	   ('Nguyễn Văn B', '0123456789', '10-10-2020', 2, '...'),
       ('Nguyễn Văn C', '0123456789', '10-10-2020', 3, 'Phòng có điều hoà'),
       ('Nguyễn Văn D', '0123456789', '10-10-2020', 1, 'Phòng có điều hoà');
select * from room;