DECLARE
   v_name varchar2(30);
BEGIN
   --����� ������ ���� �ʱ�ȭ
   v_name := '������';
   dbms_output.put_line('����� �̸��� '||v_name||'�Դϴ�.');
END;




CREATE OR REPLACE PROCEDURE proc_test(p_name IN varchar2,msg OUT varchar2)
IS --DECLARE ��� IS
   v_name varchar2(30);
BEGIN
   v_name := '������';
   dbms_output.put_line('����� �̸��� '||p_name||'�Դϴ�.');
   msg:='���������� ó���Ǿ����ϴ�.';
END;

--REPLACE�� �־�� re-compile �� �� ����.--�Ķ����=-�Ű����� ������

--�ּ� ���� new ���� f5 ������ ���ν��� ����.

begin
 proc_test('haha');
 end;
 









CREATE OR REPLACE PROCEDURE proc_test(p_name IN varchar2,msg OUT varchar2)
IS 
   v_name varchar2(30);
BEGIN
   v_name := '������';
   dbms_output.put_line('����� �̸��� '||p_name||'�Դϴ�.');
   msg:='���������� ó���Ǿ����ϴ�.';
END;








CREATE OR REPLACE PROCEDURE proc_p340(temp IN varchar2)
IS v_eno number(4);
   v_ename emp.ename%type;
BEGIN
   v_eno := 7566;
   v_ename := 'TIGER';
   DBMS_OUTPUT.PUT_LINE(v_eno||'    '||v_ename);
END;

CREATE OR REPLACE PROCEDURE  �̸�(���̵� IN Ÿ��,��� IN Ÿ��,�޼��� OUT Ÿ��)
IS --��������ó�� ���ص� ��. ��������. ���� ������ �̹� ������ �̷����



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
msg:=v_name||'�� ȯ���մϴ�.';
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
msg:=v_name||'�� ȯ���մϴ�.';
END;


