SELECT rownum 순위  FROM emp

SELECT rownum rno, ename FROM emp
 WHERE deptno = 20
 
SELECT rownum rno, ename FROM emp
WHEERE deptno = 20
AND rno :<3
--안됨 테이블에 없는 컬럼이라서

인라인뷰를 사용하면 테이블에 없는 컬럼도 조건절에 사용할 수 있다.
인라인뷰는 셀렉트문이다. 프롬절 프롬절 프롬절 프롬절 인라인뷰 프롬절

SELECT RNO, ENAME
 FROM (SELECT rownum rno, ename FROM emp
       WHERE deptno = 20)
 WHERE RNO <3
 
 WHERE절에 오는 SELECT 는 서브쿼리
 
