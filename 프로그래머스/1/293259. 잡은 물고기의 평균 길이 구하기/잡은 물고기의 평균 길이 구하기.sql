-- 코드를 작성해주세요
SELECT round(AVG(length),2) AS AVERAGE_LENGTH
FROM 
(SELECT IFNULL(LENGTH, 10) length
FROM fish_info) Tb ;

-- IFNULL()하고 뒤에 col 넣어주는것 주의