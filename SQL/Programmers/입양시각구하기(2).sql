# -- 코드를 입력하세요
set @HOUR=-1;
SELECT (@HOUR:=@HOUR+1) as hour,
(select count(*) from ANIMAL_OUTS where hour(datetime)=@hour) as count
from ANIMAL_OUTS
group by hour
order by hour
limit 24
