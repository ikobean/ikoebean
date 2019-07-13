문제
아이디 중복검사를 담당자가 원하고 있다.
중복검사하는 SELECT 문을 작성해 보시오.

--아이디가 존재하지 않으면 조회결과는 없다.
--로우가 없다

SELECT MEM_NAME 이름
FROM MEMBER
WHERE MEM_ID =:user_id

--   =:이 단위테스트하는거

--그룹함수 사용하는 경우에는 조회결과가 없다 하더라도 응답이 있다.
--전체범위처리 하므로 속도가 느리다. 
--안쓸 수 있으면 안쓰는게 좋음!
--그래서 질문을 바꾼거다~ 몇개있어? 가 아니고 존재하니?


SELECT count(MEM_NAME) 몇명
FROM MEMBER
WHERE MEM_ZIPCODE =:user_zipcode

select count(mem_name) 몇명
from member
where mem_id=:user_id


아이디가 존재하니?

SELECT 1 FROM dual
 WHERE EXISTS (SELECT mem_name FROM member 
               WHERE mem_id =: user_id
               AND rownum=1
               )
               
               rownum = 스탑기능/ 순번 세는 기능