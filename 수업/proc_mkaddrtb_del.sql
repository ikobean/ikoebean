CREATE OR REPLACE PROCEDURE proc_mkaddrtb_del(u_id IN varchar2, msg OUT varchar2)
IS
    result number(5);
BEGIN
        select nvl((select 1 from mkaddrtb where id=u_id),0) into result from dual;
    if result=1 then
        DELETE FROM mkaddrtb 
        WHERE id=u_id;
            commit;
    else
        msg:='아이디가 존재하지 않습니다.';
    end if;
END;


