-- 코드를 입력하세요
SELECT MEMBER_ID,MEMBER_NAME,GENDER,TO_CHAR(DATE_OF_BIRTH,'YYYY-MM-DD') DATE_OF_BIRTH 
from MEMBER_PROFILE 
where gender = 'W' and to_char(DATE_OF_BIRTH,'MM') = '03'
and TLNO != 'Null'
order by MEMBER_ID asc;