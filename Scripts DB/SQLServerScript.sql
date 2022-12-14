CREATE DATABASE db_account;
GO
 
USE db_account;
 
CREATE TABLE Customer(
	idcustomer INT PRIMARY KEY,
	fullname VARCHAR(150),
	email VARCHAR(50)
);
 
INSERT INTO Customer VALUES(1,'Gianluca Lapadula','glapadula@aforo255.com');
INSERT INTO Customer VALUES(2,'Leonel Messi','lmessi@aforo255.com');
INSERT INTO Customer VALUES(3,'Paolo Guerrero','pguerrero@aforo255.com');
INSERT INTO Customer VALUES(4,'Andrea Pirlo','apirlo@aforo255.com');
INSERT INTO Customer VALUES(5,'Renato Tapia','rtapia@aforo255.com');
select * from Customer;
 
CREATE TABLE Account(
	idaccount INT PRIMARY KEY, 
	totalamount NUMERIC(18,2),
	idcustomer INT
);
 
 
INSERT INTO account VALUES(1,1000,1);
INSERT INTO account VALUES(2,5000,1);
INSERT INTO account VALUES(3,300,2);
INSERT INTO account VALUES(4,600,1);
INSERT INTO account VALUES(5,400,2);
INSERT INTO account VALUES(6,100,1);
INSERT INTO account VALUES(7,1000,3);
INSERT INTO account VALUES(8,2000,4);
INSERT INTO account VALUES(9,5000,5);
INSERT INTO account VALUES(10,1000,2);
 
 
SELECT * FROM Account;
 
ALTER TABLE Account
ADD FOREIGN KEY (IdCustomer) REFERENCES Customer(IdCustomer);