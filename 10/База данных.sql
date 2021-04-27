use master;

go
CREATE DATABASE USERSJAVA;

go
use USERSJAVA;

CREATE TABLE USERS
(
id int identity(1,1) constraint PK_USERS primary key(id),
login nvarchar(100) NOT NULL unique,
password nvarchar(500) NOT NULL unique,
salt nvarchar(100) not null unique
)

CREATE TABLE PLAYERS
(
id int identity(1,1) constraint PK_PLAYERS primary key(id),
number int NOT NULL unique,
fullName nvarchar(500) NOT NULL unique
)
