use Furama_Resort_Manager;

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
-- và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
create view v_nhan_vien as
select nv.ma_nhan_vien, nv.ho_ten, nv.ngay_sinh, nv.so_cmnd, nv.luong, nv.so_dien_thoai, nv.email, nv.dia_chi
from nhan_vien nv
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
join khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
where (nv.dia_chi like '%Hải Châu%') and (hd.ngay_lam_hop_dong = '2019-12-12')
group by hd.ma_hop_dong
having count(hd.ma_hop_dong) >= 1;
select * from v_nhan_vien;

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
update nhan_vien
set dia_chi = 'Liên Chiểu'
where ma_nhan_vien in (
	select ma_nhan_vien
    from v_nhan_vien
);

-- 23. Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào 
-- đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.

DELIMITER //
CREATE PROCEDURE sp_xoa_khach_hang (ma_khach_hang INT)
BEGIN
	DELETE FROM khach_hang 
    WHERE ma_khach_hang = ma_khach_hang;
END //
DELIMITER ;
call sp_xoa_khach_hang (1);

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong 
-- với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
delimiter //
create procedure sp_them_moi_hop_dong (
	p_ma_hop_dong int,
    p_ngay_lam_hop_dong datetime,
    p_ngay_ket_thuc datetime, 
    p_tien_dat_coc double, 
    p_ma_nhan_vien int,
    p_ma_khach_hang int,
    p_ma_dich_vu int 
)
begin
	declare lastid int;
    select max(ma_hop_dong) into lastid
    from hop_dong;
    if(p_ma_hop_dong <> lastid + 1) then
	signal sqlstate '02000' set message_text = 'Invalid Id';
    elseif(p_ngay_lam_hop_dong is null) then
    signal sqlstate '02000' set message_text = 'Invalid Start Date';
    elseif (
		p_ma_nhan_vien not in (
			select ma_nhan_vien
            from nhan_vien
		)
	) then
    signal sqlstate '02000' set message_text = 'Invalid Ma Nhan Vien';
    elseif (
		p_ma_khach_hang not in (
			select ma_khach_hang
            from khach_hang
        )
    ) then
    signal sqlstate '02000' set message_text = 'Invalid Ma Khach Hang';
    elseif (
		p_ma_dich_vu not in (
			select ma_dich_vu
            from dich_vu
        )
    ) then
    signal sqlstate '02000' set message_text = 'Invalid Ma Dich Vu';
    else insert into hop_dong (
		ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu
    )
    value (
		p_ma_hop_dong, p_ngay_lam_hop_dong, p_ngay_ket_thuc, p_tien_dat_coc, p_ma_nhan_vien, p_ma_khach_hang, p_ma_dich_vu
    );
	end if;
end //
delimiter ;
call sp_them_moi_hop_dong(13, '2021-05-27 00:00:00', '2021-05-27 00:00:00', 1, 1, 1, 1);
select * from hop_dong;

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì 
-- hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

create table tg_check(so_luong int);
delimiter //
drop trigger if exists tr_xoa_hop_dong //
create trigger tr_xoa_hop_dong 
after delete 
on hop_dong
for each row
begin
	declare so_luong int;
	set so_luong = (select count(*) from hop_dong);
	insert into tg_check values (so_luong);
end//
delimiter ;
-- show triggers;
delete from hop_dong
where ma_hop_dong = 13;
select * from tg_check;

-- 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, 
-- với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, 
-- nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.
delimiter //
drop trigger if exists tr_cap_nhat_hop_dong //
create trigger tr_cap_nhat_hop_dong after
update on hop_dong
for each row
begin
	if new.ngay_lam_hop_dong + 2 > new.ngay_ket_thuc then
    signal sqlstate '25000' set message_text = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
    end if;
end //
delimiter ;
update hop_dong 
set ngay_ket_thuc = '2021-05-29 00:00:00' where ma_hop_dong = 13;

-- 27.	Tạo Function thực hiện yêu cầu sau:
-- a.	Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.
delimiter //
drop function if exists func_dem_dich_vu //
create function func_dem_dich_vu()
returns int
deterministic
begin
	declare so_luong int;
    select count(*) into so_luong
    from (
		select sum(dv.chi_phi_thue) as tong_tien
        from dich_vu dv
        join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
        group by hd.ma_hop_dong
		having tong_tien > 2000000
    ) as temp;
    return so_luong;
end //
delimiter ;
select func_dem_dich_vu() as so_luong_dich_vu;

-- b.	Tạo Function func_tinh_thoi_gian_hop_dong: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến 
-- lúc kết thúc hợp đồng mà khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, 
-- không xét trên toàn bộ các lần làm hợp đồng). Mã của khách hàng được truyền vào như là 1 tham số của function này.
delimiter //
drop function if exists func_tinh_thoi_gian_hop_dong //
create function func_tinh_thoi_gian_hop_dong (p_ma_khach_hang int)
returns int
deterministic
begin
	declare thoi_gian_dai_nhat int;
    select max(temp.thoi_gian_hop_dong) into thoi_gian_dai_nhat
    from (
		select datediff(hd.ngay_ket_thuc, hd.ngay_lam_hop_dong) as thoi_gian_hop_dong
		from hop_dong hd
        join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
        where hd.ma_khach_hang = p_ma_khach_hang
    ) as temp;
    return thoi_gian_dai_nhat;
end //
delimiter ;
select func_tinh_thoi_gian_hop_dong(3) as thoi_gian_dai_nhat;

-- 28.	Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” 
-- từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng dich_vu) và 
-- xóa những hop_dong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng hop_dong) và những bản liên quan khác.
delimiter //
drop procedure if exists sp_xoa_dich_vu_va_hd_room //
create procedure sp_xoa_dich_vu_va_hd_room()
begin 
	delete hop_dong, dich_vu
	from hop_dong
	join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
	where dich_vu.ma_dich_vu in (
		select * from (
			select dich_vu.ma_dich_vu 
            from hop_dong
			join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
			join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
			where year(ngay_lam_hop_dong) between 2015 and 2019 
            and ten_loai_dich_vu = 'room'
        ) as temp
    );
end //
delimiter ;

call sp_xoa_dich_vu_va_hd_room();