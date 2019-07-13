CREATE OR REPLACE PROCEDURE proc_p344(pename IN varchar2, pempno IN number, msg OUT varchar2)
IS
    v_emp emp%rowtype;
    annsal number(20,2);
BEGIN
    SELECT      empno,ename,sal,job,mgr, comm,hiredate,deptno 
            INTO v_emp.empno,V_EMP.ENAME,V_EMP.SAL,v_emp.job,v_emp.mgr,v_emp.comm,v_emp.hiredate,v_emp.deptno
    from emp
    where ename=pename;
    IF v_emp.comm is null THEN
    v_emp.comm :=0;
    END IF;
    annsal:=v_emp.sal*12+V_EMP.comm;
    UPDATE emp
        SET sal = annsal
        WHERE empno = pempno;
    dbms_output.put_line('사원번호  사원이름    연봉');
    dbms_output.put_line('--------------------');
    dbms_output.put_line(v_emp.empno||'    '||v_emp.ename||'   '||annsal);
    msg := v_emp.ename ||'님의 연봉은'||annsal||'입니다.';
END;

