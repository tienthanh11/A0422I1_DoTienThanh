create database QuanLyBanHang;
use QuanLyBanHang;

create table Customer (
	cID int primary key auto_increment,
    cName varchar(25),
    cAge tinyint
);

create table `Order` (
	oID int primary key auto_increment,
    cID int,
    oDate datetime,
    oTotalPrice int,
    foreign key(cID) references Customer(cID)
);

create table Product (
	pID int primary key auto_increment,
    pName varchar(25),
    pPrice int
);

create table OrderDetail (
	oID int,
    pID int,
    odQTY int,
    primary key(oID, pID),
    foreign key(oID) references `Order`(oID),
    foreign key(pID) references Product(pID)
);