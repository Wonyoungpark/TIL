with recursive parent as (
    select parent_id, count(parent_id) as cnt
    from ECOLI_DATA
    group by parent_id
)
select ID, coalesce(cnt, 0) as CHILD_COUNT
from ECOLI_DATA as e
left join parent p on p.parent_id = e.id
