SELECT * FROM ZIPCODE_tSIGU

SELECT zipcode, address 
FROM zipcode_t 
WHERE dong like '%' ||'당산동'||'%'


SELECT zipcode, address 
FROM zipcode_t 
WHERE dong like '%'||'당산동'

SELECT zipcode, address 
FROM zipcode_t 
WHERE dong like '당산동' ||'%'


SELECT ENAME, DEPTNO
FROM EMP
WHERE DEPTNO = '20'
OR DEPTNO = '30'
MINUS
SELECT ENAME, DEPTNO
FROM EMP
WHERE DEPTNO = '20';

SELECT DEPT_NAME
FROM TDEPT
WHERE DEPT_NAME LIKE '영업%';

SELECT  DEPT_CODE AS 부서코드, '삼성'|| DEPT_NAME AS 부서명 
FROM TDEPT
WHERE DEPT_NAME LIKE '%지원';

SELECT BOSS_ID, AREA FROM TDEPT
MINUS
SELECT BOSS_ID, AREA
FROM TDEPT
WHERE AREA = '서울'

SELECT DEPT_CODE FROM TEMP
INTERSECT
SELECT DEPT_CODE FROM TDEPT;


