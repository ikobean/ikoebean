SELECT *
FROM TDEPT a, TDEPT b
WHERE a.dept_code=b.parent_dept

��������1
tdept ���̺� �ڽ��� ���� �μ� ������ �����ϰ� �ִ�.
�� ���̺��� �̿��Ͽ� �μ��ڵ�, �μ���, �����μ��ڵ�, �����μ����� �о���� sql���� �ۼ��Ͻÿ�.

SELECT a.dept_code �μ��ڵ�, b.dept_name �μ���, a.parent_dept �����μ��ڵ�, a.dept_name �����μ���
from TDEPT a, TDEPT b
WHERE a.dept_code=b.parent_dept



��������2
temp�� tdept�� �̿��Ͽ� ���� �÷��� �����ִ� SQL���� �ۼ��Ͻÿ�.
1.���, 2.����, 3.�μ��ڵ�, 4.�μ���,
 5.�����μ��ڵ� 6.�����μ���,
  7.�����μ����ڵ�, 8.�����μ��强��
�����μ��� 'CA0001'

SELECT b.emp_id, b.emp_name, b.dept_code, a.dept_name
       ,a.parent_dept, a.dept_name
       ,c.boss_id,d.emp_name
from tdept a, temp b, tdept c, temp d
WHERE  
   
���ʿ� ���� �÷��� ��������
PK�� �ִ� ���̺��� �����;���. 
INDEX �Ǿ��ֱ� ������ ���̺� ��ĵ������ �ʾ� �ξ� ����
�׷��� �μ��ڵ�� �μ����� �������� �� ����

��(view)


SELECT A.emp_id, A.emp_name, B.dept_code, B.dept_name
  FROM temp A, tdept B
  WHERE A.dept_cdoe = B.dept_code
  
  
  SELECT A.emp_id, A.emp_name, B.dept_code, B.dept_name
        ,c.parent_dept, c.dept_name
        FROM temp A, tdept B, tdept C
        WHERE A.dept_cdoe = B.dept_code
        AND   B.parent_code = C.dept_code
        AND   C.DEPT_CODE= 'CA0001'
  
  
    SELECT A.emp_id, A.emp_name, B.dept_code, B.dept_name
        ,c.parent_dept, c.dept_name
        ,D.emp_id as "�����μ���id"
        ,D.emp_name as "�μ��强��"
        FROM temp A, tdept B, tdept C, temp D
        WHERE A.dept_code = B.dept_code
        AND   B.parent_dept = C.dept_code
        AND   C.DEPT_CODE= 'CA0001'
        AND   D.emp_id = C.boss_id
        
        
        ���
        ������ 4���̸� �������� 3��
        
        
        
    SELECT ȸ��.ȸ���� ,DVD.DVD�̸�           
        FROM ȸ�� A, �뿩 B, DVD C,
        WHERE ȸ��.ȸ�����̵�=�뿩.ȸ�����̵�
          AND �뿩.DVD�ڵ�=DVD.DVD�ڵ�
         
        
        
        
        
        
        
        