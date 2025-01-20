-- 코드를 입력하세요
SELECT NAME
FROM (
    SELECT NAME
    FROM animal_ins
    ORDER BY datetime ASC
)
WHERE ROWNUM = 1;
