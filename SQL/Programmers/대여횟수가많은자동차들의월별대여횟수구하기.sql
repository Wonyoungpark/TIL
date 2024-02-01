-- 코드를 입력하세요
SELECT month(start_Date) as MONTH,CAR_ID,count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_Date between "2022-08-01" and "2022-10-31" --기간 내 월의 총 대여횟수>0
    and car_id in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                  where start_Date between "2022-08-01" and "2022-10-31"
                  group by car_id
                  having count(*)>=5) --기간 내 자동차별 총 대여횟수 계산
group by month,car_id
order by month, car_id desc