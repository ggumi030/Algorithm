-- 코드를 입력하세요
SELECT substring(product_code,1,2) as CATEGORY, count(product_id) as PRODUCTS
from product
group by 1
order by 1