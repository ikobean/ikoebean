
INSERT INTO EMP(empno,ename, job, mgr
                ,hiredate,sal,comm,deptno)
           VALUES(7925,'내복이','KING',7598,'2017-09-21',9999,0,40);



CREATE OR REPLACE PROCEDURE proc_empINSERT
(p_empno in number,  p_ename in varchar2, p_job in  varchar2
  , p_mgr in number, p_hiredate in date, p_sal in number
, p_comm in number, p_deptno in number
, msg out  varchar2)
IS
BEGIN
INSERT INTO EMP(empno,ename, job, mgr
                ,hiredate,sal,comm,deptno)
           VALUES(p_empno,p_ename,p_job,p_mgr,p_hiredate,p_sal,p_comm,p_deptno);
           msg:= p_ename||'사원의 정보를 등록하였습니다.';
           commit;
END;


(7925,'내복이','KING',7598,'2017-09-21',9999,0,40);


drop procedure proc_empINSERT;