CREATE OR REPLACE procedure proc_swDesign(rc_swd OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN rc_swd
    FOR SELECT d_no, sub_cd, question
              ,answer1, answer2, answer3, answer4
              ,d_point, dap
            FROM sw_design;            
END;
