
--34p
SELECT sal*12 as 연봉  --연산가
      ,sal*12 연봉
      ,sal*12 as " 연  봉"
 FROM emp;
 
 
--35p
SELECT sal, NVL(comm,0), --NVL(comm, '없음'오라클에서 문자 '싱글 쿼테이션' 기억하기.타입이 안맞아서 안됨
                         --comm은 number인데어떻게왜 0이 들어갔지?
  FROM  emp;
  
  
--p38
