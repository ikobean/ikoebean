연습문제1  - select ... into
          if문
          하나로 프로시저 안에서 두 개 이상의 DML 구문 처리
사원번호를 입력 받아서 그 사원이 속한 부서의 급여평균을 구하고
그 평균보다 많이 받는 사원이면 10%인상을
적게 받는 사원이면 20%인상을 하여 급여테이블에 수정처리하는
프로시저를 작성하시오.


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


----------------선생님풀이---------------------
응답메시지
누구사원의 급여가 몇프로의 인상으로 얼마가 되었습니다.

수집해야할 정보 - 누가?, 급여?, 몇프로?

변수선언 3개 v_ename, n_sal, n_rate 

SELECT ename, sal INTO v_ename, n_sal FROM emp
WHERE empno=p_empno;

평균급여 - 변수선언 n_avgsal

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
       
       
이름:proc_empnoUpdate -단일행처리
