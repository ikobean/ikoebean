����
���̵� �ߺ��˻縦 ����ڰ� ���ϰ� �ִ�.
�ߺ��˻��ϴ� SELECT ���� �ۼ��� ���ÿ�.

--���̵� �������� ������ ��ȸ����� ����.
--�ο찡 ����

SELECT MEM_NAME �̸�
FROM MEMBER
WHERE MEM_ID =:user_id

--   =:�� �����׽�Ʈ�ϴ°�

--�׷��Լ� ����ϴ� ��쿡�� ��ȸ����� ���� �ϴ��� ������ �ִ�.
--��ü����ó�� �ϹǷ� �ӵ��� ������. 
--�Ⱦ� �� ������ �Ⱦ��°� ����!
--�׷��� ������ �ٲ۰Ŵ�~ ��־�? �� �ƴϰ� �����ϴ�?


SELECT count(MEM_NAME) ���
FROM MEMBER
WHERE MEM_ZIPCODE =:user_zipcode

select count(mem_name) ���
from member
where mem_id=:user_id


���̵� �����ϴ�?

SELECT 1 FROM dual
 WHERE EXISTS (SELECT mem_name FROM member 
               WHERE mem_id =: user_id
               AND rownum=1
               )
               
               rownum = ��ž���/ ���� ���� ���