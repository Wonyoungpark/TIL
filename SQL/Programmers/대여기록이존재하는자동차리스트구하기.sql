-- 코드를 입력하세요
SELECT distinct c.CAR_ID
from CAR_RENTAL_COMPANY_CAR as c
inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
on c.CAR_ID=h.CAR_ID
where CAR_TYPE="세단" and Month(h.START_DATE)="10"
order by c.CAR_ID desc