-- 코드를 입력하세요
SELECT count(USER_ID) USERS
from USER_INFO
where AGE Between 20 and 29 and Year(JOINED) = 2021