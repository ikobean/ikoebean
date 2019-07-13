SELECT rownum rno, emp_name FROM temp

인라인뷰~~프롬절 안에 select~~~

SELECT a.rno, a.emp_name
    FROM (SELECT rownum rno, emp_name FROM temp)a
    WHERE a.rno>=:s AND a.rno <=:e
