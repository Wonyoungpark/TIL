/*
   SELECT문장 - DQL문장
    : 구조
    select distinct | * | 컬럼명 as 별칭, 컬럼명 별칭,....   : 열을 제한 :PROJECTION
    from 테이블이름     
    [where 조건식 ]  : 레코드(튜플)제한  - SELECTION
    [order by 컬럼명 desc | asc , .. ] -정렬
    
    
    * distinct 는 중복레코드를 제거
    * AS 는 컬럼에 별칭 만들기 
    * 실행순서
      SELECT   3) 
      FROM     1)
      WHERE    2) 
      ORDER BY 4) 
    
*/

--EX) SCOTT계정 접속 

SELECT * FROM EMP; --사원테이블
SELECT * FROM DEPT;--부서정보테이블

--1) EMP테이블에서 원하는 컬럼(별칭)
SELECT empno AS 사원번호, ename 이름, job AS 직무,  hiredate,sal
FROM emp;


--2) 중복행 제거하기 - DISTINCT
 --EX) 우리회사에 어떤 JOB있는지 JOB의 종류를 알고싶다!!!
SELECT DISTINCT job --특정한 컬럼만 갖고 올 경우 사용
FROM emp;

 
--3) 조건 만들기 
 -- 급여가 3000이상인 사원 검색
SELECT empno,ename,job,sal
FROM EMP
WHERE sal>=3000;

 
 --4) 정렬
 -- 급여가 2000이상인 사원을 검색하고 급여를 기준으로 정렬
SELECT *
FROM EMP e 
WHERE sal>=2000
ORDER BY sal;


 --JOB을 기준으로 내림차순정렬하고 JOB이 같으면 급여를 기준으로 정렬
SELECT *
FROM EMP e 
ORDER BY job DESC, sal;


--칼럼들끼리 연산이 가능하다
--급여와 커미션을 더하고 12를 곱해서 연봉 컬럼 생성
SELECT empno, ename,sal, comm,(sal+nvl(comm,0))*12 AS 연봉
FROM emp;

-- NULL값을 다른 값으로 변경해서 연산 할 수 있다  -->  NVL(칼럼명, 변경값)
SELECT comm,nvl(comm,20) FROM emp;
  
--님 년봉은 ~입니다. 출력 ---  문자열 연결 || 이용
SELECT ename || '님 연봉은 ' || (sal+nvl(comm,0))*12 || '입니다.' AS message
FROM emp;

-- ||연산자 => concat()
SELECT CONCAT(ename,concat('님 연봉은 ',concat((sal+nvl(comm,0))*12,'입니다.')) AS message
FROM emp;

SELECT concat(concat(ename, '님 연봉은 '), CONCAT((sal+nvl(comm,0))*12, '입니다.')) AS message
FROM emp;

-----------------------------------------------------------------------------------
/*
  연산자 종류
  1) 산술연산자
     +, -, *, / 
     나머지 : MOD(값, 나눌수)
     
   2) 관계연산자
       > , <, >= , <= , !=, <>
       같다  :  =
       
   3) 비교연산자
    - AND
    - OR
    - IN :  컬럼명 IN (값, 값, 값)  - 하나의 컬럼을 대상으로 또는으로 비교할때 사용한다.
    
    - BETWEEN AND :  컬럼명 BETWEEN 최소 AND 최대 - 하나의 컬럼을 대상으로 최소 ~ 최대를 비교할때
    
    - LIKE  : 와일드카드 문자와 함께 사용한다.
        1. % : 0개이상의 문자
        2. _ : 한글자  
        
        EX)  name like 'J%' ;   - NAME에 첫글자가 J로 시작하는 모든 문자
             name like '___' ;  - NAME이 3글자 
             name like 'J_J%';  - NAME의 첫글자가 J로 시작하고 3번째 글자 A인 정보 검색
             
    
    - NOT : 위의 모든 연산자들 앞에 NOT을 붙히면 반대 개념.
        
*/
--EX) 산술연산자 : EMP에서 년봉계산 = (SAL + COMM) *12  해서 년봉 컬럼 
 
 
 -- * NVL(값, 대치값)  : NULL을 찾아 대치값으로 변경한다. 


