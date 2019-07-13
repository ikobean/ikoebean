ROLLUP은 GROUP BY 절에 사용되면 GROUP의 순서에 의한
멀티 레벨의 소계 및 합계를 구해주는 함수
ROLLUP이나 CUBE를 다루면서 GROUPING 함수를 종종 볼 수 있는데
이것은 모든 값의 SET을 표현함에 있어 NULL이면 1 아니면 0을 RETURN함으로써
소계와 총계부분을 나타내주는 역할을 함.

만일 가게 판매현황을 날짜와 물품분류 목록을 가지고 한다면 

SELECT indate_vc, gubun_vc
       , sum(qty_nu*price_nu)||'원'
 FROM t_orderbasket
 GROUP BY ROLLUP(indate_vc, gubun_vc)
 
 SELECT indate_vc, gubun_vc,name_Vc
       , sum(qty_nu*price_nu)||'원'
 FROM t_orderbasket
 GROUP BY ROLLUP(indate_vc, gubun_vc,name_Vc)
 
 
  SELECT indate_vc, gubun_vc
        ,SUM(qty_nu)
        ,sum(qty_nu*price_nu)||'원'
 FROM t_orderbasket
 GROUP BY CUBE(indate_vc, gubun_vc)
 ORDER BY INDATE_VC
 
   SELECT indate_vc, gubun_vc
        ,SUM(qty_nu)
        ,sum(qty_nu*price_nu)||'원'
 FROM t_orderbasket
 GROUP BY CUBE(indate_vc, gubun_vc)
 ORDER BY INDATE_VC
 
 
 
   SELECT DECODE(GROUPING(indate_vc), 1,'ALL days', indate_vc)
         ,DECODE(GROUPING(gubun_vc),1
         ,DECODE(LAG(GROUPING(gubun_vc),1)
          OVER(ORDER BY indate_vc),1,'Total','소계'),gubun_vc)
         ,name_vc
         ,sum(qty_nu*price_nu)||'원'
 FROM t_orderbasket
 GROUP BY ROLLUP(indate_vc, gubun_vc,name_vc)



SELECT DECODE(rno,1,dname,2,'총계') dname  
      ,SUM(DECODE(JOB,'CLERK',SAL,NULL)) CLERK
      ,SUM(DECODE(JOB,'MANAGER',SAL,NULL)) MANAGER
      ,SUM(DECODE(JOB,'CLERK',NULL
                     ,'MANAGER',NULL
                     ,SAL))ETC
      ,SUM(DECODE(DEPT.DEPTNO,10,SAL,20,SAL,30,SAL)) DEPT_SAL
      FROM EMP,DEPT
     ,(SELECT ROWNUM rno FROM EMP WHERE rownum<3) a
     WHERE EMP.DEPTNO=DEPT.DEPTNO
     GROUP BY DECODE(rno,1,dname,2,'총계')
     ORDER BY DNAME
     
     
     
     SELECT B.dnAme, CLERK,MANAGER,ETC,DEPT_SAL
     FROM(     
           SELECT DEPTNO
          ,SUM(DECODE(job,'CLERK',sal,null)) CLERK
          ,SUM(DECODE(JOB,'MANAGER',SAL,NULL)) MANAGER
          ,SUM(DECODE(JOB,'CLERK',NULL
                         ,'MANAGER',NULL
                         ,SAL))ETC
         ,SUM(SAL) DEPT_SAL
          FROM emp
          GROUP BY DEPTNO)A,DEPT B
          WHERE A.DEPTNO=B.DEPTNO
         
         
          
          SELECT '1' NO FROM dual
          UNION ALL
          SELECT '2' FROM dual
     
     
     
     
     SELECT B.dnAme, CLERK,MANAGER,ETC,DEPT_SAL
     FROM(     
           SELECT DEPTNO
          ,SUM(DECODE(job,'CLERK',sal,null)) CLERK
          ,SUM(DECODE(JOB,'MANAGER',SAL,NULL)) MANAGER
          ,SUM(DECODE(JOB,'CLERK',NULL
                         ,'MANAGER',NULL
                         ,SAL))ETC
         ,SUM(SAL) DEPT_SAL
         ,SUM(DECODE(BB.no,'1',dname,'총계'))
          FROM emp
          GROUP BY DEPTNO)A,DEPT B
          WHERE A.DEPTNO=B.DEPTNO
          
   DECODE(BB.no,'1',dname,'총계')
   
   
   --------선생님 풀이
   
SELECT DECODE(NO,'1',DNAME,'총계') 부서명
       ,SUM(clerk),SUM(manager),SUM(etc),SUM(dept_sal)
 FROM(SELECT B.dname,clerk,manager,etc,dept_sal
          FROM (SELECT deptno
             , SUM(DECODE(job,'CLERK',SAL)) CLERK
             , SUM(DECODE(job,'MANAGER',SAL)) MANAGER
             , SUM(DECODE(job,'CLERK',null,'MANAGER',null,SAL)) ETC
             , SUM(SAL) DEPT_SAL
                    FROM emp GROUP BY deptno) A , DEPT B
                  WHERE A.DEPTNO = B.DEPTNO)AA,
                  (SELECT '1' no FROM dual
                    UNION ALL
                    SELECT '2' FROM dual)BB
GROUP BY DECODE(NO,'1',DNAME,'총계')
ORDER BY "부서명" 



SELECT B.dname,clerk,manager,etc,dept_sal
          FROM (SELECT deptno
             , SUM(DECODE(job,'CLERK',SAL)) CLERK
             , SUM(DECODE(job,'MANAGER',SAL)) MANAGER
             , SUM(DECODE(job,'CLERK',null,'MANAGER',null,SAL)) ETC
             , SUM(SAL) DEPT_SAL
                    FROM emp GROUP BY deptno) A , DEPT B
                  WHERE A.DEPTNO = B.DEPTNO)AA,
                  (SELECT '1' no FROM dual
                    UNION ALL
                    SELECT '2' FROM dual)BB