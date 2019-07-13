SELECT deptno FROM emp

옵티마이저 모드
1)규칙기반의 옵티마이저
2)비용기반의 옵티마이저

ALL_ROWS
비용기반의 옵티마이저의 디폴트모드
모든 조건에 만족하는 데이터를 찾는데 가장 효율적인 방법


SELECT /*+rule*/ empno, ename FROM emp

SELECT /*+all_rows*/ empno, ename FROM emp

주의:힌트문에 에러가 있을 경우에는 무시된다.
    개발자의 이러한 요구가 반드시 반영되는 것은 아니다.
   

SELECT deptno FROM dept

CREATE OR REPLACE VIEW v_emp
AS
SELECT empno, ename, sal FROM emp

SELECT

★
view 계정 주는 방법
sys계정 들어와서 grant create view to 계정명 
★

SELECT hiredate FROM v_emp  --부적합한 식별자

뷰에 정의하지 않은 컬럼은 사용불가.

SELECT
        a.empno, b.deptno
   FROM emp a, dept b
   WHERE a.deptno = b.deptno

CREATE OR REPLACE VIEW v_emp2
AS
SELECT
        a.empno, b.deptno
   FROM emp a, dept b
   WHERE a.deptno = b.deptno
   
SELECT * FROM v_emp2

DROP VIEW v_emp2



   
