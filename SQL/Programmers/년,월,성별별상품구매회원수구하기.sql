-- 코드를 입력하세요
SELECT year(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH,GENDER, count(distinct u.USER_ID) as USERS
from USER_INFO as u
inner join ONLINE_SALE as o
on u.USER_ID=o.USER_ID
where gender is not null
group by year,month,gender
order by year,month,gender