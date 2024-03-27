-- 코드를 작성해주세요
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME 
FROM developer_infos
WHERE skill_1 = 'python' OR skill_2 = 'python' OR skill_3 = 'python'
ORDER BY id asc;