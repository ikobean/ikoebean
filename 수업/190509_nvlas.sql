
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
