DECLARE
   v_name varchar2(30);
BEGIN
   --선언된 변수에 대한 초기화
   v_name := '내복이';
   dbms_output.put_line('당신의 이름은 '||v_name||'입니다.');
END;
