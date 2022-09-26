-- ss04 Các hàm thông dụng trong SQL
use a0422i1;

select * from student;
-- 0. đếm số lượng học viên toàn trung tâm
select count(id) as so_luong from student;

-- 1.1	Hiện thị danh sách các lớp và số lượng học viên của mỗi lớp
select c.name as class_name, count(s.id) as so_luong
from student s
right join class c on s.class_id = c.id
group by c.name;

-- 1.2.	 Tính điểm lớn nhất của mỗi lớp
select c.name as class_name, ifnull(min(s.id), 'không có học viên') as max_point
from student s
right join class c on s.class_id = c.id
group by c.name;

-- 1.3	 Tình điểm trung bình của mỗi  lớp
select c.name as class_name, ifnull(avg(s.id), 'không có học viên') as max_point
from student s
right join class c on s.class_id = c.id
group by c.name;

-- 2 Lấy ra toàn bộ tên và ngày sinh các instructor và student ở CodeGym.
select i.name, i.birthday from instructor i
union
select s.name, s.birthday from student s;

-- 4 Lấy ra top 3 học viên có điểm cao nhất của trung tâm.
select * from student order by point desc limit 0, 3;

-- 5. Lấy ra các học viên có điểm số là cao nhất của trung tâm.
select max(point) from student;

-- dùng subquery
select * from student
where point = (
	select max(point) 
    from student
);

-- 6 tìm những giảng viên chưa từng tham gia giảng dạy;
-- dùng join
select * 
from instructor i
left join instructor_class ic on i.id = ic.instructor_id
where ic.instructor_id is null;

-- dùng truy vấn con với in
select *
from instructor
where id not in (
	select distinct ic.instructor_id
    from instructor_class ic
);