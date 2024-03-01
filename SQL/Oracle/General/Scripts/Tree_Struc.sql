 * 계층형 쿼리
 --scott접속

SELECT * FROM emp;


SELECT LEVEL , empno, mgr, LPAD(' ', 4*(LEVEL-1)) || ename 
 FROM emp
 START WITH mgr IS NULL --루트노드
CONNECT BY PRIOR empno = mgr; 

---------------------
CREATE TABLE BOM (
  ITEM_ID     INTEGER NOT NULL,
  PARENT_ID   INTEGER references BOM(item_id),
  ITEM_NAME   VARCHAR2(20)  NOT NULL,
  ITEM_QTY    INTEGER, 
  PRIMARY KEY (ITEM_ID)
);
            

INSERT INTO BOM VALUES ( 1001, NULL, '컴퓨터', 1);
INSERT INTO BOM VALUES ( 1002, 1001, '본체', 1);
INSERT INTO BOM VALUES ( 1003, 1001, '모니터', 1);
INSERT INTO BOM VALUES ( 1004, 1001, '프린터', 1);

INSERT INTO BOM VALUES ( 1005, 1002, 'Mother Board', 1);
INSERT INTO BOM VALUES ( 1006, 1002, '랜카드', 1);
INSERT INTO BOM VALUES ( 1007, 1002, 'Power Supply', 1);

INSERT INTO BOM VALUES ( 1008, 1005, 'RAM', 1);
INSERT INTO BOM VALUES ( 1009, 1005, 'CPU', 1);
INSERT INTO BOM VALUES ( 1010, 1005, '그래픽장치', 1);
INSERT INTO BOM VALUES ( 1011, 1005, '기타장치°', 1);

  
 select * from bom;
 
 SELECT  item_id, parent_id, LPAD(' ', 4*(LEVEL-1)) || item_name item_names
 FROM bom
 START WITH parent_id IS NULL -- 루트노드
CONNECT BY  parent_id = PRIOR item_id ;


--테이블생성
create table zipcode(
  zip varchar2(20) ,
  sido	varchar2(100),
  si	varchar2(100),
  dong	varchar2(200),
  ri	varchar2(100),
  doseo	 varchar2(100),
  bunji	varchar2(100),
  apt	varchar2(100),
  address varchar2(300)
);

SELECT * FROM zipcode;
-- 터미널: sqlldr userid=scott/TIGER control='test.ctl'