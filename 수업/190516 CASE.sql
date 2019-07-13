temp 테이블에서 연봉 구간이 있는데
8000 이상 1억까지는 a등급
6000 이상 8000미만 b등급
4000 이상 6000미만은 c등급
사원번호 사원명 급여 등급

SELECT EMP_ID 사번, EMP_NAME 이름,SALARY 연봉
    ,CASE WHEN  SALARY BETWEEN 80000000 AND 100000000  THEN 'A'
          WHEN  SALARY BETWEEN 60000000 AND 800000000-1  THEN 'B'
          WHEN  SALARY BETWEEN 40000000 AND 600000000-1  THEN 'C'
          ELSE 'D'
     END AS 등급
     FROM TEMP

    


SELECT COUNT(등급) 인원, 등급
FROM(SELECT EMP_ID 사번, EMP_NAME 이름,SALARY 연봉
    ,CASE WHEN  SALARY BETWEEN 80000000 AND 100000000  THEN 'A'
          WHEN  SALARY BETWEEN 60000000 AND 800000000-1  THEN 'B'
          WHEN  SALARY BETWEEN 40000000 AND 600000000-1  THEN 'C'
          ELSE 'D'
     END AS 등급
     FROM TEMP)
     GROUP BY 등급
     ORDER BY 등급
     
    
SELECT count(등급) 인원, 등급
FROM(
     SELECT EMP_ID 사번, EMP_NAME 이름,SALARY 연봉
    ,CASE WHEN  SALARY BETWEEN 80000000 AND 100000000  THEN 'A'
          WHEN  SALARY BETWEEN 60000000 AND 800000000-1  THEN 'B'
          WHEN  SALARY BETWEEN 40000000 AND 600000000-1  THEN 'C'
          ELSE 'D'
     END AS 등급
     FROM TEMP
     )i_temp
     GROUP BY i_temp.등급
     ORDER BY 등급
     

    학습목표
    인라인뷰는 뷰안에서 사용한 컬럼을 주쿼리문에서 사용할 수 있다.
    그룹함수를 사용할 경우 함수를 사용하지 않는 다른 컬럼을 사용할 수 없다.
    문제해결방법
    group by 사용하면 사용할 수 있다.
    
    주의사항
    group by에 사용하는 컬럼을 잘못선택하면 효과를 전혀 볼 수 없다.
    그룹함수가 없는 컬럼 사용은 group by 절에 사용한 경우만 가능하다.
    
    ex)
    
    select deptno, count(empno) FROM emp
    GROUP BY deptno
    
    
    