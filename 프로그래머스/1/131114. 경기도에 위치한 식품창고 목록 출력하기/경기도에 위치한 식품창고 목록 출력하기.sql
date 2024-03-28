-- 코드를 입력하세요
SELECT warehouse_id, warehouse_name, address, IFNULL(freezer_yn, 'N')
FROM food_warehouse
WHERE address LIKE '%경기%'
ORDER BY warehouse_id ASC;