SELECT empno, ename as "�̸�"
FROM emp
WHERE �̸� = 'SMITH'

SELECT empno, ename "�̸�"
FROM emp
WHERE �̸� = 'SMITH'

��������
�÷��� ��Ī�� �ο����� ��� WHERE ������ ��Ī�� ����� �� ����.

�ذ���
�ζ��κ並 ����ϸ� ������.

���� ��: FROM �� �Ʒ� SELECT ���� �� ��� - �ζ��κ�
--WHERE �� �ؿ� SELECT - ��������

SELECT
  FROM (
             SELECT ��      --�ζ��κ�(View�� ����) ����ǿ��� ���� ��
                           --���̺��� �ƴϰ� select��
                           --select���� ���� �÷����� ���̺��� �Ǵ� ��
        )
        
        
SELECT empno, ename �̸�
FROM emp, (SELECT ename FROM EMP)
WHERE '�̸�' = 'SMITH'

SELECT EMPNO ���, "�̸�"
 FROM(
      SELECT empno, ename "�̸�"
      FROM emp
      )
 WHERE �̸� = 'SMITH'
 
SELECT ENAME, "�μ���ȣ"
FROM
    (SELECT ENAME, DEPTNO "�μ���ȣ"
    FROM EMP)
    WHERE �μ���ȣ = 30
    
SELECT ename FROM emp

SELECT  deptno �ι�, count(*) ���
FROM emp 
GROUP BY deptno

SELECT  "�ι�" , count(*) ���
FROM (SELECT DEPTNO "�ι�" FROM EMP)
GROUP BY "�ι�"

Ȯ���� ����
���� �����Ͱ� ������ group by�� ȿ���� ����.
���ĵ� ������ �ٸ���. �����ϴ�.

SELECT hiredate FROM emp GROUP BY hiredate

SELECT deptno, max(ename), min(ename),count(*) FROM emp GROUP BY deptno

SELECT  deptno FROM emp 
GROUP BY deptno
HAVING DEPTNO = 10

SELECT  deptno FROM emp 
GROUP BY deptno
WHERE DEPTNO = 10 �ȵ� �ȵ� �ȵ� �ȵ�

