-- 코드를 입력하세요
SELECT book_id, DATE_FORMAT(published_date, '%Y-%m-%d')
FROM book
WHERE category = '인문' AND YEAR(published_date) = 2021;