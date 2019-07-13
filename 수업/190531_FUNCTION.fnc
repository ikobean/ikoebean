CREATE OR REPLACE FUNCTION ikobean(p_userid IN varchar2)
return number
IS
v_mem_id varchar2(200);
v_rent_fee number(9,2);

BEGIN
  
    SELECT sum(rent_fee) into  v_rent_fee from rent r
    WHERE p_userid = r.mem_id;
    RETURN v_rent_fee;  
    
END;




       
       select ikobean('APPLE',3) from dual;





CREATE OR REPLACE FUNCTION ikobean(p_userid IN varchar2, p_Date in number)
return number
IS
v_mem_id varchar2(200);
v_rent_fee number(9,2);
v_date number(2);
BEGIN
  
    SELECT rent_fee*p_date into  v_rent_fee from rent r
    WHERE p_userid = r.mem_id;
    RETURN v_rent_fee;  
    
END;

