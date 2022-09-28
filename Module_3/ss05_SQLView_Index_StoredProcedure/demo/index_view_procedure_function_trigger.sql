-- ss5: index, view, procedure, function, trigger
use a0422i1;

-- 1. index
select * from customers;

select count(*) from customers where city ='lyon';
explain select * from customers where city ='lyon';

-- Cách 1: create index
create index i_city on customers(city);
drop index i_city on customers;
-- Cách 2: create index
alter table customers add index i_city(city);
alter table customers drop index i_city;

-- 2. view (tạo view lấy thông tin của học viên)
create view w_student as
select s.id, s.name as name_student, c.id as id_class, c.name as class_name
from student s
inner join class c on s.class_id = c.id;

-- sử dụng view 
select * from w_student;
select * from student;
drop view w_student;

-- sửa thông tin trên view
-- update w_student set name_student ='cu'where id = 1;

-- 3. Store Procedure
-- 3.1  tạo một sp không tham số để lấy danh sách student
delimiter //
create procedure get_all_student()
begin 
	select * from student;
end //
delimiter ;
-- gọi sp
call get_all_student();

-- 3.2 sp có tham số in để lấy ra học viên có tham số id
delimiter //
create procedure find_student_by_id(in p_id int)
begin
	select * from student where id = p_id;
end //
delimiter ;
call find_student_by_id(1);
call find_student_by_id(10);

-- 3.3 sp đếm số lượng học viên của trung tâm sử dụng OUT param
delimiter //
create procedure count_student(out so_luong int)
begin
	select count(*) into so_luong from student;
end //
delimiter ;
call count_student(@sl);
select @sl;

-- delete store procedure
drop procedure count_student;

-- 4 Function
-- viêt 1 function xếp loại học lưc theo point
delimiter //
create function f_xep_loai(p_point int)
returns varchar(50)
deterministic
begin
	declare loai varchar(50);
    if p_point >= 8 then
    set loai = 'giỏi';
    elseif p_point >= 7 then
    set loai = 'khá';
    elseif p_point >= 5 then
    set loai = 'trung bình';
    else 
    set loai = 'yếu';
    end if;
    return loai;
end //
delimiter ;

select f_xep_loai(9);
select id, name, point, f_xep_loai(point) as 'xếp loại'
from student;

-- 5 trigger
-- tạo trigger tự động tạo tài khoản jame trước khi thêm mới một học viên
select * from student;
select * from jame;

insert into student(`name`,birthday, email, gender,`point`, class_id,`account`) 
values ('tienthanh','1990-12-12','thanhdt@gmail.com',1,8,1,'thanhdt@gmail.com');

DELIMITER //
CREATE TRIGGER tr_auto_create_jame 
BEFORE INSERT ON student
FOR EACH ROW
BEGIN
insert into jame(`account`, `password`) values ( new.email, '123');
END //
DELIMITER ;

-- tạo trigger để ghi lại lich sử thây đổi thông tin bảng student
delimiter //
create trigger tr_history
after update on student
for each row
begin
	insert into `history` (`name`, old_point, new_point, update_day)
    values (old.`name`, old.`point`, new.`point`, now());
end //
delimiter ;

select * from `history`;
select * from student;

-- tạo bảng để ghi log
create table `history` (
	id int primary key auto_increment,
    name varchar(50),
    old_point int,
    new_point int,
    update_day date
);