--EX) 년봉을 계산하기 위해서 COMM의 NULL을 찾아 0으로 변경한후 연산한다. - NVL함수 사용


--EX) ~님의 년봉은 ~ 입니다. 출력  : 문자열을 연결할때 || 사용한다.



--EX) SAL 가 2000 ~ 4000사원 검색(AND, BETWEEN AND )
SELECT * FROM emp WHERE sal>=2000 AND sal<= 4000;
SELECT * FROM emp WHERE sal BETWEEN 2000 and 4000;

--EX) SAL 가 2000 ~ 4000사원아닌 레코드 검색 -  NOT
SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 4000;


--EX) EMPNO 가 7566, 7782,7844인 사원검색 ( OR, IN)
SELECT * FROM emp WHERE empno=7566 or empno=7782 OR empno=7844;
SELECT * FROM emp WHERE empno in(7566, 7782,7844);


--EX) EMPNO 가 7566, 7782,7844인 사원이 아닌 검색 ( NOT)
SELECT * FROM emp WHERE NOT(empno=7566 or empno=7782 OR empno=7844);
SELECT * FROM emp WHERE empno NOT in(7566, 7782,7844);


---------------------------------------------------------------------------
--1) JOB에 'A' 문자로 시작하는 레코드 검색
SELECT * FROM emp WHERE job LIKE 'A%';

--2) JOB에 끝 끌자가 'N'으로 끝나는 레코드 검색
SELECT * FROM emp WHERE job LIKE '%N';

--3) ENAME이 4글자인 레코드 검색
SELECT * FROM emp WHERE LENGTH(ENAME)=4;

--4) ENAME에 A글자가 포함된 레코드 검색
SELECT * FROM emp WHERE ename LIKE '%A%';

--5) ENAME전체 글자가 5글자이고 두번째 글자가 m이면서 끝글자가 h인 레코드 검색
SELECT * FROM emp WHERE ename LIKE '_M__H';
SELECT * FROM emp WHERE lower(ename) LIKE lower('_M__H');

--) 문자열에서 %를 단어로 포함한 레코드를 검색
INSERT INTO COPY_EMP ce(empno,ename,job) values(888,'HEE%DONG','TEACHER');
SELECT * FROM COPY_EMP WHERE ENAME LIKE '%%%'; --모든 레코드가 검색된다.(wildcard로 인식)
SELECT * FROM COPY_EMP ce WHERE ename LIKE '%#%%' ESCAPE '#';

-------------------------------------------------------------------------------------------------


/*
    NULL 찾기
    1) IS NULL
    2) IS NOT NULL
*/

-- COMM이 NULL인 레코드 검색
SELECT * FROM emp WHERE comm IS NULL;
SELECT * FROM emp WHERE comm=NULL;
SELECT * FROM emp WHERE comm IS NOT NULL;

COMMIT;

--COPY_EMP 테이블에서 COMM이 NULL레코드를 COMM의 값을 100으로 변경
SELECT comm,nvl(comm,100) FROM COPY_EMP ce; 
UPDATE COPY_EMP SET comm=100 WHERE comm IS NULL;
SELECT * FROM COPY_EMP WHERE comm IS NULL;

-- NULL이 있는 컬럼을 대상으로 정렬을 해보자
SELECT * FROM EMP ORDER BY COMM; -- 오름차순일때는 NULL은 마지막에 조회된다
SELECT * FROM EMP ORDER BY COMM DESC; -- 내름차순일때는 NULL은 처음에 조회된다 
SELECT * FROM EMP ORDER BY COMM ASC NULLS FIRST; --NULL을 우선적으로 출력




                    
                    
                    
 
 

------------------------------------------------------------------