SELECT rownum rno, emp_name FROM temp

�ζ��κ�~~������ �ȿ� select~~~

SELECT a.rno, a.emp_name
    FROM (SELECT rownum rno, emp_name FROM temp)a
    WHERE a.rno>=:s AND a.rno <=:e
