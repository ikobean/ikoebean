CREATE OR REPLACE FUNCTION ODD(p_num IN NUMBER)
RETURN varchar2
IS
v_msg varchar2(300);
BEGIN
 IF MOD(p_num,2)=0 then
 V_MSG := '¦���Դϴ�.';
 ELSIF MOD(p_num,2)=1 then
 V_MSG := 'Ȧ���Դϴ�.';
 END IF;
 return V_MSG;
END;

--�Ķ���� - NUMBER ���� 10.50
--���� - VARCHAR2


CREATE OR REPLACE FUNCTION ODD(p_num IN NUMBER)
RETURN varchar2
IS
RESULT varchar2(300);
BEGIN
 IF MOD(p_num,2)=0 then
 RESULT := '¦���Դϴ�.';
 ELSE
 RESULT := 'Ȧ���Դϴ�.';
 END IF;
 return V_MSG;
END;


select ODD(10) from dual;
print msg;