-- 코드를 입력하세요
SELECT PRODUCT_CODE, SUM(PRICE*s.SALES_AMOUNT) as SALES
from PRODUCT as p
inner join OFFLINE_SALE as s
on p.PRODUCT_ID=s.PRODUCT_ID
group by PRODUCT_CODE
order by sales desc, PRODUCT_CODE