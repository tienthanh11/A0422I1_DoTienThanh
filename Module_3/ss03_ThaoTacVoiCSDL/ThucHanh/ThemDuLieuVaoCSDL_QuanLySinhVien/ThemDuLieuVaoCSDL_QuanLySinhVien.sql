-- Thêm dữ liệu vào trong cơ sở dữ liệu quản lý sinh viên

use QuanLySinhVien;

-- Thêm lần lượt các bản ghi vào trong bảng Class
insert into Class 
values (1, 'A1', '2008-12-20', 1);
insert into Class
values (2, 'A2', '2008-12-22', 1);
insert into Class
values (3, 'B3', current_date, 0);

-- Thêm dữ liệu vào trong bảng Student bằng các câu lệnh insert into
insert into Student (StudentName, Address, Phone, Status, ClassId)
values ('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into Student (StudentName, Address, Status, ClassId)
values ('Hoa', 'Hai phong', 1, 1);
insert into Student (StudentName, Address, Phone, Status, ClassId)
values ('Manh', 'HCM', '0123123123', 0, 2);

-- Thêm dữ liệu nhanh vào trong bảng Subject
insert into `Subject`
values (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
-- Thêm dữ liệu vào trong bảng Mark bằng câu lệnh insert into
insert into Mark (SubId, StudentId, Mark, ExamTimes)
values (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       
select * from Class;
select * from Student;
select * from `Subject`;
select * from Mark;