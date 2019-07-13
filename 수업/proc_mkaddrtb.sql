CREATE OR REPLACE PROCEDURE proc_mkaddrtb(ref_addr OUT SYS_REFCURSOR)
IS 
BEGIN
    OPEN ref_addr
    FOR SELECT id,name,address,hp
        FROM   mkaddrtb;
END;