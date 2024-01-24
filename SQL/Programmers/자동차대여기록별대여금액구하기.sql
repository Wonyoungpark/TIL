-- 코드를 입력하세요
WITH RENTAL_HISTORY AS (
    SELECT *,
        CASE
            WHEN datediff(end_date,start_date)+1<7 THEN NULL
            WHEN DATEDIFF(END_DATE,START_DATE)+1<30 THEN '7일 이상'
            WHEN DATEDIFF(END_DATE,START_DATE)+1<90 THEN '30일 이상'
            ELSE '90일 이상'
        END AS DURATION_TYPE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
), TRUCKS AS (
    SELECT * FROM CAR_RENTAL_COMPANY_CAR
    WHERE CAR_TYPE='트럭')
        
SELECT h.HISTORY_ID, ROUND(IF(P.DURATION_TYPE IS NULL,
                             T.DAILY_FEE*(DATEDIFF(H.END_DATE,H.START_DATE)+1),
                          T.DAILY_FEE*(DATEDIFF(H.END_DATE,H.START_DATE)+1)*(1-P.DISCOUNT_RATE/100))) AS FEE
from TRUCKS AS T

inner join RENTAL_HISTORY as h
on T.CAR_ID = h.CAR_ID
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p
on T.CAR_TYPE=p.CAR_TYPE
AND H.DURATION_TYPE=P.DURATION_TYPE
group by h.history_id
order by fee desc,h.history_id desc