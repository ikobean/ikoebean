 ����1
 temp�� tcom�� �ڷ� �� emp_id, salary, comm��
 �����ִ� sql ���� �ۼ��Ͻÿ�.
 �� �� salary�� comm�� ��� �����ϴ� ����� �� �ٷ� ���;� ��
 

 SELECT EMP_ID,SALARY        
 FROM TEMP
 UNION
 SELECT EMP_ID,COMM
 FROM TCOM
 
 
 
 UNION - �ߺ����� - �� ������ ��ĵ�� ���� �Ѵ�!
                 -������ �Ͼ
 UNION ALL - �ߺ���� - ���� ����
 
 �÷��� ������ ��ġ�ؾ���.
 Ÿ�Ե� ���� �¾ƾ� ��.
 
 SELECT '�ȳ�' FROM dual
 UNION ALL
 SELECT  1 FROM dual
 
 ---------------------

 SELECT emp_id, salary, 0 comm FROM temp
 UNION 
 SELECT emp_id, 0 salary, comm FROM tcom
 
 --------0�̶� ''����
 ---Ÿ���� �ѹ��� 0, ���ڸ� ''
 
 ���� 2
 �츮 ȸ�翡 �ٹ��ϴ� ��� �߿��� �μ�Ƽ�긦 ���� �ʴ� ����� ���̵�� �̸��� ����ϴ� SQL���� �ۼ��Ͻÿ�.
 
 SELECT EMP_ID, EMP_NAME  --��ü����
 FROM TEMP
 MINUS
 SELECT EMP_ID, '' EMP_NAME    --�μ�Ƽ������
 FROM TCOM
 
 

 SELECT EMP_ID FROM TEMP
 MINUS
 SELECT EMP_ID FROM TCOM
