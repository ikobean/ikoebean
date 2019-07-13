CREATE OR REPLACE PROCEDURE proc_gugudan(dan IN number, i IN number)
--파라미터 변수는 초기화 불가함.
IS
    dan2 number(5);
    i2 number(2);
BEGIN
    dan2 :=2;
    i2   :=1;
    FOR dan2 IN 2..9 LOOP
    FOR i2   IN 1..9 LOOP
        DBMS_OUTPUT.PUT_LINE(DAN2||'*'||I2||'='||(DAN2*I2));
        END LOOP;
    END LOOP;
END;