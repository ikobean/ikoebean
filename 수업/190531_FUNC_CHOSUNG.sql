CREATE OR REPLACE FUNCTION func_chosung(str IN varchar2)
return varchar2
IS 
   returnStr varchar2(200);  -- ㄱ ㅅ ㅊ
   cnt number := 0; --문자열 길이
   tempStr varchar2(10); --기생충에서 한글잤기 담기
BEGIN
    if str is null then
    return'';
    end if;
    cnt:=length(str);
    for i in 1..cnt loop
    tempStr:=substr(str,i,1);
   returnStr := returnStr||
   case when tempStr < 'ㄱ' then substr(tempStr,1,1)
        when ascii('r') <= ascii (tempStr) and ascii(tempStr) <=ascii('ㅎ')then
        chr(ascii(tempStr))        
        when tempStr <'나' then'ㄱ'
        when tempStr <'다' then'ㄴ'
        when tempStr <'라' then'ㄷ'
        WHEN tempStr <'마' then'ㄹ'
        when tempStr <'바' then'ㅁ'
        when tempStr <'사' then'ㅂ'
        when tempStr <'아' then'ㅅ'
        when tempStr <'자' then'ㅇ'
        when tempStr <'차' then'ㅈ'
        when tempStr <'카' then'ㅊ'
        when tempStr <'타' then'ㅋ'
        when tempStr <'파' then'ㅎ'
        when tempStr <'하' then'ㅌ'
        else 'ㅎ'
        end;
  end loop;
  return returnStr;
END;

select substr('기생충',0,1), substr('기생충',1,1)
,substr('기생충',2,1) from dual

SELECT func_chosung('기생충'),func_chosung('123'),
        func_chosung('abc'),func_chosung('ㄱㅅㅊ')
        FROM DUAL
        
        select func_chosung(category) from product