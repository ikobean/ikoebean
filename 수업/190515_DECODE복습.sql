SELECT EMPNO ���, ENAME �̸�, JOB ����
      ,DECODE ( JOB , 'MANAGER', SAL) �Ŵ���
      ,DECODE ( JOB, 'SALESMAN', SAL) �������
      ,DECODE ( JOB, 'MANAGER', NULL
                   , 'SALESMAN',NULL
                                ,SAL) ������ --JOB�� �������� SAL�� ���
       FROM EMP
 
IF JOB= 'SALESMAN' THEN
  return sal;
ELSIF JOB= 'MANAGER' THEN
  return sal;
ELSI
 sal;
 
END IF;

DECODE (job, 'SALESMAN', sal)

DECODE (job, 'MANAGER', sal)

SELECT 1,2,3 FROM DUAL

SELECT EMPNO ���, ENAME �̸�, JOB ����
      ,DECODE ( JOB , 'MANAGER', SAL, null) �Ŵ���
      ,DECODE ( JOB, 'SALESMAN', SAL) �������
      ,DECODE ( JOB, 'MANAGER', NULL
                   , 'SALESMAN',NULL
                                ,SAL) ������ --��������̴�? ��! null~
       FROM EMP

