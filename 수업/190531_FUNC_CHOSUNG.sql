CREATE OR REPLACE FUNCTION func_chosung(str IN varchar2)
return varchar2
IS 
   returnStr varchar2(200);  -- �� �� ��
   cnt number := 0; --���ڿ� ����
   tempStr varchar2(10); --����濡�� �ѱ���� ���
BEGIN
    if str is null then
    return'';
    end if;
    cnt:=length(str);
    for i in 1..cnt loop
    tempStr:=substr(str,i,1);
   returnStr := returnStr||
   case when tempStr < '��' then substr(tempStr,1,1)
        when ascii('r') <= ascii (tempStr) and ascii(tempStr) <=ascii('��')then
        chr(ascii(tempStr))        
        when tempStr <'��' then'��'
        when tempStr <'��' then'��'
        when tempStr <'��' then'��'
        WHEN tempStr <'��' then'��'
        when tempStr <'��' then'��'
        when tempStr <'��' then'��'
        when tempStr <'��' then'��'
        when tempStr <'��' then'��'
        when tempStr <'��' then'��'
        when tempStr <'ī' then'��'
        when tempStr <'Ÿ' then'��'
        when tempStr <'��' then'��'
        when tempStr <'��' then'��'
        else '��'
        end;
  end loop;
  return returnStr;
END;

select substr('�����',0,1), substr('�����',1,1)
,substr('�����',2,1) from dual

SELECT func_chosung('�����'),func_chosung('123'),
        func_chosung('abc'),func_chosung('������')
        FROM DUAL
        
        select func_chosung(category) from product