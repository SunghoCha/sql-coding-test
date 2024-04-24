-- 코드를 입력하세요
# SELECT PRODUCT_ID, P1.PRICE
# FROM FOOD_PRODUCT P1
# WHERE (CATEGORY, PRICE)
# IN(
# SELECT CATEGORY, MAX(PRICE) AS PRICE
# FROM FOOD_PRODUCT
# GROUP BY CATEGORY
# ) TB

SELECT CATEGORY, P1.PRICE AS MAX_PRICE, PRODUCT_NAME 
FROM FOOD_PRODUCT P1
WHERE (CATEGORY, PRICE) IN (
    SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
    FROM FOOD_PRODUCT
    GROUP BY CATEGORY
) AND CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY MAX_PRICE DESC;



# SELECT * FROM FOOD_PRODUCT;