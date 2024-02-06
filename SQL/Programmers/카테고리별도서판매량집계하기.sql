-- 코드를 입력하세요
SELECT CATEGORY,sum(s.sales) as TOTAL_SALES
from BOOK as b
inner join BOOK_SALES as s
on b.BOOK_ID=s.BOOK_ID
where SALES_DATE like "2022-01%"
group by CATEGORY
order by CATEGORY