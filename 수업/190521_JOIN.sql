edit dept

SELECT emp.deptno, dept.deptno,dept.dname
FROM emp, dept
WHERE emp.deptno(+) = dept.deptno

  --�÷��� ��ȣ�� ����ϴ� �Ͱ� �ݴ������ ����� ���
  
SELECT emp.deptno, dept.deptno,dept.dname
FROM emp RIGHT OUTER JOIN dept
  ON emp.deptno = dept.deptno
  
  
  SELECT emp.deptno, dept.deptno,dept.dname
FROM dept LEFT OUTER JOIN emp
  ON emp.deptno = dept.deptno
  
  non-equal ����
  ���� ������ '=' �� �ƴ� �ٸ� �����ȣ�� �־����� ���
  
    temp�� emp_level�� �̿��� emp_level�� ���� ������ ����
  ����/���� ���� ���� ��� ������ ����� ����, ����, salary�� ����ϴ� sql���� �ۼ��Ͻÿ�.
  
  SELECT * FROM emp_level
  
  SELECT T.EMP_NAME, T.LEV, T.salary
  FROM emp_level E, temp T
  WHERE T.SALARY BETWEEN E.FROM_SAL and E.TO_SAL
  AND E.LEV='����'
  
  --------------������ Ǯ��----------------------------
  
  SELECT temp.emp_id, temp.emp_name, temp.lev, temp.salary
  FROM temp, emp_level
  WHERE emp_level.lev='����'
  and temp.salary BETWEEN from_sal and to_sal
  
  
  
  
  2.
  �� ����� ����, SALARY, �������ѱݾ�, �������ѱݾ��� ������ �Ѵ�.
  �� ������ ����ϴ� SELECT ���� ��� ������ �ɾ�� �ұ�?
  
  SELECT emp_id ����, emp_name �̸�, salary ����, from_sal ���ѱݾ�, to_sal ���ѱݾ�
  from emp_level l, temp p
  WHERE L.LEV = p.lev
  
  
SELECT  NAME_VC, QUANTITY_NU
FROM T_GIFTORDER
    ,(select rownum from t_giftorder where rownum <3)
    
SELECT a.NAME_VC
      FROM T_GIFTORDER a,T_GIFTORDER b
WHERE A.NAME_vC='�Ǵ�' OR A.NAME_VC='��ũ�ν�'
AND 

