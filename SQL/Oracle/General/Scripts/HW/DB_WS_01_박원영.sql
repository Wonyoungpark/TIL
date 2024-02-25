--계정 생성, 권한 부여
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
CREATE USER ws IDENTIFIED BY ws;
GRANT CONNECT,resource,dba TO ws;

DROP TABLE users;
CREATE TABLE users(
	user_seq number(10) CONSTRAINT users_number_pk PRIMARY KEY,
	name varchar(10),
	email varchar(30) NOT NULL UNIQUE,
	phone varchar(30),
	is_sleep char(1) DEFAULT 'N'
);


INSERT INTO users VALUES (111, '홍길동', 'hong@gildong@com', '010-1111-1111', default);
INSERT INTO users VALUES (222, '이길동', 'lee@gildong@com', '010-2222-2222', default);
INSERT INTO users VALUES (333, '삼길동', 'sam@gildong@com', '010-3333-3333', default);


SELECT * FROM users;
SELECT is_sleep FROM users;


UPDATE users SET is_sleep='Y' WHERE user_seq=222;


INSERT INTO users(user_seq,name,email,phone) VALUES (222, '이길동2', 'lee2@gildong@com', '010-2222-2222');
INSERT INTO users(user_seq,name,email,phone) VALUES (222, '이길동2', 'lee@gildong@com', '010-2222-2222');
INSERT INTO users(user_seq,name,phone) VALUES (222, '이길동2', '010-2222-2222');
INSERT INTO users(user_seq,name,email,phone) VALUES (222, '이길동2', 'lee2@gildong@com', '010-2222-2222');


------------

DROP TABLE room;
DROP TABLE teacher;
DROP TABLE subject;
DROP TABLE student;

CREATE TABLE subject(
	수강코드 varchar2(5) PRIMARY KEY,
	과목 varchar2(25) NOT null
);

CREATE TABLE room(
	강의실번호 NUMBER PRIMARY KEY,
	수용인원 NUMBER NOT null
);

CREATE TABLE teacher(
	강사번호 NUMBER PRIMARY KEY,
	강사이름 varchar2(12) NOT NULL,
	주민등록번호 varchar2(14) NOT NULL,
	연락처 varchar2(14) NOT NULL,
	주소 varchar2(50),
	이메일 varchar2(20),
	수강코드 varchar2(5) NOT NULL,
	FOREIGN KEY(수강코드) REFERENCES subject(수강코드)
);

INSERT INTO subject values('j1001','sql');
INSERT INTO subject values('j1002','Win2000');
INSERT INTO subject values('j1003','ASP');
INSERT INTO subject values('j1004','Php');
INSERT INTO subject values('j1005','java');
INSERT INTO subject values('j1006','javascript');

INSERT INTO room values(901,34);
INSERT INTO room values(902,35);
INSERT INTO room values(903,25);
INSERT INTO room values(904,32);
INSERT INTO room values(905,30);
INSERT INTO room values(906,35);

INSERT INTO teacher VALUES(1,'홍길동','700918-1622011','031-295-1234','성남시 중원구 신흥동','kkk@jok.or.kr','j1001');
INSERT INTO teacher VALUES(2,'유관순','710419-2018916','031-345-2345','서울시 강남구 개포동','kkk@jok.or.kr','j1002');
INSERT INTO teacher VALUES(3,'이승복','730112-1344911','031-1234-6789','서울시 강남구 논현동','sss@jok.or.kr','j1003');
INSERT INTO teacher VALUES(4,'모택동','730301-1167623','031-567-5678','서울시 서초구 서초동','mmm@jok.or.kr','j1004');
INSERT INTO teacher VALUES(5,'주롱지','730322-2037921','031-789-3456','서울시 강서구 가양동','xxx@jok.or.kr','j1005');
INSERT INTO teacher VALUES(6,'이순신','731122-1646213','031-234-8901','서울시 강서구 미아동','ppp@jok.or.kr','j1006');

SELECT * FROM teacher;


CREATE TABLE student(
	수강생번호 NUMBER PRIMARY KEY,
	수_이름 varchar2(12) NOT null,
	수_주민등록번호 varchar2(14) NOT null,
	수_연락처 varchar2(14) NOT null,
	수_주소 varchar2(50),
	수_이메일 varchar2(20)
);

CREATE TABLE sugangTB(
	수강코드 varchar2(5),
	강의실번호 NUMBER,
	시간 NUMBER NOT NULL,
	강사번호 NUMBER,
	FOREIGN KEY (수강코드) REFERENCES subject(수강코드),
	FOREIGN KEY (강사번호) REFERENCES teacher(강사번호)
);

CREATE TABLE sugagn(
	수강생번호 NUMBER PRIMARY KEY,
	수강코드 varchar2(5),
	FOREIGN KEY (수강생번호) REFERENCES student(수강생번호),
	FOREIGN KEY (수강코드) REFERENCES subject(수강코드)
);


INSERT INTO student values(1,'김현진','771212-2346111','017-888-8888','부산','aaa@hanmail.net');
INSERT INTO student values(2,'김석주','720112-1234812','016-999-9999','부산','bbb@hanmail.net');
INSERT INTO student values(3,'고훈기','730102-1555555','017-555-5555','경기','ccc@hanmail.net');
INSERT INTO student values(4,'유민경','801111-2222222','017-222-2222','서울','ddd@hanmail.net');
INSERT INTO student values(5,'김영수','811231-1777777','017-777-7777','전남','eee@hanmail.net');
INSERT INTO student values(6,'박상원','790915-1333333','017-333-3333','강원','fff@hanmail.net');

INSERT INTO sugangTB values('j1001',901,2,1);
INSERT INTO sugangTB values('j1002',902,2,2);
INSERT INTO sugangTB values('j1003',903,2,3);
INSERT INTO sugangTB values('j1004',904,2,4);
INSERT INTO sugangTB values('j1005',905,2,5);
INSERT INTO sugangTB values('j1006',906,2,6);

INSERT INTO sugagn values(1,'j1001');
INSERT INTO sugagn values(2,'j1002');
INSERT INTO sugagn values(3,'j1003');
INSERT INTO sugagn values(4,'j1004');
INSERT INTO sugagn values(5,'j1005');
INSERT INTO sugagn values(6,'j1006');

