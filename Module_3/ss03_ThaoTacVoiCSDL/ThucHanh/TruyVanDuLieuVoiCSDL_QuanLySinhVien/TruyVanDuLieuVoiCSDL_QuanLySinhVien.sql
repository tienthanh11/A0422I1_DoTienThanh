-- Truy vấn dữ liệu với CSDL Quản lý sinh viên

use QuanLySinhVien;

-- Hiển thị danh sách tất cả các học viên
select * from Student;

-- Hiển thị danh sách các học viên đang theo học.
select * from Student
where `Status` = true;

-- Hiển thị danh sách các học viên không theo học.
select * from Student
where `Status` = false;

-- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
select * from `Subject`
where Credit < 10;

-- Hiển thị danh sách học viên lớp A1
select s.StudentID, s.StudentName, c.ClassName
from Student s
join Class c on s.ClassID = c.ClassID
where c.ClassName = 'A1';

-- Hiển thị điểm môn CF của các học viên.
select s.StudentID, s.StudentName, sub.SubName, m.Mark
from Student s
join Mark m on s.StudentID = m.StudentID
join `Subject` sub on m.SubID = sub.SubID
where sub.SubName = 'CF';