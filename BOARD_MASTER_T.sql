CREATE TABLE BOARD_MASTER_T
(
    BM_NO NUMBER(5) constraints board_mno_pk PRIMARY KEY
    ,BM_TITLE VARCHAR2(300) NOT NULL
    ,BM_WRITER VARCHAR2(30)
    ,BM_EMAIL VARCHAR2(50)
    ,BM_CONTENT VARCHAR2(4000)
    ,BM_HIT NUMBER(5) DEFAULT 0
    ,BM_DATE VARCHAR2(30)
    ,BM_GROUP NUMBER(5) DEFAULT 0
    ,BM_POS NUMBER(5) DEFAULT 0
    ,BM_STEP NUMBER(5) DEFAULT 0
    ,BM_PW VARCHAR2(10)
)

COMMIT;

DROP TABLE BOARD_MASTER_T

CREATE INDEX BM_GROUP ON BOARD_MASTER_T (BM_GROUP)

CREATE TABLE BOARD_SUB_T(
     BM_NO NUMBER(5) 
    ,BS_SEQ NUMBER(5)
    ,BS_FILE VARCHAR2(300)
    ,BS_SIZE NUMBER(9,2)
    ,constraints board_sub_pk primary key(bm_no, bs_seq)
)

--외래키 추가 방법
alter TABLE board_sub_t add constraints 
fr_bm_bs_bmno foreign key(bm_no) references board_master_t(bm_no);


--첨부파일이 없는 경우도 있으니까 아우터조인으로 가야함. 

SELECT bm.bm_title, bm.bm_date,  bm.bm_hit, bs.bs_file, bm.bm_writer
    from BOARD_MASTER_T bm, BOARD_SUB_T bs 
    where bm.bm_no = bs.bm_no(+)
    
--EX --자녀쪽에 붙여야 함

SELECT DEPT.deptno, ename from dept, emp
    WHERE DEPT.DEPTNO = EMP.DEPTNO(+)
    
edit BOARD_MASTER_T


    
edit BOARD_SUB_T




insert into board_master_t(bm_no, bm_title, bm_writer, bm_content
                                 , bm_pw, bm_date, bm_group, bm_pos, bm_step)
                        VALUES(seq_board_no.nextval, '내복이', '냥냥'
                                 ,'꾜꾜', '123' ,to_char(sysdate,'YYYY-MM-DD')
                                 ,0,0,0)
                                 
                                 SELECT * FROM BOARD_MASTER_T
                                 
INSERT INTO BOARD_SUB_T(bm_no, bs_seq, bs_file, bs_size)
VALUES (5,1,'LICENSE.DAT',15.4)

SELECT * FROM BOARD_SUB_T

