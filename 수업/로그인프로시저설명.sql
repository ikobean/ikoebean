프로시저를 사용할 때와 사용하지 않았을 때 차이점에 대해 말할 수 있다.
프로시저를 사용하면 자바코드를 덜 작성한다.

프로시저를 사용하지 않으면 리턴값을 받아서 자바로 다시 처리해야 함.

select nvl((select 1 from member
            where mem_id=p_id),-1)
            FROM dual;
            
            
            SELECT
                NVL((select mem_name||'님 환영합니다.' FROM member
                    where mem_id=:mem_id
                    AND mem_pw =:mem_pw),'비밀번호가 틀립니다.')
                FROM DUAL
                
                
                DELETE FROM MEMBER WHERE MEM_ID='GGG'
                