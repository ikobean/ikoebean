SELECT ENAME, DNAME FROM EMP, DEPT
WHERE EMP.DEPTNO=DEPT.DEPTNO
AND EMP.ENAME='SMITH'

DELETE FROM EMP WHERE ENAME = 'SMITH'

DELETE FROM DEPT WHERE DEPTNO = 20

ROLLBACK;
COMMIT;

SELECT EMPNO FROM EMP   --��Ƽ������

SELECT ENAME FROM EMP   --��ü�� �� �о���~


INSERT INTO BANK (NAME, CARDNO, HP)
 VALUES('������', 1234, '0103218')

SELECT DEPT.DEPTNO, NAME FROM DEPT, BANK
WHERE DEPT.DEPTNO = BANK.DEPTNO


�츮ȸ�翡 �ٹ��ϴ� ����߿��� �޿��� 2500�� �̻��� ����� �̸��� �޿�����
����ϴ� SQL���� �ۼ��Ͻÿ�.

�������� �м�
�����̸� ����? ������� - EMP
� ������ ��������ϴ°Ŵ�? �̸��� �޿�,  ENAME , SAL
����� � ������ �����ָ� �ɱ�?
���ϴ� ������ �ִ°Ŵ�? 

WHERE sal >=2000

SELECT ENAME, SAL
 FROM EMP
 WHERE SAL >=2500



SELECT ENAME,SAL FROM EMP WHERE SAL >=2500 


DROP TABLE BANK

����2
�츮 ȸ�翡 �ٹ��ϴ� ����� �߿��� �μ���ȣ�� 20 Ȥ�� 30�� �μ��� �ٹ��ϴ� �������
�����, �μ���ȣ, SAL�� ����ϴ� SQL ���� �ۼ��Ͻÿ�.

WHERE DEPTNO IN(20,30)

SELECT ENAME, DEPTNO, SAL 
FROM EMP 
WHERE DEPTNO IN(20, 30);


SELECT ENAME, DEPTNO, SAL 
FROM EMP 
WHERE DEPTNO = 20 
OR DEPTNO= 30


�츮ȸ�翡 �ٹ��ϴ� ����� �߿��� �μ�Ƽ�긦 �޴� ������� �̸�, �μ�Ƽ�� �ݾ��� ����ϴ� SQL���� �ۼ��Ͻÿ�.


SELECT 1+2, 2+NULL FROM dual

dual : �÷��ϳ��� �ο��ϳ�¥�� ���� ���̺�


SELECT sysdate FROM dual


SELECT SYSDATE, TO_CHAR(sysdate,'YYYY')
,TO_CHAR(sysdate, 'day')
FROM dual


SELECT ENAME, COMM FROM EMP 
WHERE COMM IS NOT NULL;

SELECT ENAME, COMM FROM EMP
WHERE COMM > 0



SELECT ENAME, COMM FROM EMP  --14��

NULL�� ���� �����Ѵ�.

SELECT ENAME, COMM FROM EMP 
WHERE COMM IS NOT NULL
AND COMM !=0





SELECT 1+2, 3*5, 5/10, sysdate+1 FROM DUAL

SELECT �� FROM�� ���̿� �÷��� �´�
SELECT �� FROM�� ���̿� ��Ģ������ �����ϴ�.
SELECT �� FROM�� ���̿� �Լ��� ����� �� �ִ�.
SELECT �� FROM�� ���̿� �÷��� �߰��ϸ� ���̺��� �������� �þ��.
���̺��� �Ʒ����� ���Ϸ��� INSERT



SELECT 1,2,3,4,5,6,7,'�ȳ�' FROM dual;



SELECT EMPNO, ENAME, JOB, SAL, COMM,HIREDATE, DEPTNO, MGR FROM EMP







SELECT ENAME, COMM FROM EMP
MINUS
SELECT ENAME, COMM FROM EMP 
WHERE COMM=0
MINUS
SELECT ENAME, COMM FROM EMP
WHERE COMM IS NULL; 

INSERT INTO BANK (NAME) VALUES ('������');