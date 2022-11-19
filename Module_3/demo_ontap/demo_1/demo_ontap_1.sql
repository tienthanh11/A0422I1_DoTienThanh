create database demo_ontap_1;
use demo_ontap_1;

create table if not exists category(
	category_id int primary key auto_increment,
	category_name varchar(25)
);

insert into category(category_name) 
values ('computer'), ('phone'), ('televison');

create table if not exists product (
	product_id int primary key auto_increment,
	product_name varchar(50),
	product_price double,
	product_quantity int,
	product_color varchar(50),
	product_describe varchar(50),
	category_id int,
	foreign key (category_id) references category(category_id)
);

insert into product(product_name, product_price, product_quantity, product_color, product_describe, category_id) 
values ("iphone 11", 790, 12,"black", "beautiful", 2),
	   ("iphone 12", 800, 15,"black", "beautiful1", 2),
	   ("iphone 13", 790, 12,"red", "beautiful2", 2),
	   ("smart TV", 1790, 21,"blue", "beautiful5", 3);

select * from category;
select product_id, product_name, product_price, product_quantity, product_color, category_id from product;
select * from product where product_id = 3;
select * from product where product_name like 'smart TV';