CREATE OR REPLACE FUNCTION ODD(p_num IN NUMBER)
RETURN varchar2
IS
v_msg varchar2(300);
BEGIN
 IF MOD(p_num,2)=0 then
 V_MSG := '짝수입니다.';
 ELSIF MOD(p_num,2)=1 then
 V_MSG := '홀수입니다.';
 END IF;
 return V_MSG;
END;

--파라미터 - NUMBER 숫자 10.50
--리턴 - VARCHAR2


CREATE OR REPLACE FUNCTION ODD(p_num IN NUMBER)
RETURN varchar2
IS
RESULT varchar2(300);
BEGIN
 IF MOD(p_num,2)=0 then
 RESULT := '짝수입니다.';
 ELSE
 RESULT := '홀수입니다.';
 END IF;
 return V_MSG;
END;


select ODD(10) from dual;
print msg;