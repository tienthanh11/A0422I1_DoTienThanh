create database if not exists database_furama_manager;
-- drop database database_furama_manager;
use database_furama_manager;


create table `position` (
	position_id int primary key auto_increment,
    position_name varchar(45)
);

create table education_degree (
	education_degree_id int primary key auto_increment,
    education_degree_name varchar(45)
);

create table division (
	division_id int primary key auto_increment,
    division_name varchar(45)
);

create table `role` (
	role_id int primary key auto_increment,
    role_name varchar(255)
);

create table `user` (
	username varchar(255) primary key,
    `password` varchar(255)
);

create table user_role (
	role_id int,
    username varchar(255),
    foreign key (role_id) references `role` (role_id),
    foreign key (username) references `user` (username)
);

create table employee (
	employee_id int primary key auto_increment,
    employee_name varchar(45) not null,
    employee_birthday date not null,
    employee_id_card varchar(45) not null,
    employee_salary double not null,
    employee_phone varchar(45) not null,
    employee_email varchar(45),
    employee_address varchar(45),
    position_id int not null,
    education_degree_id int not null,
    division_id int not null,
    username varchar(255) default "username",
    foreign key (position_id) references `position` (position_id),
    foreign key (education_degree_id) references education_degree (education_degree_id),
    foreign key (division_id) references division (division_id),
    foreign key (username) references `user` (username)
);

create table customer_type (
	customer_type_id int primary key auto_increment,
    customer_type_name varchar(45)
);

create table customer (
	customer_id int primary key auto_increment,
    customer_type_id int not null,
    customer_name varchar(45) not null,
    customer_birthday date not null,
    customer_gender bit(1) not null,
    customer_id_card varchar(45) not null,
    customer_phone varchar(45) not null,
    customer_email varchar(45), 
    customer_address varchar(45),
    foreign key (customer_type_id) references customer_type (customer_type_id)
);

create table rent_type (
	rent_type_id int primary key auto_increment,
    rent_type_name varchar(45),
    rent_type_cost double
);

create table service_type (
	service_type_id int primary key auto_increment,
    service_type_name varchar(45)
);

create table service (
	service_id int primary key auto_increment,
    service_name varchar(45) not null,
    service_area int,
    service_cost double not null,
    service_max_people int,
    rent_type_id int not null,
    service_type_id int not null,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int, 
    foreign key (rent_type_id) references rent_type (rent_type_id),
    foreign key (service_type_id) references service_type (service_type_id)	
);

create table contract (
	contract_id int primary key auto_increment,
    contract_start_date datetime not null,
    contract_end_date datetime not null,
    contract_deposit double not null,
    contract_total_money double not null,
    employee_id int not null,
    customer_id int not null,
    service_id int not null,
    foreign key (employee_id) references employee (employee_id),
    foreign key (customer_id) references customer (customer_id),
    foreign key (service_id) references service (service_id)
);

create table attach_service (
	attach_service_id int primary key auto_increment,
    attach_service_name varchar(45) not null,
    attach_service_cost double not null,
    attach_service_unit varchar(45) not null,
    attach_service_status varchar(45)
);

create table contract_detail(
	contract_detail_id int primary key auto_increment,
    contract_id int not null,
    attach_service_id int not null,
    quantity int not null,
    foreign key (contract_id) references contract (contract_id),
    foreign key (attach_service_id) references attach_service (attach_service_id)
);

-- Add data for position
insert into `position` (position_name)
values ('L??? t??n'), ('Ph???c v???'), ('Chuy??n vi??n'), ('Gi??m s??t'), ('Qu???n l??'), ('Gi??m ?????c');
select * from `position`;

-- Add data for education degree
insert into education_degree (education_degree_name) 
values ("Trung c???p"), ("Cao ?????ng"), ("?????i h???c"), ("Sau ?????i h???c");
select * from education_degree;

-- Add data for division
insert into division (division_name) 
values ("Sale???Marketing"), ("H??nh ch??nh"), ("Ph???c v???"), ("Qu???n l??");
select * from division;

-- Add data for role
insert into `role` (role_name)
values ('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Member');
select * from `role`;

-- Add data for user
insert into `user` (username, `password`)
values ('admin_1', '123'), ('admin_2', '123'), ('admin_3', '123'), ('admin_4', '123'), ('admin_5', '123');
select * from `user`;

-- Add data for user_role
insert into  `user_role`(role_id, username)
values (1, 'admin_1'), (2, 'admin_2'), (3, 'admin_3'), (4, 'admin_4'), (5, 'admin_5');
select * from `user_role`;

-- Add data for employee
insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, 
					  position_id, education_degree_id, division_id, username)
