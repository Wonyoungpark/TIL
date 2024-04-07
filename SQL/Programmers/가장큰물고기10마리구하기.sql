-- 코드를 작성해주세요
select ID,LENGTH
from FISH_INFO
where length is not null
order by length desc,id
limit 10