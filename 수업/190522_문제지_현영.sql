SELECT 
FROM t_orderbasket,(select rownum rno from t_orderbasket where rownum
group by 물품구분,판매날짜


SELECT gubun_Vc
       ,sum(DECODE(a.GUBUN_VC, '과자류', QTY_NU,'담배',QTY_NU,'빙과류',QTY_NU,'음료',QTY_NU,'청과류',   QTY_NU)) 물품구분
       ,SUM(DECODE(GUBUN_VC, '과자류', QTY_NU,'담배',QTY_NU,'빙과류',QTY_NU,'음료',QTY_NU,'청과류',
       QTY_NU)) 판매개수
       ,SUM(DECODE(GUBUN_VC, '과자류', QTY_NU*PRICE_NU,'담배',QTY_NU*PRICE_NU,'빙과류',QTY_NU*PRICE_NU,'음료',QTY_NU*PRICE_NU,'청과류',
       QTY_NU*PRICE_NU)) 판매가격
FROM (SELECT indate_vc, gubun_vc,qty_nu,price_nu from t_orderbasket) a
     ,(SELECT indate_vc, gubun_vc,qty_nu,price_nu from t_orderbasket)b
     group by gubun_vc



group by 물품구분,판매날짜

SELECT indate_vc, gubun_vc
,sum(DECODE(GUBUN_VC, '과자류', QTY_NU,'담배',QTY_NU,'빙과류',QTY_NU,'음료',QTY_NU,'청과류', QTY_NU)) 판매개수
,sum(DECODE(GUBUN_VC, '과자류', QTY_NU*PRICE_NU,'담배',QTY_NU*PRICE_NU,'빙과류',QTY_NU*PRICE_NU,'음료'
,QTY_NU*PRICE_NU,'청과류', QTY_NU*PRICE_NU)) 판매가격
from t_orderbasket,(select
group by gubun_vc,indate_Vc
order by indate_Vc

SELECT DECODE(ROWNUM,1,indate_vc,2,'소계',3,'총계)
FROM t_orderbasket, (SELECT ROWNUM FROM emp WHERE ROWNUM<4)