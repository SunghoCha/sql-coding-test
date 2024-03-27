-- 코드를 입력하세요
SELECT animal_id, name, 
(CASE WHEN sex_upon_intake LIKE '%neutered%' THEN 'O' 
 WHEN sex_upon_intake LIKE '%spayed%' THEN 'O' ELSE 'X' END) AS S
FROM animal_ins
ORDER BY animal_id;