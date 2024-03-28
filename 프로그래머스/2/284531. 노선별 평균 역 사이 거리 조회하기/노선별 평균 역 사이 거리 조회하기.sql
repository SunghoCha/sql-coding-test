-- CONCAT 붙인 상태로 정렬하니 실패처리됨. 문제 오류인지 아니면 원래 정렬 후 CONCAT하는게 정석인지 확인필요
SELECT Tb.ROUTE, 
    CONCAT(Tb.TOTAL_DISTANCE, 'km') AS TOTAL_DISTANCE, 
    CONCAT(Tb.AVERAGE_DISTANCE, 'km') AS AVERAGE_DISTANCE
FROM (SELECT ROUTE, ROUND(SUM(d_between_dist),1) AS TOTAL_DISTANCE, 
            ROUND(AVG(d_between_dist),2) AS AVERAGE_DISTANCE
        FROM subway_distance
        GROUP BY route
        ORDER BY total_distance DESC) Tb;