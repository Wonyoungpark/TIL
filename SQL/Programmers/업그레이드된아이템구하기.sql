-- 코드를 작성해주세요
select i.ITEM_ID,ITEM_NAME,RARITY
from ITEM_INFO as i
inner join ITEM_TREE as t
on i.ITEM_ID=t.ITEM_ID
where t.parent_item_id in (select item_id from item_info where RARITY='RARE')
order by i.item_id desc