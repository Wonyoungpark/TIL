-- 코드를 입력하세요
SELECT HISTORY_ID,CAR_ID,
        DATE_FORMAT(START_DATE,"%Y-%m-%d") as START_DATE,
        DATE_FORMAT(END_DATE,"%Y-%m-%d") as END_DATE,
        IF(DATEDIFF(END_DATE,START_DATE)>=29, '장기 대여','단기 대여') as RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where month(start_date)=9
order by HISTORY_ID desc

-- 참고 사이트 : https://eunbin00.tistory.com/139