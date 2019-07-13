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
 
 SELECT COUNT (DECODE(LEC_TIME, LEC_POINT, '일반과목'))
 FROM LECTURE
 
 SELECT COUNT( LEC_ID ) 
 FROM LECTURE
 WHERE LEC_TIME = LEC_POINT
 
 
3.강의 시간과 학점이 같으면 '일반과목'을 리턴받은 후 정렬도 하고 싶은 경우

SELECT LEC_ID 학번, DECODE (LEC_TIME,LEC_POINT,'일반과목','특수과목') 과목구분
 FROM LECTURE
 ORDER BY 학번 ASC
 
 SELECT LEC_ID 학번, DECODE (LEC_TIME,LEC_POINT,'일반과목','특수과목') 과목구분
 FROM LECTURE
 ORDER BY DECODE (LEC_TIME,LEC_POINT,'일반과목','특수과목') DESC, LEC_ID ASC;
 

 
 4.LEC_TIME이 크면 '실험과목', LEC_POINT가 크면 '기타과목'
 둘이 같으면 '일반과목'으로 값을 돌려받고자 한다.
 
 SELECT SIGN(1-5), SIGN(-560), SIGN(5+19), SIGN(1000-1000) FROM dual
 
 SELECT lec_id, lec_time, lec_point
       ,decode(sign(lec_time-lec_point), 0 , '일반과목'
                                       , 1 , '실험과목'
                                       , 2 , '기타과목'
                                       ,'default')
                                       FROM lecture
                                       
                                       
                                      
       실전문제
       월요일엔 해당일자에 01을 붙여서 4자리 암호를 만들고
       화요일엔 11, 수요일엔 21, 목요일엔 31, 금요일엔 41, 토요일엔 51
       일요일엔 61을 붙여서4자리 암호를 만든다고 할 때
       오늘에 해당하는 비번 4자리를 출력하는 sql문을 작성하시오.
       
       SELECT 14||'11' 
       FROM dual
       
       SELECT TO_CHAR(sysdate,'day')
            DECODE( 'day','월요일', 01
                        ,'화요일', 11
                        ,'수요일', 21
                        ,'목요일', 31
                        ,'금요일', 41
                        ,'토요일', 51)
                    FROM DUAL
                    
       SELECT TO_CHAR(sysdate,'DD') ||
               DECODE(TO_CHAR(sysdate,'day')
                        ,'월요일',01       
                        ,'화요일', 11
                        ,'수요일', 21
                        ,'목요일', 31
                        ,'금요일', 41
                        ,'토요일', 51) 요일코드
                    FROM DUAL
                    
                    
                    SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD')as "오늘날짜"
                    ,TO_CHAR(sysdate, 'DD')||                    
                    DECODE(TO_CHAR(sysdate,'day'),'월요일','01'
                                  ,'화요일','11'
                                  ,'수요일','21'
                                  ,'목요일','31'
                                  ,'금요일','41'
                                  ,'토요일','51'
                                  ,'일요일','61' ) AS 비밀번호
                                  FROM dual
                    
           
                              
                    
       
       
       
       
                    SELECT TO_CHAR(sysdate,'DD')
                    ,TO_CHAR(sysdate,'day')
                    ,TO_CHAR(sysdate,'yyyy')
                    ,TO_CHAR(sysdate,'mm')
                    ,TO_CHAR(sysdate,'mi')                                      
                    FROM dual
                    
                    
                 
            
      실전문제2
      사원테이블에서 JOB이 CLERK인 사람의 급여 합   
      JOB이 SALESMAN인 사람의 급여의 합을 구하고
      나머지 JOB에 대해서는 기타 합으로 구하시오.
      
      
      -클럭의 합 - 세일즈의 합 - 기타합
      
   SELECT DECODE 클럭이니 ? 네 - SUM
          세일즈니? 네 - SUM
          둘다 아니니? 네 - SUM
          FROM EMP
          
          
          SELECT SUM (DECODE( JOB, 'CLERK', SAL)) AS 클럭의합
                ,SUM (DECODE( JOB, 'SALESMAN', SAL)) AS 세일즈맨의합
                ,SUM (DECODE (JOB, 'CLERK', 0
                                 , 'SALESMAN', 0                                                
                                 , SAL)) 나머지계산
                                 FROM EMP
                                 
                                     
                                                                             FROM EMP
          
          
          SELECT SUM(DECODE(JOB, 'CLERK', SAL))
                 SUM(DECODE(JOB, 'SALESMAN', SAL)) 
                 FROM EMP
          
SELECT JOB
FROM EMP
