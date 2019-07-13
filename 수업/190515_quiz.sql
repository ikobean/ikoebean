 문제1
 temp와 tcom의 자료 중 emp_id, salary, comm을
 보여주는 sql 문을 작성하시오.
 이 때 salary와 comm이 모두 존재하는 사번은 두 줄로 나와야 함
 

 SELECT EMP_ID,SALARY        
 FROM TEMP
 UNION
 SELECT EMP_ID,COMM
 FROM TCOM
 
 
 
 UNION - 중복제거 - 두 집합을 스캔을 먼저 한다!
                 -정렬이 일어남
 UNION ALL - 중복허용 - 정렬 없다
 
 컬럼의 갯수가 일치해야함.
 타입도 서로 맞아야 함.
 
 SELECT '안녕' FROM dual
 UNION ALL
 SELECT  1 FROM dual
 
 ---------------------

 SELECT emp_id, salary, 0 comm FROM temp
 UNION 
 SELECT emp_id, 0 salary, comm FROM tcom
 
 --------0이랑 ''차이
 ---타입이 넘버면 0, 문자면 ''
 
 문제 2
 우리 회사에 근무하는 사원 중에서 인센티브를 받지 않는 사원의 아이디와 이름을 출력하는 SQL문을 작성하시오.
 
 SELECT EMP_ID, EMP_NAME  --전체집합
 FROM TEMP
 MINUS
 SELECT EMP_ID, '' EMP_NAME    --인센티브집합
 FROM TCOM
 
 

 SELECT EMP_ID FROM TEMP
 MINUS
 SELECT EMP_ID FROM TCOM
