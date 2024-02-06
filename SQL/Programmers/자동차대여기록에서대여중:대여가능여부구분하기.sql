-- 코드를 입력하세요
with history as (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date<="2022-10-16" and "2022-10-16"<=end_date
    group by CAR_ID
)

SELECT distinct CAR_ID,
    case
        when car_id in (select * from history) then "대여중"
        else "대여 가능"
    end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by CAR_ID desc