DECLARE
   v_name varchar2(30);
BEGIN
   --선언된 변수에 대한 초기화
   v_name := '내복이';
   dbms_output.put_line('당신의 이름은 '||v_name||'입니다.');
END;




CREATE OR REPLACE PROCEDURE proc_test(p_name IN varchar2,msg OUT varchar2)
IS --DECLARE 대신 IS
   v_name varchar2(30);
BEGIN
   v_name := '내복이';
   dbms_output.put_line('당신의 이름은 '||p_name||'입니다.');
   msg:='정상적으로 처리되었습니다.';
END;

--REPLACE가 있어야 re-compile 할 수 있음.--파라미터=-매개변수 같은말

--주석 없이 new 에서 f5 눌러서 프로시져 만듦.

begin
 proc_test('haha');
 end;
 









CREATE OR REPLACE PROCEDURE proc_test(p_name IN varchar2,msg OUT varchar2)
IS 
   v_name varchar2(30);
BEGIN
   v_name := '내복이';
   dbms_output.put_line('당신의 이름은 '||p_name||'입니다.');
   msg:='정상적으로 처리되었습니다.';
END;








CREATE OR REPLACE PROCEDURE proc_p340(temp IN varchar2)
IS v_eno number(4);
   v_ename emp.ename%type;
BEGIN
   v_eno := 7566;
   v_ename := 'TIGER';
   DBMS_OUTPUT.PUT_LINE(v_eno||'    '||v_ename);
END;

CREATE OR REPLACE PROCEDURE  이름(아이디 IN 타입,비번 IN 타입,메세지 OUT 타입)
IS --전역변수처럼 안해도 됨. 생략가능. 변수 선언이 이미 위에서 이루어짐



SELECT MEM_NAME FROM MEMBER
 WHERE MEM_ID = 'test
 '
 AND MEM_PW = '123'
 
 V_NAME VARCHAR2(30);
 
 
 
CREATE OR REPLACE PROCEDURE proc_login(pmem_id IN varchar2
                                      ,pmem_pw IN varchar2
                                      ,msg OUT varchar2)
IS
v_name varchar2(30);
BEGIN
SELECT MEM_NAME INTO pmem_id FROM MEMBER
WHERE MEM_ID = 'test'
AND MEM_PW = '123';
msg:=v_name||'님 환영합니다.';
END;




CREATE OR REPLACE PROCEDURE proc_login(pmem_id IN varchar2
                                      ,pmem_pw IN varchar2
                                      ,msg OUT varchar2)
IS
v_name varchar2(30);
BEGIN
SELECT MEM_NAME INTO pmem_id FROM MEMBER
WHERE MEM_ID = 'haha'
AND MEM_PW = '111';
msg:=v_name||'님 환영합니다.';
END;


