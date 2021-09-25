-- tao schema
create schema javacore;
use javacore;

-- tao table
create table HocVien
(
    stt         int	auto_increment,	
    hoten       varchar(50),
    ngaysinh    date,
    diem        float,
    
    primary key(stt)
);

insert into HocVien(hoten, diem) 
values
	('Nguyen Van A', 8),
    ('Tran Thi B', 9.5),
    ('Ta Thi C', 6),
    ('Phan Thanh D', 4),
    ('Truong Thi E', 6);