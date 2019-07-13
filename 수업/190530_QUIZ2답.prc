
연습문제2 - cursor,update 사용
부서번호를 입력 받아서 부서급여 평균을 구하고 
그 부서에 근무하는 사원들의 급여를 
많게 받으면 10% 인상
적게 받음ㄴ 20% 인상
급여테이블에 수정처리하는 프로시저를 작성하시오.


CREATE OR REPLACE PROCEDURE proc_deptnoUpdate(p_deptno IN number, msg OUT varchar2)
IS  
    v_avgsal number(7,2); --평균급여 담기
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
     msg := '에러없이 호출 성공';
     exception
       EXCEPTION
        WHEN NO_DATA_FOUND THEN
            NULL;
            when user_exception then
            msg:='해당 부서는 존재하지 않습니다.';            
        WHEN OTHERS THEN 
        ROLLBACK;
        RAISE; --강제로 예외를 던질 때
  
    END;
