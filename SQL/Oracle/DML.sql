-- 각자의 계정으로 접속한다. conn 계정명/비번

/*
  Datatype의 종류
  1) 문자열   
      CHAR(BYTE수) : 고정길이 - 최대 2000 BYTE
      VARCHAR2(BYTE수) : 가변길이 -최대 4000 BYTE
      
      *유니코드를 지원!!
      NCHAR(BYTE수)
      NVARCHAR2(BYTE수)
      
      * 반드시 문자는 '값'  형식으로 사용한다.
      * ORACLE에서 요즘 UTF-8 인코딩으로 한글자는 3BYTE이다!!
      
        EX) CHAR(6) : 한글 2자, 영문은 6글자
            VARCHAR2(6) : 한글 2자, 영문은 6글자
            
      * CHAR(6 CHAR) : BYTE와 관계없이 6글자까지
        VARCHAR2(6 CHAR) : BYTE와 관계없이 6글자까지
        
      * 대용량의 데이터을 저장해야하는경우 
       LOB : LARGE OBJECT 약자로 대용량의 데이터를 저장할수 있는 데이터 타입 
         1) CLOB : 가변길의 아주 긴 문자열을 저장할때 4GB
         2) BLOB :  가변길의 2진수 형태를 저장할때 4GB
        - LOB타입은 권장하지는 않는다
        
    
  2) 숫자
     : NUMBER
       SMALLINT
       INT
       
       * SMALLINT 또는 INT를 선언해도 결국 내부적으로  NUMBER 타입으로 된다. 
         - 정수형, 실수형 표현
         EX) NUMBER(1) : 정수 -9 ~ 9 표현
             NUMBER(2) : -99 ~ 99 
             
             NUMBER(5,3) : 전체 5자리에서 3자리가 소수점자리.
  
  
  3) 날짜
     : DATE : 년월일 시분초 설정
       TIMESTAMP : 년월일 시분초 + MILS 단위까지 더 정밀하게 표현!!!
      
      *날짜는 반드시 '년-월-일' 형식으로 묶어서 사용한다.
      * 현재 날짜와시간을 구하는 함수 SYSDATE 사용한다.
        EX) SELECT SYSDATE FROM DUAL;
*/


/*
  -테이블 생성
  create table 테이블이름(
    컬럼명 datatype [default 기본값] [ null | not null ] [ constraint 별칭 제약조건 ] ,
    컬럼명 datatype [default 기본값] [ null | not null ] [ constraint 별칭 제약조건 ] ,
    .....
)

  - 제약조건의 종류
   1) PRIMARY KEY : 대표키, 중복X, NOT NULL
   2) FOREIGN KEY :다른 테이블의 컬럼을 참조
   3) UNIQUE : PK유사(테이블에서 대표키는 될수 없는 그렇지만 유일해야하는 속성에 설정) 
   4) CHECK : DOMAIN에 들어갈수 있는 값을 범위를 체크
   
   5) DEFAULT  : 기본값 설정

*/
/*
   1) PRIMARY KEY - PK, 기본키, 대표키
      : PK를 설정하면 중복안됨, NOT NULL , 자동의로 INDEX설정 - EX) 학번, 군번, 주민번호, 상품코드,...아이디...
      : PK는 하나의 테이블에 반드시 한개만 존재
      : 2개의 이상의 컬럼을 하나로 묶어서 PK설정 가능 
          - 복합키설정 : 사용할때 불편해서 모델링 과정속에서 복합키를 대리키로 변환하는 경우 많다!!!
*/
--ex) TABLE 생성
CREATE TABLE MEMBER(
    ID VARCHAR2(20) CONSTRAINT  MEMBER_ID_PK PRIMARY KEY, --MEMBER FIELD의 ID가 PK이다. --NOT NULL, 중복X 선언
    NAME VARCHAR2(10) NOT NULL,
    JUMIN CHAR(13), --NULL허용
    AGE NUMBER(2), -- -99~+99
    ADDR VARCHAR2(10 CHAR),
    REG_DATE DATE
);

--검색 확인
SELECT * FROM MEMBER;

--테이블 구조 확인
DESC MEMBER;

--테이블 삭제
DROP TABLE MEMBER;


/*
  레코드 등록
  INSERT INTO 테이블이름(컬럼명, 컬럼명,....) VALUES(값, 값,값,....);
  INSERT INTO 테이블이름 VALUES(값, 값,값,....); -- 모든 컬럼에 순서대로 값을 넣을때!!!
*/
INSERT INTO MEMBER VALUES('HONG','홍길동','123456',20,'서울',SYSDATE);
INSERT INTO MEMBER (ID,NAME,AGE) VALUES('HEE','히',22);


