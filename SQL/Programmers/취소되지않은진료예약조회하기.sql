-- 코드를 입력하세요
SELECT a.APNT_NO,p.PT_NAME,p.PT_NO,d.MCDP_CD,d.DR_NAME,a.APNT_YMD
from PATIENT as p
join APPOINTMENT as a using (PT_NO)
join doctor as d
on d.dr_id=a.MDDR_ID
where a.APNT_YMD like "2022-04-13%" and a.APNT_CNCL_YN="N" and a.MCDP_CD="CS"
order by a.APNT_YMD