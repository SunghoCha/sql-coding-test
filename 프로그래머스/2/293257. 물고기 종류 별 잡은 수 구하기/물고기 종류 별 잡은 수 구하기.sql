-- 코드를 작성해주세요
SELECT COUNT(*) AS fish_count, fish_name
FROM fish_info a LEFT JOIN fish_name_info b ON a.fish_type = b.fish_type
GROUP BY b.fish_type, b.fish_name
ORDER BY fish_count DESC;
