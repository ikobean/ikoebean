--회원의 아이디를 입력받아서 이번달 총 대여료를 계산해주는 함수를 작성하시오.
--혹은 분기별로 구하거나 반기별 또는 연별로 대여료를 계산해 보자.

CREATE OR REPLACE FUNCTION ikobean(p_userid IN varchar2)
return number;
IS
msg varchar2(200);
BEGIN
    SELECT NAME,MEM_ID,RENT_FEE FROM MEMBER M,RENT R WHERE M.MEM_ID = R.MEM_ID;
    
    IF(p_userid:=r.mem_id) then
    sum(r.rent_fee);
    
    END IF;
      
END;


