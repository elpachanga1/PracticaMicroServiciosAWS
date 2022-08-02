CREATE DATABASE db_security;
USE db_security;
 
CREATE TABLE IF NOT EXISTS access(
userid INT AUTO_INCREMENT PRIMARY KEY,
fullname VARCHAR(255) NOT NULL,
username VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL
);
 
INSERT INTO access(fullname, username, password)
VALUES('Usuario Aforo255 1', 'aforo255','123456');
INSERT INTO access(fullname, username, password)
VALUES('Usuario Aforo255 2', 'aforo2','654');
INSERT INTO access(fullname, username, password)
VALUES('Usuario Aforo255 3', 'aforo3','123');
 
SELECT * FROM access;