SELECT 1 FROM member WHERE mem_id=:p_id

SELECT NvL((SELECT 1 FROM member
            WHERE mem_id=:p_id),-1) into r_status
            FROM dual           
            
             
CREATE OR REPLACE PROCEDURE proc_login_t          
BEGIN SELECT NvL((SELECT 1 FROM member
            WHERE mem_id=:p_id),-1) into r_status
            FROM dual;
        if r_status=1 then
            select nvl((select mem_name||'님 환영합니다.'
                        FROM member
                        WHERE mem_id=p_id AND mem_pw=p_pw),'비밀번호가 틀립니다.') INTO msg
                  FROM dual;
        elsif r_status=-1 then
        msg:='아이디가 존재하지 않습니다.'
end if;
END;

            