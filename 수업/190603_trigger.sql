�� ���̺� ��¥�� ����� �÷��� �ִٰ� �������� �� �� �÷��� �����ʹ� �׻�
����ϰ� �Ͽ��Ͽ��� �ԷµǾ�� �Ѵٰ� ���� �� �̰��� ��õ������ ���� �� �ִ� 
����� �ִ�.

Ʈ���Ÿ� �̿��ؼ� UPDATE, INSERT, DELETE �ÿ� �ش� �����͸� üũ�ϸ� �ȴ�.

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

INSERT INTO DEPT VALUES (55,'�ѹ���','SEOUL');

UPDATE DEPT SET LOC = '����' WHERE DEPTNO=55 

INSERT INTO DEPT VALUES (56,'���ź�','��õ');

Ʈ������ ����
Ʈ������ ���¸� ��Ȱ��ȭ �Ǵ� Ȱ��ȭ�� �� �ִ�.

ALTER trigger  Ʈ���Ÿ� disable|enable

ALTER trigger trg_test1 ENABLE;

INSERT INTO DEPT VALUES (58,'���ߺ�','AMSTERDAM');

ROLLBACK;

ALTER trigger trg_test1 compile;

drop trigger trg_test1