����Ŭ �Լ�

�Ҽ��� ������ ���� �����ϸ� ������ �ø��ϴ� �Լ�
CEIL (n) n�� ���ڰ�  

n�� m���� �������� �� ������ ��ȯ
MOD(n,m)

SELECT CEIL(13.11), CEIL(13.01), CEIL(13.67) FROM DUAL

SELECT MOD(13,3) FROM DUAL

���ǻ���
Ÿ���� �����.
�Ķ���� ������ �����.

�Լ��� �ݵ�� ���ϰ��� �����Ѵ�.

�ݿø�

ROUND(n,m)
n=����
m=�ڸ�
2�� �Ҽ��� ��°�ڸ����� ������

SELECT ROUND(345.34,-1), ROUND(345.67,1), ROUND(345.67567, 2) FROM dual 


SIGN ��� ���� �Ǵ�
SELECT SIGN(500), SIGN(40-40), SIGN(5-33) FROM DUAL


2�� 10���� 1000���� ũ��, �۴�, ����
POWER : ������


SELECT DECODE(SIGN(POWER(2,10)-1000),1,'2�� 10���� 1000���� ũ��'
                                    ,-1,'2�� 10���� 1000���� �۴�'
                                    ,0,'1000�� ����.')  FROM DUAL
                                    
                                    
SELECT chr(65), ascii('A') FROM dual

���ڿ� ó�� (������ ä���ִ� �Լ�)

SELECT LPAD('kss',10,'#'), RPAD ('kss',10,'*') FROM DUAL

a�ڸ��� bbb �־��ֱ�

SELECT REPLACE ('ORACLE','A','BBB') FROM dual

���ڿ� �ڸ��� (���ڿ�,�ڸ���(�������~),�������)

SELECT 
    SUBSTR('ORACLE PROJECT',1,3) str1 
   ,SUBSTR('����Ŭ������Ʈ',1,3) str2
   ,SUBSTRB('����Ŭ PROJECT',1,3) str3
        FROM dual
        
        SUBSTRB �϶��� BYTE�� ����ؼ� �ѱ��� ����� �ȳ���. �ѱ��� 2BYTE ����
        
���� ū ��, ���� �� ã���ִ� �Լ� *�ѱ۵� ���� ����

SELECT GREATEST(10,55,39,87,67) "���� ū ��" 
      ,LEAST(10,55,39,87,67) "���� ���� ��" FROM dual
      
      
SELECT TO_DATE('2019-05-10')
            ,'2019-06-10' FROM dual
            
            ��¥ Ÿ���� �� ���� ���� ����
           

SELECT TO_DATE('2019-05-10') +1 FROM dual
         --�̰� ���� Ÿ���̶� �ȵ�   ,'2019-06-10' +1 
���� ���̺��� varchar2�� �����Ѵ�.
 

SELECT TO_DATE('2019-05-10') +1 ��¥
            ,add_months(TO_dATE('2019-05-10'),1) "�� ���ϱ�"
            ,last_Day(to_date('2019-07-10')) "������ ��¥ ���"
            FROM DUAL
 

temp�� �ڷḦ  salary�� �з��ؼ� 30,000,000 ���ϴ� 'D���'
3õ �ʰ� 5õ ���ϴ� 'C���'
5õ �ʰ� 7õ ���ϴ� 'B���'
7õ �ʰ��� 'A���' ��� ��޺��� �з��Ͽ� �ο����� �˰�ʹ�. �����?




GROUP BY ( CASE WHEN SALARY<30000000 THEN 'D���')
                


SELECT COUNT(*) �ο���,
    CASE WHEN SALARY<=30000000 THEN 'D���'
         WHEN SALARY BETWEEN 50000001 AND 70000000 THEN 'B���'
         WHEN SALARY BETWEEN 30000001 AND 50000000 THEN 'C���'
         WHEN SALARY >70000000 THEN 'A���'
    END as "���"
    FROM TEMP
        GROUP BY   CASE WHEN SALARY<=30000000 THEN 'D���'
                        WHEN SALARY BETWEEN 50000001 AND 70000000 THEN 'B���'
                        WHEN SALARY BETWEEN 30000001 AND 50000000 THEN 'C���'
                        WHEN SALARY >70000000 THEN 'A���'
                        END 
        ORDER BY   CASE WHEN SALARY<=30000000 THEN 'D���'
                        WHEN SALARY BETWEEN 50000001 AND 70000000 THEN 'B���'
                        WHEN SALARY BETWEEN 30000001 AND 50000000 THEN 'C���'
                        WHEN SALARY >70000000 THEN 'A���'
                        END 



SELECT SALARY,EMP_NAME
WHERE TEMP.SALARY =300000000        
FROM TEMP 
 
                        
      
  SELECT DECODE(SIGN(POWER(2,10)-1000),1,'2�� 10���� 1000���� ũ��'
                                    ,-1,'2�� 10���� 1000���� �۴�'
                                    ,0,'1000�� ����.')  FROM DUAL      

    
            
            
      