-- 코드를 입력하세요
SELECT DISTINCT(C1.CAR_ID)
FROM CAR_RENTAL_COMPANY_CAR AS C1
INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS C2 ON C1.CAR_ID = C2.CAR_ID
WHERE MONTH(C2.START_DATE) = 10 AND CAR_TYPE = '세단'
ORDER BY CAR_ID DESC;