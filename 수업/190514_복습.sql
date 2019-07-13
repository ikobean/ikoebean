SELECT empno, ename as "이름"
FROM emp
WHERE 이름 = 'SMITH'

SELECT empno, ename "이름"
FROM emp
WHERE 이름 = 'SMITH'

문제제기
컬럼명에 별칭을 부여했을 경우 WHERE 절에서 별칭을 사용할 수 없다.

해결방법
인라인뷰를 사용하면 가능함.

생긴 꼴: FROM 절 아래 SELECT 문이 온 경우 - 인라인뷰
--WHERE 절 밑에 SELECT - 서브쿼리

SELECT
  FROM (
             SELECT 문      --인라인뷰(View의 일종) 은행권에서 많이 씀
                           --테이블이 아니고 select문
                           --select문에 사용된 컬럼명이 테이블이 되는 것
        )
        
        
SELECT empno, ename 이름
FROM emp, (SELECT ename FROM EMP)
WHERE '이름' = 'SMITH'

SELECT EMPNO 사번, "이름"
 FROM(
      SELECT empno, ename "이름"
      FROM emp
      )
 WHERE 이름 = 'SMITH'
 
SELECT ENAME, "부서번호"
FROM
    (SELECT ENAME, DEPTNO "부서번호"
    FROM EMP)
    WHERE 부서번호 = 30
    
SELECT ename FROM emp

SELECT  deptno 부번, count(*) 몇명
FROM emp 
GROUP BY deptno

SELECT  "부번" , count(*) 몇명
FROM (SELECT DEPTNO "부번" FROM EMP)
GROUP BY "부번"

확인한 내용
같은 데이터가 없으면 group by한 효과가 없다.
정렬된 내용이 다르다. 랜덤하다.

SELECT hiredate FROM emp GROUP BY hiredate

SELECT deptno, max(ename), min(ename),count(*) FROM emp GROUP BY deptno

SELECT  deptno FROM emp 
GROUP BY deptno
HAVING DEPTNO = 10

SELECT  deptno FROM emp 
GROUP BY deptno
WHERE DEPTNO = 10 안돼 안돼 안돼 안돼

