DECODE ('A','B'
       ,DECODE('A','C','T','X')
       ,'F')
       
       
SELECT DECODE (1,1,'T','F')
   FROM dual
   
   DECODE�� ���� �͸� ���� �� �ִ�. 
   ũ�� �۴ٴ� ���� �� ����.
   
   �����-�����>0
   
   �ռ���-�ڼ���<0
   
SELECT DECODE (1,1,DECODE(1,3,'T','X'),'F') FROM dual

1. �ִ� ���ǽð��� ������ ������ '�Ϲݰ���'�� ����ϰ��� �Ѵ�.
�����?

SELECT DECODE (LEC_TIME,LEC_POINT,'�Ϲݰ���','Ư������') ���񱸺�
 FROM LECTURE

2.�ִ� ���ǽð��� ������ ���� ������ ���ڸ� �˰� �ʹ�.
�ݵ�� ���ڵ带 ����Ͻÿ�.

�ִ� ���ǽð� = ���� 


SELECT DECODE(LEC_TIME, LEC_POINT,'����','�ٸ���') ���  ,COUNT(*) ����
 FROM LECTURE   
 GROUP BY DECODE(LEC_TIME, LEC_POINT,'����','�ٸ���')
 HAVING DECODE(LEC_TIME, LEC_POINT,'����','�ٸ���') = '����'
 
 
3.���� �ð��� ������ ������ '�Ϲݰ���'�� ���Ϲ��� �� ���ĵ� �ϰ� ���� ���

SELECT LEC_ID �й�, DECODE (LEC_TIME,LEC_POINT,'�Ϲݰ���','Ư������') ���񱸺�
 FROM LECTURE
  ORDER BY �й� ASC

 
 4.LEC_TIME�� ũ�� '�������', LEC_POINT�� ũ�� '��Ÿ����'
 ���� ������ '�Ϲݰ���'���� ���� �����ް��� �Ѵ�.
 
 SELECT LEC_TIME - LEC_POINT AS "�� ��" 
 FROM LECTURE
 DECODE (LEC_TIME - LEC_POINT, LEC_TIME - LEC_POINT,'�Ϲݰ���', 'A')
 
 SELECT LEC_TIME TIM, LEC_POINT POI
 FROM LECTURE
 
 SELECT 
 DECODE(LEC_TIME,LEC_POINT,'�Ϲݰ���','�Τ�')
 FROM LECTURE
 OR
 SELECT  LEC_TIME A, LEC_POINT B
 WHERE A > B 
 FROM LECTURE 
 
 
 
 
