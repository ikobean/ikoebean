CREATE OR REPLACE PROCEDURE proc_refcursor(p_rc OUT sys_refcursor)
IS
 BEGIN
  OPEN p_rc
  FOR SELECT empno, ename,sal, comm FROM emp;
END;
