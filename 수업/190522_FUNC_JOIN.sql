SELECT a.cdate, a.amt, a.crate
      ,decode(,  ,b.crate)D1
FROM test02 a, (Select rownum,cdate,amt,crate from test02)b


select rownum, cdate,amt,crate from test02

SELECT a.cdate, a.amt, a.crate
      ,DECODE(a.rno,b.rno-1,b.crate) "D-1"
      ,DECODE(a.rno,b.rno-2,b.crate) "D-2"
      ,DECODE(a.rno,b.rno-3,b.crate) "D-3"
      ,DECODE(a.rno,b.rno-4,b.crate) "D-4"
      ,DECODE(a.rno,b.rno-5,b.crate) "D-5"
FROM (Select rownum rno,cdate,amt,crate from test02) a
   , (Select rownum rno,cdate,amt,crate from test02)b


SELECT a.cdate, a.amt, a.crate
      ,DECODE(a.rno,b.rno-2,a.crate) "D-1"
      ,DECODE(a.rno,b.rno-3,a.crate) "D-2"
      ,DECODE(a.rno,b.rno-4,a.crate) "D-3"
      ,DECODE(a.rno,b.rno-5,a.crate) "D-4"
      ,DECODE(a.rno,b.rno-6,a.crate) "D-5"
FROM (Select rownum rno,cdate,amt,crate from test02) a
   , (Select rownum rno,cdate,amt,crate from test02)b
  WHERE a.cdate<b.cdate 




SELECT*
FROM (Select rownum rno,cdate,amt,crate from test02) a
   , (Select rownum rno,cdate,amt,crate from test02)b
   
   SELECT a.cdate, a.amt, a.crate
      ,DECODE(a.rno,b.rno-2,a.crate) "D-1"
      ,DECODE(a.rno,b.rno-3,a.crate) "D-2"
      ,DECODE(a.rno,b.rno-4,a.crate) "D-3"
      ,DECODE(a.rno,b.rno-5,a.crate) "D-4"
      ,DECODE(a.rno,b.rno-6,a.crate) "D-5"
FROM (Select rownum rno,cdate,amt,crate from test02) a
   , (Select rownum rno,cdate,amt,crate from test02)b
  WHERE a.cdate<b.cdate 
 