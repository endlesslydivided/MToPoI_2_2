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
('Меркурий',2435,150,0,0),
('Венера',6500,200,0,0),
('Земля',6378,16,1,1),
('Марс',3385,-75,0,0),
('Юпитер',71538,-160,0,0),
('Сатурн',60000,-150,0,0),
('Уран',25515,-220,0,0),
('Нептун',29750,-213,0,0);

use PLANETS_OOP;
INSERT into SATELLITES values
('Луна',1737,384400,'Земля'),
('Фобос',11,6006,'Марс'),
('Деймос',23458,23500,'Марс'),
('Европа',1560,671100,'Юпитер'),
('Ганимед',2634,1070400,'Юпитер'),
('Ио',1821,421700,'Юпитер'),
('Каллисто',2410,1882700,'Юпитер'),
('Амальтея',834,181365,'Юпитер'),
('Гималия',85,11460000,'Юпитер'),
('Титан',2576,1221870,'Сатурн'),
('Энцелад',252,237948 ,'Сатурн'),
('Мимас',198,185539,'Сатурн'),
('Умбриэль',589,266000,'Уран'),
('Титания',198,185539,'Уран'),
('Тритон',1353,354759,'Нептун'),
('Протей',220,117647,'Уран');

--DROP DATABASE PLANETS_OOP;