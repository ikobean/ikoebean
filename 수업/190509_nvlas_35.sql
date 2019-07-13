
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
SELECT DEPTNO FROM dept
MINUS 
SELECT DEPTNO FROM emp    --SELECT 쓰는 거 까먹지 마

SELECT DEPTNO FROM dept
INTERSECT                 --교집합
SELECT DEPTNO FROM emp
ORDER BY DEPTNO DESC    --SELECT 쓰는 거 까먹지 마

SELECT DISTINCT DEPTNO
FROM EMP

