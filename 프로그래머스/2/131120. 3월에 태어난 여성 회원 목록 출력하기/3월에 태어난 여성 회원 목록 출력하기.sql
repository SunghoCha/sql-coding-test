-- 코드를 입력하세요
-- 코드를 입력하세요
SELECT member_id, member_name, gender, DATE_FORMAT(date_of_birth, '%Y-%m-%d') 
from member_profile 
where gender = 'w' 
and MONTH(date_of_birth) = 3
and tlno is not null order by member_id asc ;