-- 10byte vs 10char
--insert into member(id,name,addr) values('bb','가나다라','서울시'구);
insert into member(id,name,addr) values('bb','가나다','서울시 강남');


-- char vs varchar2
insert into member(id,name,jumin) values('FF','A','B');
insert into member(id,name,jumin) values('GG','A ','B ');


--VARCHAR2 검색 --가변길이는 공백을 문자열로 인식
SELECT * FROM MEMBER WHERE NAME='A';
SELECT * FROM MEMBER WHERE NAME='A ';

--CHAR 검색 --고정 길이는 공백 고려X
SELECT * FROM MEMBER WHERE JUMIN='B';
SELECT * FROM MEMBER WHERE JUMIN='B  ';


SELECT NAME,JUMIN,LENGTH(NAME), LENGTH(JUMIN) FROM MEMBER WHERE ID='FF';


-- 하나의 테이블에 두개의 컬럼을 하나로 묶어서 PK 설정
CREATE TABLE MEMBER(
    ID VARCHAR2(20),
    NAME VARCHAR2(30) NOT NULL,
    JUMIN CHAR(13),
    AGE NUMBER(3),
    REG_DATE DATE,
    CONSTRAINT MEMBER_ID_JUMIN_PK PRIMARY KEY(ID,JUMIN) --MEMBER TABLE의 ID와 JUMIN을 PK로 설정
);

--테이블 구조 확인
DESC MEMBER;

--레코드 추가
INSERT INTO MEMBER VALUES('HONG','길동','11111-22222',20,SYSDATE);
INSERT INTO MEMBER VALUES('HONG','길동2','11111-33333',20,SYSDATE); --ID와 JUMIN이 모두 일치하면 중복


--테이블 검색
SELECT * FROM MEMBER;
    
----------------------------------------------------------------------------
/*
  2) FOREIGN KEY - FK = 외래키
      : 다른 테이블의 PK를 참조하는 것.
      : 테이블에 레코드를 추가할때 참조되는 대상의 값이외에는 등록 할수 없다.
          - 참조무결성원칙!!!
      : NULL허용, 중복가능!!
      : 하나의 테이블에 여러개의 컬럼이 FK설정가능하다.
      
      : 재귀적관계 설계 - 자기자신테이블의 PK를 참조하는것!!!
      
      *주의사항
        INSERT 할때 : 부모키가 INSERT -> 자식 INSERT 
        DELETE할때 :  참조하고 있는 자식 DELETE -> 부모 DELETE 해야한다.
      
             * 이러한 주의사항에 대한 불편함을 해결하기 위해서.
               FK를 설정할때 ON DELETE CASCADE 를 추가하면 부모레코드를 삭제하를
              그 부모키를 참조하는 모든 테이블의 레코드를 함께 삭제한다.
	      또는 FK설정할때 on delete set null 를 추가하면
	      부모레코드 삭제될때 참조되는 자식레코드의 값이 null이된다.
      
     
*/

-- SCOTT계정 접속
select * from emp;
    --MGR(관리자 번호)는 EMPNO를 FK로 참조 -- 재귀적 설계이다.

-- test 계정 FK 실습
-- 부서 테이블
CREATE TABLE DEPT(
    DEPT_CODE CHAR(3) CONSTRAINT DEPT_CODE_PK PRIMARY KEY,
    DNAME VARCHAR2(30) NOT NULL,
    LOC VARCHAR2(30)
);

--샘플 레코드 추가
INSERT INTO DEPT VALUES('A01','경리부','서울');
INSERT INTO DEPT VALUES('A02','교육부','대구');
INSERT INTO DEPT VALUES('A03','인사부','서울');

--레코드 검색
SELECT * FROM DEPT;


--사원 테이블 생성
CREATE TABLE EMP(
    EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
    ENAME VARCHAR2(15) NOT NULL,
    SAL NUMBER(5),
    DEPT_CODE CHAR(3) CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE),
    HIRE_DATE DATE DEFAULT SYSDATE --현재 날짜 기본 설정
);

SELECT * FROM EMP;
SELECT * FROM DEPT;

--사원 등록
INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE) values(1,'길동',300,'A01');
INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE) values(2,'나영',200,'A01');
INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE) values(3,'미미',200,NULL);


INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE) values(4,'삼식',100,'A05'); --부모키가 존재하지 않기 때문에 불가

INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE,HIRE_DATE) values(4,'삼식',100,'A02','2024-01-20');
INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE,HIRE_DATE) values(5,'삼식',100,'A02',NULL);

