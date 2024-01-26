-- 코드를 입력하세요
SELECT hour(DATETIME) as HOUR,COUNT(*) as COUNT
from ANIMAL_OUTS
group by hour
having hour>=9 and hour<=19
order by hour