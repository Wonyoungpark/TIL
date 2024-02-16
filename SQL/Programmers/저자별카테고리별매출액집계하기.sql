-- 코드를 입력하세요
with jan as (
SELECT *
from BOOK_SALES
where SALES_DATE like "2022-01%")

select a.AUTHOR_ID,a.AUTHOR_NAME,b.CATEGORY,sum(j.sales*b.price) as TOTAL_SALES
from book as b
left join author as a using (AUTHOR_ID)
inner join jan as j using (book_id)
group by a.AUTHOR_ID,b.CATEGORY
order by a.AUTHOR_ID,b.CATEGORY desc