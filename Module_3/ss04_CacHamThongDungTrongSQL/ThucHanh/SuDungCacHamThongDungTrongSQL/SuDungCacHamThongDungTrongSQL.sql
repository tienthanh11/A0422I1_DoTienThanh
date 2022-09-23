-- Sử dụng các hàm thông dụng trong SQL

use QuanLySinhVien;

-- Hiển thị số lượng sinh viên ở từng nơi
select Address, count(StudentID) as 'Số lượng học viên' 
from Student
group by Address;

-- Tính điểm trung bình các môn học của mỗi học viên
select s.StudentID, s.StudentName, avg(Mark) as 'Điểm trung bình'
from Student s
join Mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select s.StudentID, s.StudentName, avg(Mark) as 'Điểm trung bình'
from Student s
join Mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName
having avg(Mark) > 15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select s.StudentID, s.StudentName, avg(Mark) as 'Điểm trung bình'
from Student s
join Mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName
having avg(Mark) >= all (
	select avg(Mark)
    from Mark m
    group by m.StudentID
);