values ('Nguy???n V??n An', '1970-11-07',	'456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguy???n T???t Th??nh, ???? N???ng',	1, 3, 1, 'admin_1'),
       ('L?? V??n B??nh', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Y??n B??i, ???? N???ng', 1, 2, 2, 'admin_2'),
       ('H??? Th??? Y???n', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 ??i???n Bi??n Ph???, Gia Lai', 1, 3, 2, 'admin_3'),
       ('V?? C??ng To???n', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Ho??ng Di???u, Qu???ng Tr???', 1, 4, 4, 'admin_4'),
       ('Nguy???n B???nh Ph??t', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Y??n B??i, ???? N???ng', 2, 1, 1, 'admin_5'),
       ('Kh??c Nguy???n An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguy???n T???t Th??nh, ???? N???ng', 2, 2, 3, 'admin_1'),
       ('Nguy???n H???u H??', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguy???n Ch?? Thanh, Hu???', 2, 3, 2, 'admin_2'),
       ('Nguy???n H?? ????ng', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 H??ng V????ng, H?? N???i', 2, 4, 4, 'admin_3'),
       ('T??ng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 H??m Nghi, ???? N???ng', 2, 4, 4, 'admin_4'),
       ('Nguy???n C??ng ?????o', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Ho?? Kh??nh, ?????ng Nai', 2, 3, 2, 'admin_5');
select * from employee;
select * from employee where employee_id = 10;
select * from employee
where employee_name = 'H??? Th??? Y???n' and position_id = 1 and division_id = 2;

-- Add data for customer_type
insert into customer_type (customer_type_name) 
values ('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Member');
select * from customer_type;

-- Add data for customer
insert into customer(customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)
values (5, 'Nguy???n Th??? H??o', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguy???n Ho??ng, ???? N???ng'),
	   (3, 'Ph???m Xu??n Di???u', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Th??i Phi??n, Qu???ng Tr???'),
       (1, 'Tr????ng ????nh Ngh???', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 ??ng ??ch Khi??m, Vinh'),
       (1, 'D????ng V??n Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 L?? L???i, ???? N???ng'),
       (4, 'Ho??ng Tr???n Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 L?? Th??i T???, Gia Lai'),
       (4, 'T??n N??? M???c Ch??u', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Y??n Th???, ???? N???ng'),
       (1, 'Nguy???n M??? Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 L?? L???i, H??? Ch?? Minh'),
       (3, 'Nguy???n Th??? H??o', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguy???n V??n Linh, Kon Tum'),
       (1, 'Tr???n ?????i Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 L?? Th?????ng Ki???t, Qu???ng Ng??i'),
       (2, 'Nguy???n T??m ?????c', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ng?? Quy???n, ???? N???ng');
select * from customer;
select * from customer where customer_id = 10;
select * from customer where customer_name like 'Nguy???n M??? Kim' and customer_address like 'K123/45 L?? L???i, H??? Ch?? Minh' and customer_type_id like 1;

-- Add data for rent_type
insert into rent_type (rent_type_name, rent_type_cost) 
values ('Year', 250000000),('Month', 25000000),('Day', 2500000),('Hour', 250000);
select * from rent_type;

-- Add data for service_type
insert into service_type (service_type_name) 
values ('Villa'), ('House'), ('Room');
select * from service_type;

-- Add data for service
insert into service (service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, 
					 standard_room, description_other_convenience, pool_area,number_of_floors)
values ('Villa Beach Front', 25000, 10000000, 10, 3, 1, 'vip', 'C?? h??? b??i', 500, 4),
       ('House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'C?? th??m b???p n?????ng', null, 3),
       ('Room Twin 01', 5000, 1000000, 2, 4, 3, 'normal', 'C?? tivi', null, null),
       ('Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'normal', 'C?? h??? b??i', 300, 3),
       ('House Princess 02', 10000, 4000000, 5, 3, 2, 'normal', 'C?? th??m b???p n?????ng', null, 2),
       ('Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'C?? tivi', null, null);
select * from service;

-- Add data for contract
insert into contract (contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id)
values ("2020-12-08","2020-12-08",0,500000,3,1,3),
	   ("2020-07-14","2020-07-21",200000,1000000,7,3,1),
	   ("2021-03-15","2021-03-17",50000,700000,3,4,2),
       ("2021-01-14","2021-01-18",100000,5000000,7,5,5),
	   ("2021-07-14","2021-07-15",0,500000,7,2,6),
	   ("2021-06-01","2021-06-03",0,500000,7,7,6),
	   ("2021-09-02","2021-09-05",100000,2000000,7,4,4),
	   ("2021-06-17","2021-06-18",150000,10000000,3,4,1),
	   ("2020-11-19","2020-11-19",0,500000,3,4,3),
	   ("2021-04-12","2021-04-14",0,500000,10,3,5),
	   ("2021-04-25","2021-04-25",0,500000,2,2,1),
	   ("2021-05-25","2021-05-27",0,600000,7,10,1);
select * from contract;

-- Add data for attach_service
insert into attach_service (attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
values ('Karaoke', 10000, 'gi???', 'ti???n nghi, hi???n t???i'),
       ('Thu?? xe m??y', 10000, 'chi???c', 'h???ng 1 xe'),
       ('Thu?? xe ?????p', 20000, 'chi???c', 't???t'),
       ('Buffet bu???i s??ng', 15000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng'),
       ('Buffet bu???i tr??a', 90000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng'),
       ('Buffet bu???i t???i', 16000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng');
select * from attach_service;
       
-- Add data for contract_detail
insert into contract_detail (contract_id, attach_service_id, quantity)
values (2, 4, 5), (2, 5, 8), (2, 6, 15), (3, 1, 1), (3, 2, 11), (1, 3, 1), (1, 2, 2), (12, 2, 2);
select * from contract_detail;