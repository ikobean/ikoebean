ROLLUP�� GROUP BY ���� ���Ǹ� GROUP�� ������ ����
��Ƽ ������ �Ұ� �� �հ踦 �����ִ� �Լ�
ROLLUP�̳� CUBE�� �ٷ�鼭 GROUPING �Լ��� ���� �� �� �ִµ�
�̰��� ��� ���� SET�� ǥ���Կ� �־� NULL�̸� 1 �ƴϸ� 0�� RETURN�����ν�
�Ұ�� �Ѱ�κ��� ��Ÿ���ִ� ������ ��.

���� ���� �Ǹ���Ȳ�� ��¥�� ��ǰ�з� ����� ������ �Ѵٸ� 

SELECT indate_vc, gubun_vc
       , sum(qty_nu*price_nu)||'��'
 FROM t_orderbasket
 GROUP BY ROLLUP(indate_vc, gubun_vc)
 
 SELECT indate_vc, gubun_vc,name_Vc
       , sum(qty_nu*price_nu)||'��'
 FROM t_orderbasket
 GROUP BY ROLLUP(indate_vc, gubun_vc,name_Vc)
 
 
  SELECT indate_vc, gubun_vc
        ,SUM(qty_nu)
        ,sum(qty_nu*price_nu)||'��'
 FROM t_orderbasket
 GROUP BY CUBE(indate_vc, gubun_vc)
 ORDER BY INDATE_VC
 
   SELECT indate_vc, gubun_vc
        ,SUM(qty_nu)
        ,sum(qty_nu*price_nu)||'��'
 FROM t_orderbasket
 GROUP BY CUBE(indate_vc, gubun_vc)
 ORDER BY INDATE_VC
 
 
 
   SELECT DECODE(GROUPING(indate_vc), 1,'ALL days', indate_vc)
         ,DECODE(GROUPING(gubun_vc),1
         ,DECODE(LAG(GROUPING(gubun_vc),1)
          OVER(ORDER BY indate_vc),1,'Total','�Ұ�'),gubun_vc)
         ,name_vc
         ,sum(qty_nu*price_nu)||'��'
 FROM t_orderbasket
 GROUP BY ROLLUP(indate_vc, gubun_vc,name_vc)



SELECT DECODE(rno,1,dname,2,'�Ѱ�') dname  
      ,SUM(DECODE(JOB,'CLERK',SAL,NULL)) CLERK
      ,SUM(DECODE(JOB,'MANAGER',SAL,NULL)) MANAGER
      ,SUM(DECODE(JOB,'CLERK',NULL
                     ,'MANAGER',NULL
                     ,SAL))ETC
      ,SUM(DECODE(DEPT.DEPTNO,10,SAL,20,SAL,30,SAL)) DEPT_SAL
      FROM EMP,DEPT
     ,(SELECT ROWNUM rno FROM EMP WHERE rownum<3) a
     WHERE EMP.DEPTNO=DEPT.DEPTNO
     GROUP BY DECODE(rno,1,dname,2,'�Ѱ�')
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
         ,SUM(DECODE(BB.no,'1',dname,'�Ѱ�'))
          FROM emp
          GROUP BY DEPTNO)A,DEPT B
          WHERE A.DEPTNO=B.DEPTNO
          
   DECODE(BB.no,'1',dname,'�Ѱ�')
   
   
   --------������ Ǯ��
   
SELECT DECODE(NO,'1',DNAME,'�Ѱ�') �μ���
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
GROUP BY DECODE(NO,'1',DNAME,'�Ѱ�')
ORDER BY "�μ���" 



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