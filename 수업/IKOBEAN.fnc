--ȸ���� ���̵� �Է¹޾Ƽ� �̹��� �� �뿩�Ḧ ������ִ� �Լ��� �ۼ��Ͻÿ�.
--Ȥ�� �б⺰�� ���ϰų� �ݱ⺰ �Ǵ� ������ �뿩�Ḧ ����� ����.

CREATE OR REPLACE FUNCTION ikobean(p_userid IN varchar2)
return number;
IS
msg varchar2(200);
BEGIN
    SELECT NAME,MEM_ID,RENT_FEE FROM MEMBER M,RENT R WHERE M.MEM_ID = R.MEM_ID;
    
    IF(p_userid:=r.mem_id) then
    sum(r.rent_fee);
    
    END IF;
      
END;


