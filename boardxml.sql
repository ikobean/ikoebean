select bm_title, bm_writer, bm_date, bm_file, bm_hit
        from (
               select rownum rno, bm.bm_title, bm.bm_writer,bm.bm_group, bm.bm_step
                from board_master_t bm, board_sub_t bs
               where bm.bm_no = bs.bm_no(+)
               order by bm_group desc, bm_step asc
               ) 
       where rno>=:start and rno<=:end
       
       select SEQ_BOARD_NO.nextval from dual
       
       select seq_board_no.currval from dual
       
       edit board_master_t
       
       select /*+index_desc(board_master_t board_mno_pk) */ bm_no from board_master_t
       where rownum=1
       
       select nvl((select /*+index_desc(board_master_t board_mno_pk) */bm_no from board_master_t
       where rownum=1),0)+1 bm_no
       from dual
       
       
   select nvl((select /*+index_desc(board_master_t i_group) */ bm_no from board_master_t
       where rownum=1 and bm_group>0),0)+1 bm_group
       from dual
       
x       create index i_group on board_master_t(bm_group)

update board_master_t
     set bm_step = bm_step+1
     where bm_group = 45
     and bm_step 화면에서 가져온 step 값