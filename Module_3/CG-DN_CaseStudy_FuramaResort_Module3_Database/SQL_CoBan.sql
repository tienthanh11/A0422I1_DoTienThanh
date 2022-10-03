use Furama_Resort_Manager;

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien
where ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%' and length(ho_ten) < 15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang
where year(curdate()) - year(ngay_sinh) between 18 and 50
and (dia_chi like '%Đầ Nẵng' or dia_chi like '%Quảng Trị');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select kh.ma_khach_hang, kh.ho_ten, count(*) as so_lan_dat_phong
from loai_khach lk
inner join khach_hang kh on lk.ma_loai_khach = kh.ma_loai_khach
inner join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where lk.ten_loai_khach = 'Diamond'
group by kh.ma_khach_hang
order by so_lan_dat_phong;

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_khach_hang, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,
	   ifnull(sum(hdct.so_luong * dvdk.gia) + temp.gia_dich_vu, 0) as tong_tien
from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
left join (
	select kh.ma_khach_hang, ifnull(sum(dv.chi_phi_thue), 0) as gia_dich_vu
    from khach_hang kh
    join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
    join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
    group by kh.ma_khach_hang
) temp on kh.ma_khach_hang = temp.ma_khach_hang
group by kh.ma_khach_hang;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt 
-- từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
-- Cách 1
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
inner join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where not exists (
	select *
    from hop_dong hd
    where hd.ngay_lam_hop_dong between '2021-01-01' and '2021-03-31' and dv.ma_dich_vu = hd.ma_dich_vu
)
group by dv.ma_dich_vu
order by dv.dien_tich desc;

-- Cách 2
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where dv.ma_dich_vu not in (
	select dv.ma_dich_vu
    from  dich_vu dv
    join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
    where month(ngay_lam_hop_dong) between 1 and 3 and year(ngay_lam_hop_dong) = 2021
);

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
-- đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
inner join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where exists (
	select *
    from hop_dong hd
    where year(hd.ngay_lam_hop_dong) = '2020' and ma_dich_vu = dv.ma_dich_vu
)
and not exists (
	select *
    from hop_dong hd
    where year(hd.ngay_lam_hop_dong) = '2021' and ma_dich_vu = dv.ma_dich_vu
)
group by dv.ma_dich_vu;

-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
-- Cách 1:
select distinct ho_ten from khach_hang;

-- cách 2:
select ho_ten from khach_hang
union
select ho_ten from khach_hang;

-- Cách 3:
select row_number() over(order by ho_ten) as 'STT', ho_ten from khach_hang
group by ho_ten;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hd.ngay_lam_hop_dong) as thang, count(hd.ma_khach_hang) as so_luong_khach_hang
from khach_hang kh
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where year(hd.ngay_lam_hop_dong) = 2021
group by thang
order by thang;

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, sum(ifnull(hdct.so_luong, 0)) as so_luong_dich_vu_di_kem
from hop_dong hd
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_hop_dong;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
where lk.ten_loai_khach = 'Diamond' and (kh.dia_chi like '%Vinh' or kh.dia_chi like '%Quảng Ngãi');

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select hd.ma_hop_dong, nv.ho_ten as ho_ten_nhan_vien, kh.ho_ten as ho_ten_khach_hang, kh.so_dien_thoai as sdt_khach_hang, dv.ma_dich_vu, dv.ten_dich_vu,
	   sum(ifnull(hdct.so_luong, 0)) as so_luong_dich_vu_di_kem, hd.tien_dat_coc
from hop_dong hd
left join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien
left join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
where (
	hd.ngay_lam_hop_dong between '2020-10-01' and '2020-12-30'
)
and (
	hd.ngay_lam_hop_dong not between '2021-01-01' and '2021-06-30'
)
group by hd.ma_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem >= all (
	select hdct.so_luong
    from hop_dong_chi_tiet hdct
);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
-- (được tính dựa trên việc count các ma_dich_vu_di_kem).
select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong hd
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having so_lan_su_dung = 1
order by hd.ma_hop_dong;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
from nhan_vien nv
join trinh_do td on nv.ma_trinh_do = td.ma_trinh_do
join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where year(hd.ngay_lam_hop_dong) between 2020 and 2021
group by nv.ma_nhan_vien
having count(hd.ma_nhan_vien) <= 3
order by nv.ma_nhan_vien;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
delete from nhan_vien nv
where not exists (
	select *
    from hop_dong hd 
    where hd.ma_nhan_vien = nv.ma_nhan_vien
    and year(hd.ngay_lam_hop_dong) between 2019 and 2021
);
select * from nhan_vien;

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với 
-- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
update khach_hang
set ma_loai_khach = 1
where ma_loai_khach != 1 and ma_khach_hang in (
	select test.ma_khach_hang 
    from (
		select kh.ma_khach_hang
        from khach_hang kh
        join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
        join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
        join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
        join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
        group by kh.ma_khach_hang
        having sum(ifnull(dv.chi_phi_thue, 0) + ifnull(dvdk.gia, 0) * ifnull(hdct.so_luong, 0)) > 10000000
	) as test
);

select kh.ma_khach_hang, kh.ho_ten, kh.ma_loai_khach = 1 as ma_loai_khach
from khach_hang kh;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
-- After set CASCADE
delete from khach_hang kh
where not exists (
	select 1
	from hop_dong
    where kh.ma_khach_hang = ma_khach_hang and year(ngay_lam_hop_dong) >= 2021
);

select kh.ma_khach_hang, kh.ho_ten
from khach_hang kh; 

-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
UPDATE dich_vu_di_kem
SET gia = gia * 2
WHERE ma_dich_vu_di_kem IN	(
	SELECT tmp.ma_dich_vu_di_kem 
	FROM (
		SELECT dvk.ma_dich_vu_di_kem 
		FROM dich_vu_di_kem dvk
		JOIN hop_dong_chi_tiet hct ON hct.ma_dich_vu_di_kem = dvk.ma_dich_vu_di_kem
        JOIN hop_dong hd ON hd.ma_hop_dong = hct.ma_hop_dong
		WHERE YEAR(hd.ngay_lam_hop_dong) = 2020
		GROUP BY hct.ma_dich_vu_di_kem
		HAVING COUNT(hct.ma_dich_vu_di_kem) >= 10
	) AS tmp
);

select * from dich_vu_di_kem;

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm 
-- id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select nv.ma_nhan_vien, nv.ho_ten, nv.email, nv.so_dien_thoai, nv.ngay_sinh, nv.dia_chi
from nhan_vien nv
union all
select kh.ma_khach_hang, kh.ho_ten, kh.email, kh.so_dien_thoai, kh.ngay_sinh, kh.dia_chi
from khach_hang kh;