CREATE OR REPLACE PROCEDURE proc_exception(p_empno IN number
                                            ,msg OUT varchar2)
IS
    v_emp emp%rowtype;
   -- i number(5):=5;
BEGIN
   -- i := 100/0;
   -- dbms_output.put_line('i�� '||i);
    SELECT ename INTO v_emp.ename
    FROM emp;
    --WHERE empno = p_empno;
   dbms_output.put_line(v_emp.ename);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
        dbms_output.put_line('��ȸ�� �����Ͱ� ����.');
        WHEN TOO_MANY_ROWS THEN
        dbms_output.put_line('��ȸ�� �����Ͱ� �ʹ� ����.');
        WHEN OTHERS THEN
         dbms_output.put_line('�����ڵ�'||SQLCODE);
         dbms_output.put_line('��������'||substr(SQLERRM,1,100));
         END;
