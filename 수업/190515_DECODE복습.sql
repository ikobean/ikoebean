SELECT EMPNO 사번, ENAME 이름, JOB 직업
      ,DECODE ( JOB , 'MANAGER', SAL) 매니저
      ,DECODE ( JOB, 'SALESMAN', SAL) 세일즈맨
      ,DECODE ( JOB, 'MANAGER', NULL
                   , 'SALESMAN',NULL
                                ,SAL) 나머지 --JOB이 나머지면 SAL을 줘라
       FROM EMP
 
IF JOB= 'SALESMAN' THEN
  return sal;
ELSIF JOB= 'MANAGER' THEN
  return sal;
ELSI
 sal;
 
END IF;

DECODE (job, 'SALESMAN', sal)

DECODE (job, 'MANAGER', sal)

SELECT 1,2,3 FROM DUAL

SELECT EMPNO 사번, ENAME 이름, JOB 직업
      ,DECODE ( JOB , 'MANAGER', SAL, null) 매니저
      ,DECODE ( JOB, 'SALESMAN', SAL) 세일즈맨
      ,DECODE ( JOB, 'MANAGER', NULL
                   , 'SALESMAN',NULL
                                ,SAL) 나머지 --세일즈맨이니? 네! null~
       FROM EMP

