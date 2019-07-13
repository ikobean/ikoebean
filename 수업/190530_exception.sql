CREATE OR REPLACE PROCEDURE proc_exception(p_empno IN number
                                            ,msg OUT varchar2)
IS
    v_emp emp%rowtype;
   -- i number(5):=5;
BEGIN
   -- i := 100/0;
   -- dbms_output.put_line('i는 '||i);
    SELECT ename INTO v_emp.ename
    FROM emp;
    --WHERE empno = p_empno;
   dbms_output.put_line(v_emp.ename);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
        dbms_output.put_line('조회된 데이터가 없다.');
        WHEN TOO_MANY_ROWS THEN
        dbms_output.put_line('조회된 데이터가 너무 많아.');
        WHEN OTHERS THEN
         dbms_output.put_line('에러코드'||SQLCODE);
         dbms_output.put_line('에러내용'||substr(SQLERRM,1,100));
         END;
