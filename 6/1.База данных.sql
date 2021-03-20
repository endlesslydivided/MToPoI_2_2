--use master;
--create database PLANETS_OOP;
use PLANETS_OOP;

create table PLANETS
(
	NAMES varchar(50) NOT NULL constraint PK_PLANETS primary key (NAMES),
	RADIUS int  NOT NULL,
	TEMPERATURE float(2) NOT NULL,
	HAVE_ATMOSPHERE bit NOT NULL,
	HAVE_LIFE bit NOT NULL
)

create table SATELLITES
(
	NAMES varchar(50) NOT NULL constraint PK_SATELLITES primary key (NAMES),
	RADIUS int  NOT NULL,
	DISTANCE int NOT NULL,
	PLANET varchar(50) not NULL constraint FK_SATELLITES_PLANETS foreign key (PLANET) references PLANETS(NAMES)
)

use PLANETS_OOP;
INSERT into PLANETS values
('��������',2435,150,0,0),
('������',6500,200,0,0),
('�����',6378,16,1,1),
('����',3385,-75,0,0),
('������',71538,-160,0,0),
('������',60000,-150,0,0),
('����',25515,-220,0,0),
('������',29750,-213,0,0);

use PLANETS_OOP;
INSERT into SATELLITES values
('����',1737,384400,'�����'),
('�����',11,6006,'����'),
('������',23458,23500,'����'),
('������',1560,671100,'������'),
('�������',2634,1070400,'������'),
('��',1821,421700,'������'),
('��������',2410,1882700,'������'),
('��������',834,181365,'������'),
('�������',85,11460000,'������'),
('�����',2576,1221870,'������'),
('�������',252,237948 ,'������'),
('�����',198,185539,'������'),
('��������',589,266000,'����'),
('�������',198,185539,'����'),
('������',1353,354759,'������'),
('������',220,117647,'����');

--DROP DATABASE PLANETS_OOP;