-- 코드를 입력하세요
SELECT dr_name, dr_id, mcdp_cd, DATE_FORMAT(hire_ymd, '%Y-%m-%d') as hire_ymd
FROM doctor
WHERE mcdp_cd IN ('cs', 'gs')
ORDER BY hire_ymd desc, dr_name asc;