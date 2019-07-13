CREATE OR REPLACE PROCEDURE proc_empINSERT(empno in number,  ename in varchar2, job in  varchar2
                                            , mgr in number, hiredate in date, sal in number
                                            , comm in number, deptno in number, msg out  varchar2)
IS
BEGIN
     INSERT INTO emp(empno, ename, job, mgr,hiredate,sal,comm,deptno,msg)
     values(v_empno, v_ename, v_job, v_mgr, v_hiredate, v_sal, v_comm,v_dpteno, v_msg);
    msg :=  v_ename || '사원의 정보를 등록하였습니다.';
     DBMS_OUTPUT.PUT_LINE(msg);
END;


먼저 insert 문을 작성해본다.

2.1번에서 작성한 문장을 단위테스트 해본다.

3. 프로시저를 생성한다.

4. 2번에서 테스트한 문장을 넣는다.

5.프로시저를 호출하여 통합테스트 한다.



INSERT INTO EMP(empno,ename, job, mgr
                ,hiredate,sal,comm,deptno)
           VALUES(7925,'내복이','KING',7598,'2017-09-21',9999,0,40);

           
           