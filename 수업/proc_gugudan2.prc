CREATE OR REPLACE PROCEDURE gugudan(DDD in number, P in number, msg OUT varchar2)
IS
 dan number :=  2;
 i number :=1; 
BEGIN
 for dan in 2..9 loop
 for i in 1..9 loop
  dbms_output.put_line(
  dan||'*'||i||'='||(dan*i));
  end loop;
  END LOOP;
   msg := (dan||'*'||i||'='||(dan*i));   
  END;
  

 
 --------------¼±»ý´ÔÇ®ÀÌ
 
CREATE OR REPLACE PROCEDURE proc_gugudan(dan IN number, i IN number)
IS

BEGIN

END
