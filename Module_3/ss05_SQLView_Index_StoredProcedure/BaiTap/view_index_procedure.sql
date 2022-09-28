create database demo;
use demo;

-- Tạo bảng Products
create table products (
	id int primary key auto_increment,
    productCode varchar(30),
    productName varchar(50), 
    productPrice double,
    productAmount int,
    productDescription varchar(50), 
    productStatus varchar(50)
);

-- Chèn một số dữ liệu mẫu cho bảng Products
insert into products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
values ('N01', 'tivi', 150000.0, 5, 'chắc bền', 'true'),
       ('N09', 'tủ lạnh', 70000.0, 3, 'đẹp', 'fale'),
       ('N06', 'máy tính', 80000.0, 17, 'bền, dùng lâu', 'true'),
       ('N010', 'điều hòa', 300000.0, 20, 'chắc bền', 'true'),
       ('N011', 'lò vi sóng', 10000.0, 15, 'đẹp', 'false'),
       ('N013', 'máy giặt', 190000.0, 11, 'chắc bền', 'true');
select * from products;

-- Index
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index products_code on products (productCode);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index products_index on products (productName, productPrice);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from products where productName = 'Tủ lạnh';

-- So sánh câu truy vấn trước và sau khi tạo index
DROP INDEX products_index ON products;


-- View
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products
create view product_view as
select productCode, productName, productPrice, productStatus
from products;
select * from product_view;

-- Tiến hành sửa đổi view
create or replace view product_view as
select productCode, productName, productPrice, productStatus
from products;
select * from product_view;

-- Tiến hành xoá view
-- drop view product_view;


-- Store Procedure
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
create procedure final_all_products()
begin
	select * from products;
end // 
DELIMITER ;
call final_all_products();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
create procedure product_addnew (
	id int,
	productCode varchar(30),
	productName varchar(50), 
	productPrice double,
	productAmount int,
	productDescription varchar(50), 
	productStatus varchar(50)
)
begin
	insert into products
    values (id, productCode, productName, productPrice, productAmount, productDescription, productStatus);
end //
DELIMITER ;
call product_addnew(7, 'A10', 'laptop', 14000.0, 5, 'chắc bền', 'true');
select * from products;

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
create procedure product_edit_by_id (
	id int,
	productCode varchar(30),
	productName varchar(50), 
	productPrice double,
	productAmount int,
	productDescription varchar(50), 
	productStatus varchar(50)
)
begin
	update products
    set productCode = productCode, 
		productName = productName,
        productPrice = productPrice,
        productAmount = productAmount,
        productDescription = productDescription,
        productStatus = productStatus
	where products.id = id;
end //
DELIMITER ;
call product_edit_by_id (6, 'A15', 'Điện thoại', 190000.0, 11, 'chắc bền', 'true');
select * from products;

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER //
create procedure product_delete_by_id (
	productId int
)
begin 
	delete
    from products
    where products.id = productId;
end //
DELIMITER ;
call product_delete_by_id(6);
select * from products;