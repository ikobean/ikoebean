SELECT rownum ����  FROM emp

SELECT rownum rno, ename FROM emp
 WHERE deptno = 20
 
SELECT rownum rno, ename FROM emp
WHEERE deptno = 20
AND rno :<3
--�ȵ� ���̺� ���� �÷��̶�

�ζ��κ並 ����ϸ� ���̺� ���� �÷��� �������� ����� �� �ִ�.
�ζ��κ�� ����Ʈ���̴�. ������ ������ ������ ������ �ζ��κ� ������

SELECT RNO, ENAME
 FROM (SELECT rownum rno, ename FROM emp
       WHERE deptno = 20)
 WHERE RNO <3
 
 WHERE���� ���� SELECT �� ��������
 
