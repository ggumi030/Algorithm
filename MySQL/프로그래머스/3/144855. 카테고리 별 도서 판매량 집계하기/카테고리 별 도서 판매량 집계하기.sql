-- 코드를 입력하세요
SELECT BOOK.category, sum(BOOK_SALES.sales) TOTAL_SALES
from BOOK_SALES left join BOOK on BOOK_SALES.BOOK_ID = BOOK.BOOK_ID
where DATE_format(BOOK_SALES.SALES_DATE,'%Y-%m') = '2022-01'
group by 1
order by 1