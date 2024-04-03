-- 코드를 작성해주세요
with grade as (
    select emp_no,
        case
            when avg(score)>=96 then 'S'
            when avg(score)>=90 then 'A'
            when avg(score)>=80 then 'B'
            else 'C'
            end
        as grade
    from HR_GRADE
    group by emp_no
)

select e.EMP_NO,e.EMP_NAME,g.GRADE,
    case g.grade
        when 'S' then e.sal*0.2
        when 'A' then e.sal*0.15
        when 'B' then e.sal*0.1
        else 0
        end
    as BONUS
from HR_EMPLOYEES as e
inner join grade as g
using (emp_no)
order by e.emp_no