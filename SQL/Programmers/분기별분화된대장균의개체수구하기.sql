-- 코드를 작성해주세요
with quart as (
    select id, case
    when MONTH(DIFFERENTIATION_DATE) in (1,2,3) then '1Q'
    when MONTH(DIFFERENTIATION_DATE) in (4,5,6) then '2Q'
    when MONTH(DIFFERENTIATION_DATE) in (7,8,9) then '3Q'
    else '4Q'
    end as QUARTER
    from ECOLI_DATA
)
select q.QUARTER,count(*) as ECOLI_COUNT
from ECOLI_DATA d
inner join quart q
using (id)
group by QUARTER
order by QUARTER
