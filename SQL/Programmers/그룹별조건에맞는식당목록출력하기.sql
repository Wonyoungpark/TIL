-- 코드를 입력하세요
SELECT MEMBER_NAME, r.REVIEW_TEXT, date_format(r.REVIEW_DATE,"%Y-%m-%d") as REVIEW_DATE
from MEMBER_PROFILE as m
left join REST_REVIEW as r
on m.MEMBER_ID=r.MEMBER_ID
where r.member_id=(select MEMBER_ID from REST_REVIEW group by member_id order by count(*) desc limit 1)
order by r.REVIEW_DATE,r.REVIEW_TEXT