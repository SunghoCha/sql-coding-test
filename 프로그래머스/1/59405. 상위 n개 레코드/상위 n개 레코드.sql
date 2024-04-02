-- ORDEY BY dateime 하고 limit 1로 가져오는게 나을듯
SELECT name
FROM animal_ins
WHERE datetime = (SELECT MIN(DATETIME) from animal_ins);