-- 코드를 입력하세요
SELECT COUNT(age) AS users
FROM user_info
WHERE age >= 20 AND age <= 29 AND YEAR(joined) = 2021;