SELECT cdate "일자"
       ,amt "금액"
       ,crate "환율"
       ,LAG(crate,1) OVER(ORDER BY cdate) as "D-1"
       ,LAG(crate,2) OVER(ORDER BY cdate) as "D-2"
       ,LAG(crate,3) OVER(ORDER BY cdate) as "D-3"
       ,LAG(crate,4) OVER(ORDER BY cdate) as "D-4"
       ,LAG(crate,5) OVER(ORDER BY cdate) as "D-5"
       FROM TEST02
 