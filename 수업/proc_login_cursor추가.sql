CREATE OR REPLACE PROCEDURE SCOTT.proc_login(p_id IN VARCHAR2, p_pw IN VARCHAR2, 
                                             msg out VARCHAR2, r_status OUT VARCHAR2
                                             ,rc_texam OUT sys_refcursor) 
IS   
BEGIN SELECT NVL((SELECT mem_id FROM member
            WHERE mem_id=p_id),'-1') into r_status
            FROM dual;
        if r_status=p_id then
            SELECT NVL((SELECT mem_name
                        FROM member
                        
                        WHERE mem_id=p_id AND mem_pw=p_pw),'비밀번호가 틀립니다.') INTO msg
                  FROM dual;
            open rc_texam
                for SELECT sub_cd, exam_no, exam_date, reg_date
                        FROM take_examination
                        WHERE mem_id=r_status;      
        elsif r_status='-1' then
        msg:='아이디가 존재하지 않습니다.';
        end if;       
       
END;
/


CREATE OR REPLACE PROCEDURE SCOTT.proc_login
(p_id IN varchar2, p_pw IN varchar2
, msg OUT varchar2, r_status OUT varchar2, rc_texam OUT sys_refcursor)
IS
BEGIN
     SELECT NVL((SELECT mem_id FROM member 
                 WHERE mem_id=p_id),'-1') into r_status
       FROM dual; 
   if r_status=p_id then
     SELECT NVL((SELECT mem_name
                  FROM member
                 WHERE mem_id=p_id AND mem_pw=p_pw),'비밀번호가 틀립니다.') into msg
       FROM dual;              
   elsif r_status='-1' then
    msg:='아이디가 존재하지 않습니다.';
   end if; 
   if p_id=r_status then
        open rc_texam
            for SELECT sub_cd, exam_no
                     , exam_date, reg_date
                  FROM take_examination
                 WHERE mem_id=r_status;
   end if;
END;
/