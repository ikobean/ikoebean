CREATE OR REPLACE PROCEDURE proc_empINSERT(empno in number,  ename in varchar2, job in  varchar2
                                            , mgr in number, hiredate in date, sal in number
                                            , comm in number, deptno in number, msg out  varchar2)
IS
BEGIN
     INSERT INTO emp(empno, ename, job, mgr,hiredate,sal,comm,deptno,msg)
     values(v_empno, v_ename, v_job, v_mgr, v_hiredate, v_sal, v_comm,v_dpteno, v_msg);
    msg :=  v_ename || '����� ������ ����Ͽ����ϴ�.';
     DBMS_OUTPUT.PUT_LINE(msg);
END;


���� insert ���� �ۼ��غ���.

2.1������ �ۼ��� ������ �����׽�Ʈ �غ���.

3. ���ν����� �����Ѵ�.

4. 2������ �׽�Ʈ�� ������ �ִ´�.

5.���ν����� ȣ���Ͽ� �����׽�Ʈ �Ѵ�.



INSERT INTO EMP(empno,ename, job, mgr
                ,hiredate,sal,comm,deptno)
           VALUES(7925,'������','KING',7598,'2017-09-21',9999,0,40);

           
           