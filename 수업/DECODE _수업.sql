DECODE ('A','B'
       ,DECODE('A','C','T','X')
       ,'F')
       
       
SELECT DECODE (1,1,'T','F')
   FROM dual
   
   DECODE는 같은 것만 비교할 수 있다. 
   크다 작다는 비교할 수 없음.
   
   어떤숫자-어떤숫자>0
   
   앞숫자-뒤숫자<0
   
SELECT DECODE (1,1,DECODE(1,3,'T','X'),'F') FROM dual

1. 주당 강의시간과 학점이 같으면 '일반과목'을 출력하고자 한다.
어떡하지?

SELECT DECODE (LEC_TIME,LEC_POINT,'일반과목','특수과목') 과목구분
 FROM LECTURE

2.주당 강의시간과 학점이 같은 강의의 숫자를 알고 싶다.
반드시 디코드를 사용하시오.

주당 강의시간 = 학점 


SELECT DECODE(LEC_TIME, LEC_POINT,'같다','다르다') 결과  ,COUNT(*) 숫자
 FROM LECTURE   
 GROUP BY DECODE(LEC_TIME, LEC_POINT,'같다','다르다')
 HAVING DECODE(LEC_TIME, LEC_POINT,'같다','다르다') = '같다'
 
 
3.강의 시간과 학점이 같으면 '일반과목'을 리턴받은 후 정렬도 하고 싶은 경우

SELECT LEC_ID 학번, DECODE (LEC_TIME,LEC_POINT,'일반과목','특수과목') 과목구분
 FROM LECTURE
  ORDER BY 학번 ASC

 
 4.LEC_TIME이 크면 '실험과목', LEC_POINT가 크면 '기타과목'
 둘이 같으면 '일반과목'으로 값을 돌려받고자 한다.
 
 SELECT LEC_TIME - LEC_POINT AS "뺀 값" 
 FROM LECTURE
 DECODE (LEC_TIME - LEC_POINT, LEC_TIME - LEC_POINT,'일반과목', 'A')
 
 SELECT LEC_TIME TIM, LEC_POINT POI
 FROM LECTURE
 
 SELECT 
 DECODE(LEC_TIME,LEC_POINT,'일반과목','로ㅏ')
 FROM LECTURE
 OR
 SELECT  LEC_TIME A, LEC_POINT B
 WHERE A > B 
 FROM LECTURE 
 
 
 
 
