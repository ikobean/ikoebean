�� ���̺� ��¥�� ����� �÷��� �ִٰ� �������� �� �� �÷��� �����ʹ� �׻�
����ϰ� �Ͽ��Ͽ��� �ԷµǾ�� �Ѵٰ� ���� �� �̰��� ��õ������ ���� �� �ִ� 
����� �ִ�.

�������� �����͸� ������ �� �����ϴ�.

CREATE OR REPLACE TRIGGER trg_test2
BEFORE
UPDATE OR DELETE OR INSERT ON DEPT
BEGIN
    IF (TO_CHAR(SYSDATE, 'DY') ='��') THEN
     dbms_output.put_line('�������� �����͸� ������ �� �����ϴ�.');
     END IF;
END;

INSERT INTO DEPT VALUES(60,'�濵','SEOUL');

ROLLBACK;

SELECT SYSDATE ��¥ 
, TO_CHAR(SYSDATE, 'DY') ���� FROM DUAL


CREATE OR REPLACE TRIGGER trg_test2
BEFORE
UPDATE OR DELETE OR INSERT ON DEPT
BEGIN
    IF (TO_CHAR(SYSDATE, 'DY')IN ('��','ȭ','��','��','��')) THEN
     dbms_output.put_line('������ �����͸� ������ �� �����ϴ�.');
     RAISE_APPLICATION_ERROR(-20001,'������ �����͸� ������ �� �����ϴ�,');
     END IF;
END;


DELETE FROM DEPT WHERE DEPTNO=