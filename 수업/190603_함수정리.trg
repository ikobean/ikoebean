오라클 함수

소수점 이후의 값이 존재하면 무조건 올림하는 함수
CEIL (n) n은 숫자값  

n을 m으로 나누었을 때 나머지 반환
MOD(n,m)

SELECT CEIL(13.11), CEIL(13.01), CEIL(13.67) FROM DUAL

SELECT MOD(13,3) FROM DUAL

주의사항
타입을 맞춘다.
파라미터 갯수를 맞춘다.

함수는 반드시 리턴값이 존재한다.

반올림

ROUND(n,m)
n=숫자
m=자리
2면 소수점 둘째자리까지 나오게

SELECT ROUND(345.34,-1), ROUND(345.67,1), ROUND(345.67567, 2) FROM dual 


SIGN 양수 음수 판단
SELECT SIGN(500), SIGN(40-40), SIGN(5-33) FROM DUAL


2의 10승은 1000보다 크다, 작다, 같다
POWER : 제곱승


SELECT DECODE(SIGN(POWER(2,10)-1000),1,'2의 10승이 1000보다 크다'
                                    ,-1,'2의 10승이 1000보다 작다'
                                    ,0,'1000과 같다.')  FROM DUAL
                                    
                                    
SELECT chr(65), ascii('A') FROM dual

문자열 처리 (공백을 채워주는 함수)

SELECT LPAD('kss',10,'#'), RPAD ('kss',10,'*') FROM DUAL

a자리에 bbb 넣어주기

SELECT REPLACE ('ORACLE','A','BBB') FROM dual

문자열 자르기 (문자열,자리수(여기부터~),몇개보여줘)

SELECT 
    SUBSTR('ORACLE PROJECT',1,3) str1 
   ,SUBSTR('오라클프로젝트',1,3) str2
   ,SUBSTRB('오라클 PROJECT',1,3) str3
        FROM dual
        
        SUBSTRB 일때는 BYTE로 계산해서 한글이 제대로 안나옴. 한글은 2BYTE 차지
        
가장 큰 값, 작은 값 찾아주는 함수 *한글도 적용 가능

SELECT GREATEST(10,55,39,87,67) "가장 큰 값" 
      ,LEAST(10,55,39,87,67) "가장 작은 값" FROM dual
      
      
SELECT TO_DATE('2019-05-10')
            ,'2019-06-10' FROM dual
            
            날짜 타입일 때 덧셈 뺄셈 가능
           

SELECT TO_DATE('2019-05-10') +1 FROM dual
         --이건 문자 타입이라서 안됨   ,'2019-06-10' +1 
실제 테이블에는 varchar2로 설계한다.
 

SELECT TO_DATE('2019-05-10') +1 날짜
            ,add_months(TO_dATE('2019-05-10'),1) "달 더하기"
            ,last_Day(to_date('2019-07-10')) "마지막 날짜 출력"
            FROM DUAL
 

temp의 자료를  salary로 분류해서 30,000,000 이하는 'D등급'
3천 초과 5천 이하는 'C등급'
5천 초과 7천 이하는 'B등급'
7천 초과는 'A등급' 라고 등급별로 분류하여 인원수를 알고싶다. 어떡하지?




GROUP BY ( CASE WHEN SALARY<30000000 THEN 'D등급')
                


SELECT COUNT(*) 인원수,
    CASE WHEN SALARY<=30000000 THEN 'D등급'
         WHEN SALARY BETWEEN 50000001 AND 70000000 THEN 'B등급'
         WHEN SALARY BETWEEN 30000001 AND 50000000 THEN 'C등급'
         WHEN SALARY >70000000 THEN 'A등급'
    END as "등급"
    FROM TEMP
        GROUP BY   CASE WHEN SALARY<=30000000 THEN 'D등급'
                        WHEN SALARY BETWEEN 50000001 AND 70000000 THEN 'B등급'
                        WHEN SALARY BETWEEN 30000001 AND 50000000 THEN 'C등급'
                        WHEN SALARY >70000000 THEN 'A등급'
                        END 
        ORDER BY   CASE WHEN SALARY<=30000000 THEN 'D등급'
                        WHEN SALARY BETWEEN 50000001 AND 70000000 THEN 'B등급'
                        WHEN SALARY BETWEEN 30000001 AND 50000000 THEN 'C등급'
                        WHEN SALARY >70000000 THEN 'A등급'
                        END 



SELECT SALARY,EMP_NAME
WHERE TEMP.SALARY =300000000        
FROM TEMP 
 
                        
      
  SELECT DECODE(SIGN(POWER(2,10)-1000),1,'2의 10승이 1000보다 크다'
                                    ,-1,'2의 10승이 1000보다 작다'
                                    ,0,'1000과 같다.')  FROM DUAL      

    
            
            
      