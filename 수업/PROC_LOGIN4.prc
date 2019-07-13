CREATE OR REPLACE PROCEDURE proc_login4(pmem_id IN varchar2
                                      ,msg OUT varchar2)
IS
v_name varchar2(30);
BEGIN
SELECT NAME INTO V_NAME FROM MEMBER
WHERE MEM_ID = 'APPLE';
msg:=v_name||'님 환영합니다.';
END;