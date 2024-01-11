-- 코드를 입력하세요
SELECT f.FLAVOR
from first_half as f
join (
    select flavor, sum(TOTAL_ORDER) as TOTAL_ORDER
    from july
    group by flavor) as j
on f.flavor=j.flavor
order by (f.TOTAL_ORDER+j.TOTAL_ORDER) desc
limit 3

-- 참고 사이트 : https://velog.io/@hrlrh/프로그래머스-주문량이-많은-아이스크림들-조회하기