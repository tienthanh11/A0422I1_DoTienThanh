create database if not exists thi_module3;
use thi_module3;

create table if not exists book(
	book_id int primary key auto_increment,
	`name` varchar (100),
	author varchar(100),
	`description` varchar(100),
	quantity int
);
insert into book (`name`,author,`description`,quantity) 
values ("Số đỏ", "Vũ Trọng Phụng", "Nhân vật chính là Xuân tóc đỏ và ...", 10),
	   ("Truyện Kiều", "Nguyễn Du" ,"Cuộc đời Thúy Kiều", 15);
select * from book;
select * from book where `name` like 'Số đỏ';

create table if not exists student (
	student_id int primary key auto_increment,
	`name` varchar (100),
	class_name varchar (100)
);

insert into student (`name`, class_name) 
values ("Nguyễn Văn A","A11"),("Nguyễn Văn B","A12");
select * from student;

create table if not exists card_borrow_book (
	card_borrow_book_id varchar(50) primary key,
	book_id int,
	student_id int,
	`status` bit,
	date_borrow date,
	date_turn date,
    foreign key (book_id) references book (book_id),
    foreign key (student_id) references student(student_id)
);

insert into card_borrow_book(card_borrow_book_id, book_id, student_id, `status`, date_borrow, date_turn) 
values ("MS-0001",1,1,1,"2000-10-05","2000-12-05"), 
	   ("MS-0002",2,2,0,"2000-09-05","2000-11-05");
select * from card_borrow_book;
select * from card_borrow_book where book_id = 1;