CREATE OR REPLACE PROCEDURE proc_login(p_id in varchar2 ,p_pw in varchar2 , msg out varchar2 )
IS
v_id varchar2(30);
v_pw varchar2(30);
v_name varchar2(30);
BEGIN

SELECT MEM_ID, MEM_PW, MEM_NAME into v_id, v_pw, v_name from member
WHERE MEM_id=p_id or MEM_pw=p_pw;



IF (v_id = p_id) then
IF (v_pw = p_pw) then
msg :=  v_name || '님 환영합니다';


elsif(v_pw != p_pw) then
msg :=  v_name || '님 비번 틀림';
END IF;


ELSIF
    (v_id != p_id)then
msg :=  v_name || '님 아이디 틀림';

END IF;


dbms_output.put_line(msg);

END;
