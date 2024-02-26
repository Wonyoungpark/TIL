Create Table subemp(
	emp_id int, --사원번호
	emp_name Varchar2(20) Not Null,  --사원이름
	job Varchar2(20) Not Null,  --직업
	dept_id int, --부서번호
	sal int Not Null,--급여
	bonus int,--보너스
	mgr_id int,--관리자번호
	hiredate date Not Null, --입사일
	constraint emp_id_pk22 Primary Key(emp_id) --제약조건
);

DROP TABLE subemp;