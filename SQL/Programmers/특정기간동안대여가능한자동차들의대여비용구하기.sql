# -- 코드를 입력하세요
# with cars as (
# select *
# from CAR_RENTAL_COMPANY_CAR
# where CAR_TYPE in ("세단","SUV")
# ), cars_date as (
# select car_id, datediff(end_date,start_date) as total_date
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where end_date>="2022-11-01" and start_date<="2022-11-30"
# group by car_id
# ), car_discount as(
# select car_type,DISCOUNT_RATE
# from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
# where DURATION_TYPE="30일 이상")

# SELECT c.CAR_ID,c.CAR_TYPE,round(c.daily_FEE*(1-p.DISCOUNT_RATE/100)*30) as FEE
# from cars as c
# inner join cars_date as h
# on c.CAR_ID=h.CAR_ID
# left join car_discount as p
# on c.CAR_TYPE=p.CAR_TYPE
# group by CAR_TYPE
# having FEE>=500000 AND FEE<2000000
# order by FEE DESC, c.CAR_TYPE, c.car_id desc


select C.car_id, C.car_type, round(C.daily_fee*30*(100-P.discount_rate)/100) as FEE
from CAR_RENTAL_COMPANY_CAR as C
inner join (
    select car_type,DISCOUNT_RATE
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where DURATION_TYPE = '30일 이상') as P
on C.car_type = P.car_type
where c.CAR_ID not in (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where END_DATE > '2022-11-00' and START_DATE < '2022-12-00')
    and C.car_type in ('세단','SUV') 
having FEE >= 500000 and FEE <= 2000000
order by FEE desc, C.car_type, C.car_id desc;