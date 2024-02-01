-- 코드를 입력하세요
SELECT ANIMAL_ID,NAME
from ANIMAL_INS
where name like "%EL%" and ANIMAL_TYPE="dog"
order by name