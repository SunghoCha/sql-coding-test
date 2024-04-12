-- GROUP BY HAVING, GROUP BY 먼저 어떻게 묶을건지 주의할 것
SELECT user_id, product_id
FROM online_sale
GROUP BY user_id, product_id
HAVING COUNT(PRODUCT_ID) > 1
ORDER BY user_id ASC, product_id DESC ;