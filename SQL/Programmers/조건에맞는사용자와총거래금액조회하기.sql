-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, sum(price) as TOTAL_SALES
from USED_GOODS_BOARD as b
inner join USED_GOODS_USER as u
on b.WRITER_ID = u.USER_ID
where STATUS="DONE"
group by WRITER_ID
having TOTAL_SALES>=700000
order by TOTAL_SALES