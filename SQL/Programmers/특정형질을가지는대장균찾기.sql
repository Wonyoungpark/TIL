-- 코드를 작성해주세요
select COUNT(ID) as COUNT
from ECOLI_DATA
where (GENOTYPE&2 !=2) and (GENOTYPE&1 > 0 or GENOTYPE&4 > 0)