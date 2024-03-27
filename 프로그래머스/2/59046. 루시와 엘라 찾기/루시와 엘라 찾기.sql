-- 코드를 입력하세요
SELECT animal_id, name, sex_upon_intake
FROM animal_ins
WHERE name IN ('lucy', 'ella', 'pickle', 'rogan', 'sabrina', 'mitty')
ORDER BY animal_id;