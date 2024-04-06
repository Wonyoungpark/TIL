-- 코드를 작성해주세요
select ITEM_ID,ITEM_NAME,RARITY
from item_info as i
where i.item_id not in (
    select PARENT_ITEM_ID
    from item_tree
    where PARENT_ITEM_ID is not null
)
order by i.item_id desc