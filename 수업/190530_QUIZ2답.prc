
��������2 - cursor,update ���
�μ���ȣ�� �Է� �޾Ƽ� �μ��޿� ����� ���ϰ� 
�� �μ��� �ٹ��ϴ� ������� �޿��� 
���� ������ 10% �λ�
���� ������ 20% �λ�
�޿����̺� ����ó���ϴ� ���ν����� �ۼ��Ͻÿ�.


CREATE OR REPLACE PROCEDURE proc_deptnoUpdate(p_deptno IN number, msg OUT varchar2)
IS  
    v_avgsal number(7,2); --��ձ޿� ���
    v_empno number;
    v_ename varchar2(30);
    v_sal number(7,2);
    v_rate number(3,1);
    USER_EXCEPTION EXCEPTION;
    CURSOR emp_cur IS
    SELECT empno, ename, sal FROM emp
    WHERE deptno = p_deptno;
BEGIN
    SELECT avg(sal) INTO v_avgsal
    FROM emp
    WHERE deptno = p_deptno;
    
    OPEN emp_cur;
        LOOP
            FETCH emp_cur INTO v_empno, v_ename, v_sal;
            IF dept_cur %rowcount = 0then
            riase user exception
            end if
            EXIT WHEN emp_cur%notfound;
            IF v_sal > v_avgsal THEN
               v_rate := 1.1;
            ELSE v_rate := 1.2;
            END IF ;
            UPDATE emp SET sal=sal*v_rate
             WHERE empno = v_empno;
        END LOOP;
    CLOSE emp_cur;
     msg := '�������� ȣ�� ����';
     exception
       EXCEPTION
        WHEN NO_DATA_FOUND THEN
            NULL;
            when user_exception then
            msg:='�ش� �μ��� �������� �ʽ��ϴ�.';            
        WHEN OTHERS THEN 
        ROLLBACK;
        RAISE; --������ ���ܸ� ���� ��
  
    END;
