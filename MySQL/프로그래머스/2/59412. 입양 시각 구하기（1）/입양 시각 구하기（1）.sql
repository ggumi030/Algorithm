-- 코드를 입력하세요
SELECT hour(datetime) HOUR, count(animal_id) COUNT
from ANIMAL_OUTS
where hour(datetime) > 8 and hour(datetime) < 20
group by 1
order by 1