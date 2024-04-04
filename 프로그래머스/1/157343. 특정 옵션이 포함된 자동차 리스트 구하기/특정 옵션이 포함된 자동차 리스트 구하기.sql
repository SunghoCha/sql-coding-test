-- FIND_IN_SET : ,로 구분된 리스트에서 특정값 검색하기 
SELECT *
FROM car_rental_company_car
WHERE FIND_IN_SET("네비게이션", options)
ORDER BY car_id DESC;