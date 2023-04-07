CREATE DATABASE QUANLYSV

USE QUANLYSV

CREATE TABLE LopHoc
(
	maLop varchar(20) not null primary key,
	tenLop nvarchar(100) not null
)

CREATE TABLE SinhVien
(
	masv char(10) not null primary key,
	ho nvarchar(30),
	ten nvarchar(30) not null,
	phai nvarchar(10),
	email varchar(50),
	diaChi nvarchar(100),
	maLop varchar(20) foreign key references LopHoc(maLop)
)

INSERT LopHoc VALUES('LH01', 'DHKTPM17C'), ('LH02', 'DHKHDL17A')

INSERT SinhVien VALUES('SV01', 'Le', 'Phong', 'Nam', 'abc@gmail.com','Tien Giang', 'LH01'),
('SV02', 'Tran', 'Nhan', 'Nam', 'affdbc@gmail.com','HCM', 'LH02')

SELECT * FROM LopHoc
SELECT * FROM SinhVien