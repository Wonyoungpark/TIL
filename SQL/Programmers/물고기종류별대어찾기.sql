-- 코드를 작성해주세요
select ID,FISH_NAME,LENGTH
from FISH_INFO as i
inner join FISH_NAME_INFO as n
using (FISH_TYPE)
where i.FISH_TYPE in (
    select FISH_TYPE from FISH_INFO
    group by FISH_TYPE
    having length=max(length)
)
order by id