
--34p
SELECT sal*12 as ����  --���갡
      ,sal*12 ����
      ,sal*12 as " ��  ��"
 FROM emp;
 
 
--35p
SELECT sal, NVL(comm,0), --NVL(comm, '����'����Ŭ���� ���� '�̱� �����̼�' ����ϱ�.Ÿ���� �ȸ¾Ƽ� �ȵ�
                         --comm�� number�ε���Կ� 0�� ����?
  FROM  emp;
  
  
--p38
SELECT DEPTNO FROM dept
MINUS 
SELECT DEPTNO FROM emp    --SELECT ���� �� ����� ��

SELECT DEPTNO FROM dept
INTERSECT                 --������
SELECT DEPTNO FROM emp
ORDER BY DEPTNO DESC    --SELECT ���� �� ����� ��

SELECT DISTINCT DEPTNO
FROM EMP

