-- Truy vấn dữ liệu với CSDL Quản lý sinh viên

use QuanLySinhVien;

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from Student
where StudentName like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from Class c
where month(StartDate) = 12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from `Subject`
where Credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update Student
set ClassID = 2 
where StudentName = 'Hung';
select * from Student;


-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select s.StudentName, sub.SubName, m.Mark
from Student s
join Mark m on s.StudentID = m.StudentID
join `Subject` sub on m.SubID = sub.SubID
order by m.Mark desc, s.StudentName asc;