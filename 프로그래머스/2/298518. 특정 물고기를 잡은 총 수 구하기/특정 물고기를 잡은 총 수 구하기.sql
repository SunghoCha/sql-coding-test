-- 코드를 작성해주세요
SELECT COUNT(*) FISH_COUNT 
FROM fish_info a 
LEFT JOIN fish_name_info b 
on a.fish_type = b.fish_type
WHERE b.fish_name IN ('BASS', 'SNAPPER');