-- 날짜 함수 DATEDIFF, CASE WHEN THEN (앨리어스 조건문 끝나고 써줌)
SELECT 
    history_id, 
    car_id, 
    date_format(start_date, '%Y-%m-%d') start_date, 
    date_format(end_date, '%Y-%m-%d') end_date, 
(CASE WHEN DATEDIFF(end_date, start_date) >= 29 
THEN '장기 대여' 
ELSE '단기 대여' 
END) AS rent_type
FROM car_rental_company_rental_history
WHERE start_date LIKE '2022-09-%'
ORDER BY history_id DESC;