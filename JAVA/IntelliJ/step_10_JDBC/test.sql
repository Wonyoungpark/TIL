select * from EMP;
select empno,ename,job,sal,hiredate from emp where empno=7499;
select empno,ename,job,sal,hiredate from emp where empno=9999;

insert into emp(empno,ename,job,sal,hiredate) values(9001,'hong','teacher',200,sysdate);
commit;