-- 코드를 입력하세요
SELECT i.REST_ID,REST_NAME,FOOD_TYPE,FAVORITES,ADDRESS,Round(avg(r.REVIEW_SCORE),2) as SCORE
from REST_INFO as i
inner join REST_REVIEW as r
on i.REST_ID=r.REST_ID
where ADDRESS like "서울%"
group by i.REST_ID
order by SCORE desc, FAVORITES desc