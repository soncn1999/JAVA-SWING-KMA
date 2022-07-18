create database DoAN_DBMS character set='utf8';
use DoAn_DBMS;
/*Tao bang bang nhap
	Ten dang nhap: admin
	mat khau: admin
*/
create table dangnhap(
	tendangnhap varchar(100) not null,
	matkhau varchar(100) not null
);
/*
	Tao bang Chuc vu
*/
create table chucvu(
	ma_cv char(10) primary key,
	ten_cv varchar(100) not null,
	hesoluong int not null
);

/*Tao bang nhan vien*/

create table nhanvien(
	ma_nv char(10) primary key,
	ma_cv char(10),
	foreign key (ma_cv) references chucvu(ma_cv),
	ten_nv varchar(100) not null,
	ngaysinh date not null,
	sodt char (20) not null,
	diachi varchar(200)  
);

/*Tao table ca lam*/

create table calam(
	ma_calam char(10) primary key,
	ma_nv char(10),
	foreign key (ma_nv) references nhanvien(ma_nv),
	ngaylam date not null;
	buoi char(10)
	ghichu varchar(200)
);


/*Them ten dang nhap va mat khau*/
insert into dangnhap value ('admin', 'admin');

/*Them chuc vu + he so luong*/
insert into chucvu  value('TN',  'Thu Ngân', 100000);
insert into chucvu  value('LC',  'Lao Công', 80000);
insert into chucvu  value('PV', 'Phục Vụ', 90000);
insert into chucvu  value('PC', 'Pha Chế', 11000);

/*Thêm thông tin nhân viên*/

insert into nhanvien value ('01', 'TN', 'Sơn Thươl', '2000-01-24', '0377087266', 'Sóc Trăng');
insert into nhanvien value ('02', 'PC', 'Nguyễn Ngọc Hoàng', '2000-02-12', '0377087266', 'Trà Vinh');
insert into nhanvien value ('03', 'PV', 'Đào Ngọc Mỹ', '2001-05-04', '0377087266', 'Hậu Giang');
insert into nhanvien value ('04', 'TN', 'Thạch Thị Kiều Oanh', '2000-02-25', '0377087266', 'Kiên Giang');
insert into nhanvien value ('05', 'TN', 'Kiêm Lâm Huyền Trân', '2000-07-22', '0377087266', 'Bạc Liêu');
insert into nhanvien value ('06', 'PC', 'Danh Thị Cẩm Tú', '2000-09-02', '0377087266', 'TP. Hồ Chí Minh');
insert into nhanvien value ('07', 'PV', 'Lý Chiến', '2000-11-22', '0377087266', 'Bình Dương');
insert into nhanvien value ('08', 'LC', 'Thạch Minh Pháp', '2000-09-25', '0377087266', 'Sóc Trăng');
insert into nhanvien value ('09', 'TN', 'Lý Hoàng Tuấn', '2000-09-25', '0377087266', 'Cà Mau');
insert into nhanvien value ('10', 'PC', 'Danh Thị Tú Trâm', '2000-09-25', '0377087266', 'Sóc Trăng');
insert into nhanvien value ('11', 'PV', 'Lê Trung Hiếu', '2000-09-25', '0377087266', 'Hậu Giang');
insert into nhanvien value ('12', 'LC', 'Nguyễn Thị Anh Thư', '2000-09-25', '0377087266', 'Bạc Liêu');
insert into nhanvien value ('13', 'TN', 'Trần Thúy Vy', '2000-09-25', '0377087266', 'Bạc Liêu');
insert into nhanvien value ('14', 'PC', 'Diệp Xuân Quang', '2000-09-25', '0377087266', 'Sóc Trăng');
insert into nhanvien value ('15', 'PV', 'Châu Thị Ta Na', '2000-09-25', '0377087266', 'Trà Vinh');
insert into nhanvien value ('16', 'LC', 'Thạch Thị Ngọc Dung', '2000-09-25', '0377087266', 'An Giang');


/*Them ca lam*/
/*23/11/2020-29/11/2020*/
insert into calam value (null, '01', '2020-11-23','S','');
insert into calam value (null, '01', '2020-11-23','C','');
insert into calam value (null, '02', '2020-11-24','S','');
insert into calam value (null, '03', '2020-11-25','S','');
insert into calam value (null, '04', '2020-11-26','S','');
insert into calam value (null, '13', '2020-11-27','S','');
insert into calam value (null, '14', '2020-11-28','S','');
insert into calam value (null, '15', '2020-11-29','S','');
insert into calam value (null, '05', '2020-11-23','C','');
insert into calam value (null, '06', '2020-11-24','C','');
insert into calam value (null, '07', '2020-11-25','C','');
insert into calam value (null, '08', '2020-11-26','C','');
insert into calam value (null, '09', '2020-11-27','T','');
insert into calam value (null, '10', '2020-11-28','T','');
insert into calam value (null, '01', '2020-11-29','T','');
insert into calam value (null, '02', '2020-11-20','T','');
insert into calam value (null, '11', '2020-11-23','T','');
insert into calam value (null, '12', '2020-11-19','T','');
insert into calam value (null, '16', '2020-11-23','S','');
insert into calam value (null, '01', '2020-11-25','C','');
insert into calam value (null, '02', '2020-11-22','C','');
insert into calam value (null, '03', '2020-11-28','C','');
insert into calam value (null, '04', '2020-11-21','C','');
insert into calam value (null, '03', '2020-11-20','T','');
insert into calam value (null, '04', '2020-11-19','T','');


SELECT soca.nv AS 'manv', soca.ten AS 'tennv', cv.ma_cv AS 'cv', cv.hesoluong AS 'dongia', soca.sc AS 'soca', soca.sc*cv.hesoluong AS 'luong'
FROM chucvu cv, (SELECT cl.ma_nv nv , nv.ma_cv cv, COUNT(cl.ma_calam) sc, nv.ten_nv ten 
                FROM calam cl, nhanvien nv
                WHERE cl.ma_nv = nv.ma_nv AND (cl.ngaylam BETWEEN '2020-11-23' AND '2020-11-25')
                GROUP BY cl.ma_nv) soca
WHERE cv.ma_cv = soca.cv
ORDER BY soca.nv



(SELECT soca.nv AS 'manv', soca.ten AS 'tennv', cv.ma_cv AS 'cv', cv.hesoluong AS 'dongia', soca.sc 					AS 'soca', soca.sc*cv.hesoluong AS 'luong'
				FROM chucvu cv, (SELECT cl.ma_nv nv , nv.ma_cv cv, COUNT(cl.ma_calam) sc, nv.ten_nv ten 
                					FROM calam cl, nhanvien nv
                					WHERE cl.ma_nv = nv.ma_nv
               					 GROUP BY cl.ma_nv) soca
				WHERE cv.ma_cv = soca.cv
				ORDER BY soca.nv
)


INSERT INTO nhanvien (ma_nv, ma_cv, ten_nv, ngaysinh, sodt, diachi) 
VALUES ('', 'TN', 'Sơn Thươl', '2000-01-24', '0377087266', 'Sóc Trăng');



