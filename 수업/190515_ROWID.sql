rowid

SELECT rowid rid FROM EMP

6�ڸ� : �����Ϳ� ���� ������Ʈ ��ȣ
3�ڸ� : ����� ���Ϲ�ȣ
3�ڸ� : ��Ϲ�ȣ
3�ڸ� : ��� ���� ���ȣ

SELECT ENAME, HIREDATE 
 FROM EMP
 WHERE ROWID = 'AAARE8AAEAAAACTAAA'
 
 ROWID:DBMS�� ������ �ִ� ��� �������� ������ ������ �ĺ���
 
 �� ROWID�� index�͵� ������ �ִµ� index ���̺��� index key��
 rowid�� �̷�����ֱ� �����̴�.
 �̷��� ��������� ������ �ִ� rowid�� ��ġ �������� ������� ������ �� ������
 �����δ� �������� ������ index ���̺� ���� �ִ� rowid�� �ش絥���͸� ã�� ���� 
 �ϳ��� ������ ������ ���̴�.
 
 
