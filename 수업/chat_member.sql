CREATE TABLE CHAT_MEMBER
(
mem_num number constraints cmember_pk primary key
,mem_id varchar2(10) not null
,mem_pw varchar2(10) not null
,mem_name varchar2(30) not null
,mem_nick varchar2(30) --닉네임
,mem_email varchar2(40)
,mem_hp varchar2(20)
,mem_birth varchar2(30)
,reg_date varchar2(30) --가입날짜
)

