SELECT deptno FROM emp

��Ƽ������ ���
1)��Ģ����� ��Ƽ������
2)������� ��Ƽ������

ALL_ROWS
������� ��Ƽ�������� ����Ʈ���
��� ���ǿ� �����ϴ� �����͸� ã�µ� ���� ȿ������ ���


SELECT /*+rule*/ empno, ename FROM emp

SELECT /*+all_rows*/ empno, ename FROM emp

����:��Ʈ���� ������ ���� ��쿡�� ���õȴ�.
    �������� �̷��� �䱸�� �ݵ�� �ݿ��Ǵ� ���� �ƴϴ�.
   

SELECT deptno FROM dept

CREATE OR REPLACE VIEW v_emp
AS
SELECT empno, ename, sal FROM emp

SELECT

��
view ���� �ִ� ���
sys���� ���ͼ� grant create view to ������ 
��

SELECT hiredate FROM v_emp  --�������� �ĺ���

�信 �������� ���� �÷��� ���Ұ�.

SELECT
        a.empno, b.deptno
   FROM emp a, dept b
   WHERE a.deptno = b.deptno

CREATE OR REPLACE VIEW v_emp2
AS
SELECT
        a.empno, b.deptno
   FROM emp a, dept b
   WHERE a.deptno = b.deptno
   
SELECT * FROM v_emp2

DROP VIEW v_emp2



   