INSERT INTO EMP values(6,'삼식',100,'A02'); --컬럼명을 명시하지 않았기 때문에, 값을 덜 주면 오류
INSERT INTO EMP values(6,'삼식',100,'A02',DEFAULT);


--삭제
/*
   레코드 삭제방법
    1) ROLLBACK 처리가능 - DML
      DELETE [FROM] 테이블이름
      [WHERE 조건식]
      
        * FROM 생략가능, WHERE절이 없으면 모든 레코드가 삭제된다.
          
    2) ROLLBACK 안된다. - DDL
     TRUNCATE TABLE 테이블이름; --모든레코드를 삭제
      
*/
--현재 상황을 모두 저장완료
COMMIT;
SELECT * FROM EMP;

--레코드 삭제
DELETE FROM EMP;

--복구
ROLLBACK;


--부모테이블에서 참조되고 있지 않은 레코드를 삭제 (DPET)
DELETE FROM DEPT WHERE DEPT_CODE='A03';

--부모 테이블의 참조되고 있는 레코드를 삭제(DEPT)
DELETE FROM DEPT WHERE DEPT_CODE='A02'; --무결성 위반으로 삭제 불가

-- -> 부모를 참조하는 자식 레코드를 먼저 삭제한 후, 부모레코드를 삭제
DELETE FROM EMP WHERE DEPT_CODE='A02';
DELETE FROM DEPT WHERE DEPT_CODE='A02';



-- ON DELETE CASCADE vs ON DELETE SET NULL

drop table emp;
--사원 테이블 생성
CREATE TABLE EMP(
    EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
    ENAME VARCHAR2(15) NOT NULL,
    SAL NUMBER(5),
    DEPT_CODE CHAR(3) CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE) on delete cascade,
    HIRE_DATE DATE DEFAULT SYSDATE --현재 날짜 기본 설정
);
insert into dept values('A02','인사부','대구');
select * from dept;
--EMP레코드 추가
INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE) values(1,'길동',300,'A01');
INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE) values(2,'나영',200,'A01');
INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE) values(3,'미미',200,NULL);

--부모 테이블을 참조하는 레코드 삭제(dept)
DELETE DEPT WHERE DEPT_CODE='A01';


drop table emp;
--사원 테이블 생성
CREATE TABLE EMP(
    EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
    ENAME VARCHAR2(15) NOT NULL,
    SAL NUMBER(5),
    DEPT_CODE CHAR(3) CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE) on delete set null,
    HIRE_DATE DATE DEFAULT SYSDATE --현재 날짜 기본 설정
);
INSERT INTO DEPT VALUES('A01','경리부','서울');
select * from emp;
--EMP레코드 추가
INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE) values(1,'길동',300,'A01');
INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE) values(2,'나영',200,'A01');
INSERT INTO EMP(EMP_NO,ENAME,SAL,DEPT_CODE) values(3,'미미',200,NULL);

--부모 테이블을 참조하는 레코드 삭제(dept)
DELETE DEPT WHERE DEPT_CODE='A01';


--FK설정을 SQL문장 맨 뒤에서 작성하는 경우
drop table emp;
--사원 테이블 생성
CREATE TABLE EMP(
    EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
    ENAME VARCHAR2(15) NOT NULL,
    SAL NUMBER(5),
    DEPT_CODE CHAR(3),
    HIRE_DATE DATE DEFAULT SYSDATE, --현재 날짜 기본 설정
    CONSTRAINT EMP_DEPT_CODE_FK FOREIGN KEY(DEPT_CODE) REFERENCES DEPT(DEPT_CODE) on delete set null
);

---------------------------------------------------------------
/*
  3) UNIQUE
      : 중복안됨, NULL허용(NOT NULL을 설정하면 PK와 동일) 
      : 후보키중에 대표키가 될수 없는 키를 UNIQUE 설정한다. 
      :  한테이블에 여러개의 컬럼에 설정가능
      
  4) CHECK
      : 조건을 설정하여 조건에 만족하지 않는 정보는 INSERT 할수 없다!
    
  
  5) DEFAULT
      : 기본값 설정(자주사용되는 값을 미리 설정해놓고 자동으로 값이 들어갈수 있또록 하는것)
      : EX) 등록일, 조회수....
      : DEFAULT를 설정할때는 CONSTRAINT 별칭은 안쓴다!!!
      : NOT NULL을 설정하면 DEFALUT를 함께 사용할때는 반드시 DEFAULT를 먼저 작성한다.
*/

CREATE TABLE TEST(
    ID VARCHAR2(10) PRIMARY KEY, --PK별칭 생략
    JUMIN CHAR(13) NOT NULL UNIQUE,
    NAME VARCHAR2(10) UNIQUE,
    AGE NUMBER(2) CHECK (AGE>=20 AND AGE<=30),
    GENDER CHAR(3) CHECK (GENDER='남' OR GENDER='여'),
    REG_DATE DATE DEFAULT SYSDATE NOT NULL --DEFAULT가 반드시 앞에 와야 함
);

