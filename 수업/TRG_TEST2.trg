한 테이블에 날짜로 선언된 컬럼이 있다고 가정했을 때 이 컬럼에 데이터는 항상
토요일과 일요일에만 입력되어야 한다고 했을 때 이것을 원천적으로 막을 수 있는 
방법이 있다.

월요일은 데이터를 수정할 수 없습니다.

CREATE OR REPLACE TRIGGER trg_test2
BEFORE
UPDATE OR DELETE OR INSERT ON DEPT
BEGIN
    IF (TO_CHAR(SYSDATE, 'DY') ='월') THEN
     dbms_output.put_line('월요일은 데이터를 수정할 수 없습니다.');
     END IF;
END;

INSERT INTO DEPT VALUES(60,'경영','SEOUL');

ROLLBACK;

SELECT SYSDATE 날짜 
, TO_CHAR(SYSDATE, 'DY') 요일 FROM DUAL


CREATE OR REPLACE TRIGGER trg_test2
BEFORE
UPDATE OR DELETE OR INSERT ON DEPT
BEGIN
    IF (TO_CHAR(SYSDATE, 'DY')IN ('월','화','수','목','금')) THEN
     dbms_output.put_line('오늘은 데이터를 수정할 수 없습니다.');
     RAISE_APPLICATION_ERROR(-20001,'오늘은 데이터를 수정할 수 없습니다,');
     END IF;
END;


DELETE FROM DEPT WHERE DEPTNO=