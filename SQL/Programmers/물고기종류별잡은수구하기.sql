-- 코드를 작성해주세요
select count(ID) as FISH_COUNT, n.FISH_NAME
from FISH_NAME_INFO as n
inner join FISH_INFO as i
using (FISH_TYPE)
group by n.FISH_NAME
order by FISH_COUNT desc