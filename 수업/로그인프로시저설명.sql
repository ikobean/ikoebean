���ν����� ����� ���� ������� �ʾ��� �� �������� ���� ���� �� �ִ�.
���ν����� ����ϸ� �ڹ��ڵ带 �� �ۼ��Ѵ�.

���ν����� ������� ������ ���ϰ��� �޾Ƽ� �ڹٷ� �ٽ� ó���ؾ� ��.

select nvl((select 1 from member
            where mem_id=p_id),-1)
            FROM dual;
            
            
            SELECT
                NVL((select mem_name||'�� ȯ���մϴ�.' FROM member
                    where mem_id=:mem_id
                    AND mem_pw =:mem_pw),'��й�ȣ�� Ʋ���ϴ�.')
                FROM DUAL
                
                
                DELETE FROM MEMBER WHERE MEM_ID='GGG'
                