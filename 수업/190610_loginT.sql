SELECT 1 FROM member WHERE mem_id=:p_id

SELECT NvL((SELECT 1 FROM member
            WHERE mem_id=:p_id),-1) into r_status
            FROM dual           
            
             
CREATE OR REPLACE PROCEDURE proc_login_t          
BEGIN SELECT NvL((SELECT 1 FROM member
            WHERE mem_id=:p_id),-1) into r_status
            FROM dual;
        if r_status=1 then
            select nvl((select mem_name||'�� ȯ���մϴ�.'
                        FROM member
                        WHERE mem_id=p_id AND mem_pw=p_pw),'��й�ȣ�� Ʋ���ϴ�.') INTO msg
                  FROM dual;
        elsif r_status=-1 then
        msg:='���̵� �������� �ʽ��ϴ�.'
end if;
END;

            