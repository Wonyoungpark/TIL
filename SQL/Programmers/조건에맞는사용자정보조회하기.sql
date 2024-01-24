-- 코드를 입력하세요
SELECT u.USER_ID,u.NICKNAME,concat(CITY,' ',STREET_ADDRESS1,' ',STREET_ADDRESS2) as 전체주소,REGEXP_REPLACE(TLNO,'(.{3})(.{4})(.{4})','$1-$2-$3')as 전화번호
from USED_GOODS_BOARD as b
inner join USED_GOODS_USER as u
on b.WRITER_ID=u.USER_ID
group by u.USER_ID
having count(u.USER_ID)>=3
order by u.USER_ID desc