-- Luyện tập các hàm thông dụng trong SQL

use QuanLySinhVien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select sub.SubID, sub.SubName, max(Credit) as Credit,  sub.`Status`
from `Subject` sub
where Credit = (
	select max(Credit)
    from `Subject`
);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select sub.SubID, sub.SubName, max(m.Mark) as 'Điểm thi'
from `Subject` sub
join Mark m on sub.SubID = m.SubID;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.StudentID, s.StudentName, s.Address, s.Phone, s.`Status`, avg(m.Mark) as 'Điểm trung bình'
from Student s
join Mark m on s.StudentID = m.StudentID
group by s.StudentID
order by m.Mark desc;