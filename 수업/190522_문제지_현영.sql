SELECT 
FROM t_orderbasket,(select rownum rno from t_orderbasket where rownum
group by ��ǰ����,�Ǹų�¥


SELECT gubun_Vc
       ,sum(DECODE(a.GUBUN_VC, '���ڷ�', QTY_NU,'���',QTY_NU,'������',QTY_NU,'����',QTY_NU,'û����',   QTY_NU)) ��ǰ����
       ,SUM(DECODE(GUBUN_VC, '���ڷ�', QTY_NU,'���',QTY_NU,'������',QTY_NU,'����',QTY_NU,'û����',
       QTY_NU)) �ǸŰ���
       ,SUM(DECODE(GUBUN_VC, '���ڷ�', QTY_NU*PRICE_NU,'���',QTY_NU*PRICE_NU,'������',QTY_NU*PRICE_NU,'����',QTY_NU*PRICE_NU,'û����',
       QTY_NU*PRICE_NU)) �ǸŰ���
FROM (SELECT indate_vc, gubun_vc,qty_nu,price_nu from t_orderbasket) a
     ,(SELECT indate_vc, gubun_vc,qty_nu,price_nu from t_orderbasket)b
     group by gubun_vc



group by ��ǰ����,�Ǹų�¥

SELECT indate_vc, gubun_vc
,sum(DECODE(GUBUN_VC, '���ڷ�', QTY_NU,'���',QTY_NU,'������',QTY_NU,'����',QTY_NU,'û����', QTY_NU)) �ǸŰ���
,sum(DECODE(GUBUN_VC, '���ڷ�', QTY_NU*PRICE_NU,'���',QTY_NU*PRICE_NU,'������',QTY_NU*PRICE_NU,'����'
,QTY_NU*PRICE_NU,'û����', QTY_NU*PRICE_NU)) �ǸŰ���
from t_orderbasket,(select
group by gubun_vc,indate_Vc
order by indate_Vc

SELECT DECODE(ROWNUM,1,indate_vc,2,'�Ұ�',3,'�Ѱ�)
FROM t_orderbasket, (SELECT ROWNUM FROM emp WHERE ROWNUM<4)