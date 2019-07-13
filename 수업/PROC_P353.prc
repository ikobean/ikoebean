CREATE OR REPLACE PROCEDURE proc_p353(temp IN varchar2)
IS 
    v_dept dept%rowtype;
    CURSOR c1
    IS
    SELECT DEPTNO,DNAME,LOC FROM dept;
BEGIN 
    open c1;
    loop
    FETCH c1 INTO v_dept.deptno, v_dept.dname, v_dept.loc;
        exit when c1%notfound;
    dbms_output.put_line(v_dept.deptno||'  '||v_dept.dname||'  '||v_dept.loc);
    end loop;
    close c1;
END;

EXEC PROC_P353('A');