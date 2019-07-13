CREATE OR REPLACE PROCEDURE proc_chatlogin(p_id IN varchar2, p_pw IN varchar2, msg OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN msg FOR  
    SELECT nvl((SELECT MEM_name FROM CHAT_MEMBER 
    WHERE MEM_ID=p_id AND MEM_PW=p_pw),'실패')MEM_NICK 
    from DUAL;
END;



--성공했을 때 : 닉네임
--실패했을 때 : 실패 반환




--SELECT MEM_ID, MEM_PW,MEM_NICK into v_id, v_name,v_nick from chat_member
--WHERE mem_id=p_id or mem_pw=p_pw;

--IF(v_id=p_id) then
--IF(v_pw=p_pw) then
--msg:=  v_nick||'님 로그인 성공!';

--elsIF(v_id=p_id) then

