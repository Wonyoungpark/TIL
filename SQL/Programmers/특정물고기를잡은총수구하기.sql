-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from FISH_INFO as i
inner join FISH_NAME_INFO as n
using (FISH_TYPE)
where n.FISH_NAME in ('BASS', 'SNAPPER')