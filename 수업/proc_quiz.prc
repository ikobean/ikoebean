EXEC proc_gugudan(1, 3);

�������� 1 - INSERT�� ȸ������, �ֹ����, �������

���ν����� - proc_empINSERT(8����)
��¸޼��� - XXX����� ������ ����Ͽ����ϴ�.

Ŀ��ó���� ����. (������Ʈ)


CREATE OR REPLACE PROCEDURE proc_empINSERT(empno in number,  ename in varchar2, job in  varchar2
                                            , mgr in number, hiredate in date, sal in number
                                            , comm in number, deptno in number, msg out  varchar2))
IS
BEGIN
     INSERT INTO emp
     values(12345,'������','KING',56789,'20190921',9999,5678,1234)
    msg:=  '����� ������ ����Ͽ����ϴ�.';
END;
