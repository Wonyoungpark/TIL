--ws계정
select * from users;

insert into users (user_seq, name, email, phone) values (444, '사길동', 'sa@gildong@com', '010-4444-4444');
insert into users (user_seq, name, email, phone) values (555, '오길동', 'o@gildong@com', '010-5555-5555');

CREATE TABLE account
( 
    account_seq   NUMBER,
    account_number VARCHAR2(50) not null,
    balance       NUMBER,
    user_seq      NUMBER,
	CONSTRAINT account_pk PRIMARY KEY (account_seq)
);

insert into account (account_seq, account_number, balance, user_seq) values (50, '00500505005005', 3000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (10, '00100101001001', 1000, 111);
insert into account (account_seq, account_number, balance, user_seq) values (30, '00300303003003', 5000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (70, '00700707007007', 7000, 444);
insert into account (account_seq, account_number, balance, user_seq) values (40, '00400404004004', 4000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (60, '00600606006006', 2000, 222);
insert into account (account_seq, account_number) values (80, '00800808008008');
insert into account (account_seq, account_number, balance, user_seq) values (20, '00200202002002', 6000, 111);

SELECT * FROM USERS;
SELECT * FROM ACCOUNT;

------------------------
SELECT * FROM account WHERE USER_seq=111;

SELECT * FROM ACCOUNT WHERE balance<5000;

SELECT * FROM ACCOUNT WHERE account_number LIKE '%4%';

SELECT * FROM USERS u  WHERE NAME LIKE '삼%';

SELECT DISTINCT user_seq FROM ACCOUNT ;

SELECT * FROM ACCOUNT WHERE balance IS NULL;

SELECT * FROM ACCOUNT WHERE user_seq IS NOT NULL;

SELECT * FROM ACCOUNT wherer user_seq IS NOT NULL AND balance<=4000;

SELECT * FROM ACCOUNT ORDER BY USER_seq;

SELECT * FROM ACCOUNT ORDER BY user_seq,balance DESC;

SELECT account_number, balance, nvl(balance,0) FROM ACCOUNT ;

SELECT user_seq,name, substr(email,0,instr(email,'@')-1) AS email_id FROM users;

SELECT * FROM users;
SELECT user_seq,name, email, REPLACE(phone,'-','') AS phone_short FROM users;