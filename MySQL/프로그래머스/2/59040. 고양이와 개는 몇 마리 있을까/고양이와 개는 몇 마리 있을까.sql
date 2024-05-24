-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(ANIMAL_ID) count
from ANIMAL_INS
group by 1
order by 1