SELECT *
FROM TDEPT a, TDEPT b
WHERE a.dept_code=b.parent_dept

연습문제1
tdept 테이블에 자신의 상위 부서 정보를 관리하고 있다.
이 테이블을 이용하여 부서코드, 부서명, 상위부서코드, 상위부서명을 읽어오는 sql문을 작성하시오.

SELECT a.dept_code 부서코드, b.dept_name 부서명, a.parent_dept 상위부서코드, a.dept_name 상위부서명
from TDEPT a, TDEPT b
WHERE a.dept_code=b.parent_dept



연습문제2
temp와 tdept를 이용하여 다음 컬럼을 보여주는 SQL문을 작성하시오.
1.사번, 2.성명, 3.부서코드, 4.부서명,
 5.상위부서코드 6.상위부서명,
  7.상위부서장코드, 8.상위부서장성명
상위부서가 'CA0001'

SELECT b.emp_id, b.emp_name, b.dept_code, a.dept_name
       ,a.parent_dept, a.dept_name
       ,c.boss_id,d.emp_name
from tdept a, temp b, tdept c, temp d
WHERE  
   
양쪽에 같은 컬럼이 있을때는
PK가 있는 테이블에서 가져와야함. 
INDEX 되어있기 때문에 테이블 스캔을하지 않아 훨씬 빠름
그래서 부서코드는 부서에서 가져오는 게 좋음

뷰(view)


SELECT A.emp_id, A.emp_name, B.dept_code, B.dept_name
  FROM temp A, tdept B
  WHERE A.dept_cdoe = B.dept_code
  
  
  SELECT A.emp_id, A.emp_name, B.dept_code, B.dept_name
        ,c.parent_dept, c.dept_name
        FROM temp A, tdept B, tdept C
        WHERE A.dept_cdoe = B.dept_code
        AND   B.parent_code = C.dept_code
        AND   C.DEPT_CODE= 'CA0001'
  
  
    SELECT A.emp_id, A.emp_name, B.dept_code, B.dept_name
        ,c.parent_dept, c.dept_name
        ,D.emp_id as "상위부서장id"
        ,D.emp_name as "부서장성명"
        FROM temp A, tdept B, tdept C, temp D
        WHERE A.dept_code = B.dept_code
        AND   B.parent_dept = C.dept_code
        AND   C.DEPT_CODE= 'CA0001'
        AND   D.emp_id = C.boss_id
        
        
        결론
        집합이 4개이면 조인조건 3개
        
        
        
    SELECT 회원.회원명 ,DVD.DVD이름           
        FROM 회원 A, 대여 B, DVD C,
        WHERE 회원.회원아이디=대여.회원아이디
          AND 대여.DVD코드=DVD.DVD코드
         
        
        
        
        
        
        
        