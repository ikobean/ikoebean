테이블 동기화 처리

CREATE TABLE DEPT_COPY AS
SELECT * FROM DEPT



SELECT * FROM DEPT_COPY

CREATE OR REPLACE TRIGGER trg_deptBackup
AFTER INSERT OR UPDATE OR DELETE ON DEPT
FOR EACH ROW
BEGIN
    IF INSERTING THEN
     INSERT INTO DEPT_COPY(DEPTNO, DNAME, LOC)
     VALUES(:NEW.DEPTNO, :NEW.DNAME, :NEW.LOC);
      
    ELSIF UPDATING THEN
     UPDATE dept_copy
     SET dname= :old.dname, loc=:old.loc
     WHERE dept_copy.deptno = :old.deptno;
          
    ELSIF DELETING THEN
     DELETE FROM dept_copy
     WHERE dept_copy.deptno = :old.deptno;
     
     END IF;
END;


INSERT INTO dept VALUES (66,'전산과','서울')

ALTER trigger trg_test2 disABLE;

UPDATE DEPT
SET DNAME = '내복쓰' WHERE DEPTNO=66

DELETE FROM DEPT WHERE DEPTNO=66