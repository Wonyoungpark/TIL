-- 코드를 작성해주세요
# select SCORE,EMP_NO,EMP_NAME,POSITION,EMAIL
with best as (
select emp_no, sum(score) as score
from hr_grade
group by EMP_NO
order by score desc
limit 1
    )
    
select b.SCORE,e.EMP_NO,e.EMP_NAME,e.POSITION,e.EMAIL
from HR_EMPLOYEES as e
inner join best as b
using (EMP_NO)
left join HR_DEPARTMENT as d
on d.DEPT_ID=e.DEPT_ID