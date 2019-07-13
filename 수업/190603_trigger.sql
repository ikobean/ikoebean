한 테이블에 날짜로 선언된 컬럼이 있다고 가정했을 때 이 컬럼에 데이터는 항상
토요일과 일요일에만 입력되어야 한다고 했을 때 이것을 원천적으로 막을 수 있는 
방법이 있다.

트리거를 이용해서 UPDATE, INSERT, DELETE 시에 해당 데이터를 체크하면 된다.

CREATE OR REPLACE TRIGGER trg_test1
BEFORE
UPDATE OR DELETE OR INSERT ON dept
DECLARE
msg varchar2(100) := '';
BEGIN 
    IF INSERTING THEN 
      dbms_output.put_line('==> insert');
      END IF;
    IF UPDATING THEN 
      dbms_output.put_line('==> update');
      END IF;
    IF DELETING THEN 
      dbms_output.put_line('==> delete');
      END IF;
END;

DELETE FROM DEPT WHERE DEPTNO=55

ROLLBACK;

INSERT INTO DEPT VALUES (55,'총무부','SEOUL');

UPDATE DEPT SET LOC = '포항' WHERE DEPTNO=55 

INSERT INTO DEPT VALUES (56,'구매부','인천');

트리거의 변경
트리거의 상태를 비활성화 또는 활성화할 수 있다.

ALTER trigger  트리거명 disable|enable

ALTER trigger trg_test1 ENABLE;

INSERT INTO DEPT VALUES (58,'개발부','AMSTERDAM');

ROLLBACK;

ALTER trigger trg_test1 compile;

drop trigger trg_test1