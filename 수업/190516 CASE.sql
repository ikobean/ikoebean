temp ���̺��� ���� ������ �ִµ�
8000 �̻� 1������� a���
6000 �̻� 8000�̸� b���
4000 �̻� 6000�̸��� c���
�����ȣ ����� �޿� ���

SELECT EMP_ID ���, EMP_NAME �̸�,SALARY ����
    ,CASE WHEN  SALARY BETWEEN 80000000 AND 100000000  THEN 'A'
          WHEN  SALARY BETWEEN 60000000 AND 800000000-1  THEN 'B'
          WHEN  SALARY BETWEEN 40000000 AND 600000000-1  THEN 'C'
          ELSE 'D'
     END AS ���
     FROM TEMP

    


SELECT COUNT(���) �ο�, ���
FROM(SELECT EMP_ID ���, EMP_NAME �̸�,SALARY ����
    ,CASE WHEN  SALARY BETWEEN 80000000 AND 100000000  THEN 'A'
          WHEN  SALARY BETWEEN 60000000 AND 800000000-1  THEN 'B'
          WHEN  SALARY BETWEEN 40000000 AND 600000000-1  THEN 'C'
          ELSE 'D'
     END AS ���
     FROM TEMP)
     GROUP BY ���
     ORDER BY ���
     
    
SELECT count(���) �ο�, ���
FROM(
     SELECT EMP_ID ���, EMP_NAME �̸�,SALARY ����
    ,CASE WHEN  SALARY BETWEEN 80000000 AND 100000000  THEN 'A'
          WHEN  SALARY BETWEEN 60000000 AND 800000000-1  THEN 'B'
          WHEN  SALARY BETWEEN 40000000 AND 600000000-1  THEN 'C'
          ELSE 'D'
     END AS ���
     FROM TEMP
     )i_temp
     GROUP BY i_temp.���
     ORDER BY ���
     

    �н���ǥ
    �ζ��κ�� ��ȿ��� ����� �÷��� ������������ ����� �� �ִ�.
    �׷��Լ��� ����� ��� �Լ��� ������� �ʴ� �ٸ� �÷��� ����� �� ����.
    �����ذ���
    group by ����ϸ� ����� �� �ִ�.
    
    ���ǻ���
    group by�� ����ϴ� �÷��� �߸������ϸ� ȿ���� ���� �� �� ����.
    �׷��Լ��� ���� �÷� ����� group by ���� ����� ��츸 �����ϴ�.
    
    ex)
    
    select deptno, count(empno) FROM emp
    GROUP BY deptno
    
    
    