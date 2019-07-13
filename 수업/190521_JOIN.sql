edit dept

SELECT emp.deptno, dept.deptno,dept.dname
FROM emp, dept
WHERE emp.deptno(+) = dept.deptno

  --플러스 기호를 사용하는 것과 반대방향의 예약어 사용
  
SELECT emp.deptno, dept.deptno,dept.dname
FROM emp RIGHT OUTER JOIN dept
  ON emp.deptno = dept.deptno
  
  
  SELECT emp.deptno, dept.deptno,dept.dname
FROM dept LEFT OUTER JOIN emp
  ON emp.deptno = dept.deptno
  
  non-equal 조인
  조인 조건이 '=' 이 아닌 다른 연산기호로 주어지는 경우
  
    temp와 emp_level을 이용해 emp_level의 과장 직급의 연봉
  상한/하한 범위 내에 드는 직원의 사번과 성명, 직급, salary를 출력하는 sql문을 작성하시오.
  
  SELECT * FROM emp_level
  
  SELECT T.EMP_NAME, T.LEV, T.salary
  FROM emp_level E, temp T
  WHERE T.SALARY BETWEEN E.FROM_SAL and E.TO_SAL
  AND E.LEV='과장'
  
  --------------선생님 풀이----------------------------
  
  SELECT temp.emp_id, temp.emp_name, temp.lev, temp.salary
  FROM temp, emp_level
  WHERE emp_level.lev='과장'
  and temp.salary BETWEEN from_sal and to_sal
  
  
  
  
  2.
  각 사번의 성명, SALARY, 연봉하한금액, 연봉상한금액을 보고자 한다.
  이 정보를 출력하는 SELECT 문은 어떻게 조인을 걸어야 할까?
  
  SELECT emp_id 성명, emp_name 이름, salary 연봉, from_sal 하한금액, to_sal 상한금액
  from emp_level l, temp p
  WHERE L.LEV = p.lev
  
  
SELECT  NAME_VC, QUANTITY_NU
FROM T_GIFTORDER
    ,(select rownum from t_giftorder where rownum <3)
    
SELECT a.NAME_VC
      FROM T_GIFTORDER a,T_GIFTORDER b
WHERE A.NAME_vC='건담' OR A.NAME_VC='마크로스'
AND 