DESC TEST;

SELECT * FROM TEST;

--레코드 추가
INSERT INTO TEST(ID,JUMIN, NAME) VALUES('HONG','111','길동');
INSERT INTO TEST(ID,JUMIN, NAME) VALUES('GIL','222',NULL);
INSERT INTO TEST(ID,JUMIN, NAME) VALUES('KING','333',NULL);

INSERT INTO TEST(ID,JUMIN, NAME) VALUES('AAA','333','나영'); --UNIQUE 중복 불가
INSERT INTO TEST(ID,JUMIN, NAME, AGE, GENDER) VALUES('BB','55','나영',22,'남');
INSERT INTO TEST(ID,JUMIN, NAME, AGE, GENDER) VALUES('CC','44','나영3',25,'여');

---------------------------------------------------------------------------------------------------
/*
  테이블 수정
  
 ① 컬럼추가
  alter table 테이블이름 add 
     (컬럼명 자료형 [제약조건] , 컬럼명 자료형 [제약조건] , ....)
 
 ② 컬럼삭제
 alter table 테이블이름 drop column 컬럼이름
 
 ③ datatype변경
    alter table 테이블이름 modify 컬럼이름 변경자료형
    
④ 컬럼이름 변경
 alter table 테이블이름 rename column 기존컬럼명 to 변경컬럼명
 
 ⑤ 제약조건 추가
  alter table 테이블이름 ADD CONSTRAINT 별칭 제약조건종류 ;
  
 -제약조건 삭제
  ALTER TABLE 테이블이름 DROP CONSTRAINT 별칭;
  
 
 - 테이블 삭제
 drop table 테이블이름

*/

drop table test;

create table test(
  id varchar2(20),
  name varchar2(10),
  gender char(3)
);

desc test;

--제약 조건 추가
alter table TEST add constraint test_id_pk primary key(id);
--name not null 설정
alter table test modify name not null;
--gender default 설정
alter table test modify (gender default '남');

select REG_DATE,id from member;
---------------------------------------------------------------------------
/*
SQL의 종류
 - DDL문장(CREATE, DROP, ALTER, TRUNCATE)
 - DML문장(INSERT ,UPDATE, DELETE)
*/

/*
  데이터 조작 : DML(INSERT , UPDATE, DELETE)
   - ROLLBACK OR COMMIT 가능
   
   1) INSERT문장
       -INSERT INTO 테이블이름(컬럼명, 컬럼명,....) VALUES(값, 값,값,....);
       -INSERT INTO 테이블이름 VALUES(값, 값,값,....); -- 모든 컬럼에 순서대로 값을 넣을때!!!
   
   2) DELETE문장
       DELETE [FROM] 테이블이름
       [WHERE 조건식]
   
   3) UPDATE문장
      UPDATE 테이블이름
      SET 컬럼명=변경값 , 컬럼명=변경값,....
      [WHERE 조건식] 

*/



/*
   --테이블 복사
   CREATE TABLE 테이블이름
   AS 복사할테이블정보;
   
   
    주의 : 테이블을 복사하면 제약조건은 복사 안된다!!! - 복사한후에 제약조건을 ALTER를 이용해서 추가한다.*/


--SCOTT 계정
-- 1)모든 레코드&컬럼 복사
CREATE TABLE COPY_EMP
AS SELECT * FROM EMP; --제약 조건 복사 안됨

SELECT * FROM COPY_EMP;
ALTER TABLE COPY_EMP ADD CONSTRAINT COPY_EMP_NO_PK PRIMARY KEY(EMPNO); --제약 조건 추가

--2)조건에 만족하는 특정 레코드와 특정 컬럼의 정보만 복사하고 싶다.
CREATE TABLE COPY_EMP2
AS SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE SAL>2500;

SELECT * FROM COPY_EMP2;

--3)구조만 복사
CREATE TABLE COPY_EMP3
AS SELECT * FROM EMP WHERE 1=0; --조건이 불만족

SELECT * FROM COPY_EMP3;

COMMIT;

--레코드 수정(COPY_EMP)
SELECT * FROM COPY_EMP3;
ROLLBACK;

--ex)empno가 7499인 사원의 job을 teacher, enmae을 heedong 변경
UPDATE copy_emp
SET job='TEACHER', ename='HEEDONG'
WHERE empno=7499;

UPDATE copy_emp
SET job='TEACHER', ename='HEEDONG'
WHERE sal>9000;