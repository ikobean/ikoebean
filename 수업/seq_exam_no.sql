SELECT seq_exam_no.nextval FROM dual

SELECT TO_cHAR(sysdate,'YY'||'MM'||'DD')
    FROM dual

SELECT LPAD(seq_exam_no.nextval,4,0) exam_no
    FROM dual
    
    SELECT TO_cHAR(sysdate,'YY'||'MM'||'DD')
    ||LPAD(seq_exam_no.nextval,4,0) exam_no
    From dual
    

 DROP SEQUENCE seq_exam_no;

    SELECT sub_cd, sub_name
        FROM online_subject
