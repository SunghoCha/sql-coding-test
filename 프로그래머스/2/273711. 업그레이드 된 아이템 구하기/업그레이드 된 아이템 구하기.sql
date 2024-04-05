-- 희귀도가 RARE인 아이템들의 모든 업그레이드 아이템
SELECT I.ITEM_ID, I.ITEM_NAME, I.RARITY
FROM ITEM_INFO I LEFT JOIN ITEM_TREE T ON I.ITEM_ID = T.ITEM_ID
WHERE T.PARENT_ITEM_ID IN
(SELECT ITEM_ID
FROM ITEM_INFO
WHERE RARITY = 'RARE')
ORDER BY ITEM_ID DESC ;


-- 희귀도가 rare인 아이템들의 모든 다음 업그레이드 아이템
-- 희귀도가 레어인 아이디가 PARENT_ITEM_id = 데이터 0,1
-- 0과 1을 PARENT_ITEM_ID로 가진 것들  셀렉

-- PARENT_ITEM_ID = 'NULL' 이면 root라는 의미
-- PARENT_ITEM_ID = 'IS NOT NULL' == 다음 업그레이드 아이템