-- 코드를 작성해주세요
with fe as (select sum(code) from SKILLCODES where category='Front End'),
py as (select code from SKILLCODES where name='Python'),
c as (select code from SKILLCODES where name='C#'),
g as (select case
    when SKILL_CODE&(select * from fe) and SKILL_CODE&(select * from py) then 'A'
    when SKILL_CODE&(select * from c) then 'B'
    when SKILL_CODE&(select * from fe) then 'C'
    end as GRADE,ID,EMAIL
from DEVELOPERS)

select *
from g
where GRADE is not null
order by grade,id

-- 참고 사이트 : https://school.programmers.co.kr/questions/72687