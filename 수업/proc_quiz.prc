EXEC proc_gugudan(1, 3);

연습문제 1 - INSERT문 회원가입, 주문등록, 배송접수

프로시저명 - proc_empINSERT(8가지)
출력메세지 - XXX사원의 정보를 등록하였습니다.

커밋처리도 하자. (업데이트)


CREATE OR REPLACE PROCEDURE proc_empINSERT(empno in number,  ename in varchar2, job in  varchar2
                                            , mgr in number, hiredate in date, sal in number
                                            , comm in number, deptno in number, msg out  varchar2))
IS
BEGIN
     INSERT INTO emp
     values(12345,'내복이','KING',56789,'20190921',9999,5678,1234)
    msg:=  '사원의 정보를 등록하였습니다.';
END;
