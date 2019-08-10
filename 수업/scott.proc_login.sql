SELECT 1 FROM member WHERE mem_id=:p_id

SELECT NvL((SELECT 1 FROM member
            WHERE mem_id=:p_id),-1) into r_status
            FROM dual           
            
             
CREATE OR REPLACE PROCEDURE SCOTT.proc_login(p_id IN VARCHAR2, p_pw IN VARCHAR2, msg out VARCHAR2, r_status OUT VARCHAR2) 
IS   
BEGIN SELECT NVL((SELECT mem_id FROM member
            WHERE mem_id=p_id),'-1') into r_status
            FROM dual;
        if r_status=p_id then
            SELECT NVL((SELECT mem_name
                        FROM member
                        WHERE mem_id=p_id AND mem_pw=p_pw),'비밀번호가 틀립니다.') INTO msg
                  FROM dual;
        elsif r_status='-1' then
        msg:='아이디가 존재하지 않습니다.';
        end if;       
END;

        --if msg is not null and msg!='비밀번호가 틀립니다.' then
            --SELECT sub_cd, exam_no
                --FROM take_examination
                --WHERE mem_id =  p_id;

