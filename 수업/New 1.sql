/* Formatted on 2019/06/13 오후 3:40:07 (QP5 v5.215.12089.38647) */
INSERT INTO mkaddrtb (id,
                      name,
                      hp,
                      gender,
                      birthday,
                      comments,
                      address,
                      regdate)
     VALUES ('YKS',
             '고명석',
             '01050450094',
             '1',
             '1989-12-25',
             '고교동창',
             '서울시  금천구 가산동 ',
             TO_CHAR (SYSDATE, 'yyyy-mm-dd'))
             
             
             
             INSERT INTO mkaddrtb(id, name, hp, gender,birthday  
      ,comments, address, regdate)  
    VALUES(?,?,?,?,?,?,? ,TO_CHAR(sysdate, 'yyyy-mm-dd') 