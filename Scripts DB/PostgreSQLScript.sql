CREATE DATABASE db_account;
 
CREATE TABLE transaction(
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	amount DECIMAL,
 
	type VARCHAR(30),	
	accountid INTEGER
);
 
--INSERT INTO transaction(Amount,Type,AccountId) VALUES(1000,'Deposit','05/12/2019',2)
select * from Transaction;