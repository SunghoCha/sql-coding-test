-- 코드를 입력하세요
SELECT A.FLAVOR
FROM first_half a LEFT JOIN icecream_info b 
ON a.FLAVOR = b.FLAVOR
WHERE a.total_order > 3000 AND b.ingredient_type = 'fruit_based'
ORDER BY a.total_order desc;