��������1  - select ... into
          if��
          �ϳ��� ���ν��� �ȿ��� �� �� �̻��� DML ���� ó��
�����ȣ�� �Է� �޾Ƽ� �� ����� ���� �μ��� �޿������ ���ϰ�
�� ��պ��� ���� �޴� ����̸� 10%�λ���
���� �޴� ����̸� 20%�λ��� �Ͽ� �޿����̺� ����ó���ϴ�
���ν����� �ۼ��Ͻÿ�.


CREATE OR REPLACE PROCEDURE proc_empnoUpdate(p_name IN varchar2, p_sal IN number,p_empno IN number)
IS
v_ename EMP.ename%type;
v_sal   emp.sal%type;
v_empno emp.empno%type;
BEGIN
    SELECT empno, avg(sal) into v_avg
    FROM emp 
    group by empno ;
    
    if(v_avg.sal > sal) then
       (sal*0.1)+sal := sal;
    elsif(v_avh.sal<=sal) then
       (sal*0.2)+sal := sal;
       end if;
       dbms_output.put_line(emp.sal);
END;


----------------������Ǯ��---------------------
����޽���
��������� �޿��� �������� �λ����� �󸶰� �Ǿ����ϴ�.

�����ؾ��� ���� - ����?, �޿�?, ������?

�������� 3�� v_ename, n_sal, n_rate 

SELECT ename, sal INTO v_ename, n_sal FROM emp
WHERE empno=p_empno;

��ձ޿� - �������� n_avgsal

SELECT avg(sal) INTO n_avgsal FROM emp
WHERE deptno = (SELECT deptno FROM emp
                WHERE empno = p_empno);
                
IF n_sal > n_avgsal THEN
   n_rate := 1.1;
ELSE
   n_rate := 1.2;
END IF;
                
 
-----------------------------------------------------------

CREATE OR REPLACE PROCEDURE proc_empnoUpdate(p_name IN varchar2, p_sal IN number)
IS
v_ename EMP.ENAME%TYPE;
n_sal EMP.SAL%TYPE;
BEGIN
        SELECT ename, sal INTO v_ename, n_sal FROM emp
        WHERE empno=p_empno;
        
        IF n_sal > n_avgsal THEN
            n_rate := 1.1;
        ELSE
            n_rate := 1.2;
        END IF;
END;
       
       
�̸�:proc_empnoUpdate -������ó��
