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
 
 SELECT COUNT (DECODE(LEC_TIME, LEC_POINT, '�Ϲݰ���'))
 FROM LECTURE
 
 SELECT COUNT( LEC_ID ) 
 FROM LECTURE
 WHERE LEC_TIME = LEC_POINT
 
 
3.���� �ð��� ������ ������ '�Ϲݰ���'�� ���Ϲ��� �� ���ĵ� �ϰ� ���� ���

SELECT LEC_ID �й�, DECODE (LEC_TIME,LEC_POINT,'�Ϲݰ���','Ư������') ���񱸺�
 FROM LECTURE
 ORDER BY �й� ASC
 
 SELECT LEC_ID �й�, DECODE (LEC_TIME,LEC_POINT,'�Ϲݰ���','Ư������') ���񱸺�
 FROM LECTURE
 ORDER BY DECODE (LEC_TIME,LEC_POINT,'�Ϲݰ���','Ư������') DESC, LEC_ID ASC;
 

 
 4.LEC_TIME�� ũ�� '�������', LEC_POINT�� ũ�� '��Ÿ����'
 ���� ������ '�Ϲݰ���'���� ���� �����ް��� �Ѵ�.
 
 SELECT SIGN(1-5), SIGN(-560), SIGN(5+19), SIGN(1000-1000) FROM dual
 
 SELECT lec_id, lec_time, lec_point
       ,decode(sign(lec_time-lec_point), 0 , '�Ϲݰ���'
                                       , 1 , '�������'
                                       , 2 , '��Ÿ����'
                                       ,'default')
                                       FROM lecture
                                       
                                       
                                      
       ��������
       �����Ͽ� �ش����ڿ� 01�� �ٿ��� 4�ڸ� ��ȣ�� �����
       ȭ���Ͽ� 11, �����Ͽ� 21, ����Ͽ� 31, �ݿ��Ͽ� 41, ����Ͽ� 51
       �Ͽ��Ͽ� 61�� �ٿ���4�ڸ� ��ȣ�� ����ٰ� �� ��
       ���ÿ� �ش��ϴ� ��� 4�ڸ��� ����ϴ� sql���� �ۼ��Ͻÿ�.
       
       SELECT 14||'11' 
       FROM dual
       
       SELECT TO_CHAR(sysdate,'day')
            DECODE( 'day','������', 01
                        ,'ȭ����', 11
                        ,'������', 21
                        ,'�����', 31
                        ,'�ݿ���', 41
                        ,'�����', 51)
                    FROM DUAL
                    
       SELECT TO_CHAR(sysdate,'DD') ||
               DECODE(TO_CHAR(sysdate,'day')
                        ,'������',01       
                        ,'ȭ����', 11
                        ,'������', 21
                        ,'�����', 31
                        ,'�ݿ���', 41
                        ,'�����', 51) �����ڵ�
                    FROM DUAL
                    
                    
                    SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD')as "���ó�¥"
                    ,TO_CHAR(sysdate, 'DD')||                    
                    DECODE(TO_CHAR(sysdate,'day'),'������','01'
                                  ,'ȭ����','11'
                                  ,'������','21'
                                  ,'�����','31'
                                  ,'�ݿ���','41'
                                  ,'�����','51'
                                  ,'�Ͽ���','61' ) AS ��й�ȣ
                                  FROM dual
                    
           
                              
                    
       
       
       
       
                    SELECT TO_CHAR(sysdate,'DD')
                    ,TO_CHAR(sysdate,'day')
                    ,TO_CHAR(sysdate,'yyyy')
                    ,TO_CHAR(sysdate,'mm')
                    ,TO_CHAR(sysdate,'mi')                                      
                    FROM dual
                    
                    
                 
            
      ��������2
      ������̺��� JOB�� CLERK�� ����� �޿� ��   
      JOB�� SALESMAN�� ����� �޿��� ���� ���ϰ�
      ������ JOB�� ���ؼ��� ��Ÿ ������ ���Ͻÿ�.
      
      
      -Ŭ���� �� - �������� �� - ��Ÿ��
      
   SELECT DECODE Ŭ���̴� ? �� - SUM
          �������? �� - SUM
          �Ѵ� �ƴϴ�? �� - SUM
          FROM EMP
          
          
          SELECT SUM (DECODE( JOB, 'CLERK', SAL)) AS Ŭ������
                ,SUM (DECODE( JOB, 'SALESMAN', SAL)) AS �����������
                ,SUM (DECODE (JOB, 'CLERK', 0
                                 , 'SALESMAN', 0                                                
                                 , SAL)) ���������
                                 FROM EMP
                                 
                                     
                                                                             FROM EMP
          
          
          SELECT SUM(DECODE(JOB, 'CLERK', SAL))
                 SUM(DECODE(JOB, 'SALESMAN', SAL)) 
                 FROM EMP
          
SELECT JOB
FROM EMP
