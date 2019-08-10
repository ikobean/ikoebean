CREATE TABLE online_subject(
sub_cd number(4) constraints subject_cd_pk primary key
,sub_name varchar2(30) not null
,sub_time number(5) default 0
,sub_cutline number(5) default 0
)

create table sw_design(
d_no number(4) constraints design_no_pk primary key
,sub_cd  number(4)
,question varchar2(500)
,answer1 varchar2(1000)
,answer2 varchar2(1000)
,answer3 varchar2(1000)
,answer4 varchar2(1000)
,d_point number(3)
,constraints subject_design_fk foreign key(sub_cd) REFERENCES online_subject(sub_cd) on delete cascade
)


drop table take_examination

create table take_examination(
exam_no varchar2(10) constraints take_exam_pk primary key
,mem_id varchar2(4)
,sub_cd number(4)
,exam_date varchar2(30)
,get_point number(3)
,is_pass varchar2(1)
,s_time varchar2(30)
,e_time varchar2(30)
,exam_fee number(7)
,fee_date varchar2(30)
,is_payment varchar2(1)
,exam_chasi number(2)
,constraint member_take_fk foreign key(mem_id)
references member(mem_id) on delete cascade
,constraint subject_take_fk foreign key(sub_cd)
references online_subject(sub_cd) on delete cascade
)