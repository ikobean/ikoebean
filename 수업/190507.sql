오라클에서는 DML. DDL, DCL 세가지 언어를 지원
CREATE TABLE book()

DROP TABLE book()

SELECT문 : 조회할 때

SELECT book_no, book_title, author, publisher FROM book;

INSERT INTO book(book_no, book_title, author, publisher) 
        VALUES(1,'오라클 11g','이순신', '코스모');

INSERT INTO book(book_no, book_title, author, publisher) 
       VALUES(2,'자바프로그래밍입문','박은종','이지스퍼블리싱');

INSERT INTO book(book_no, book_title, author, publisher) 
        VALUES(3,'html','이순신', '코스모');
        
        DROP TABLE BOOK_
        
INSERT INTO book(book_no, book_title, author, publisher)
        VALUES(4, '아이스아메리카노','바리스타','502');
        
SELECT * FROM MEMBER;

INSERT INTO member(name, hp, address, sex, id)
 VALUES('경애', 01055559999, '경기도','여',1958);
 
 SELECT * FROM MEMBER;
 
 DELETE FROM BOOK WHERE book_no=1 ;
 
SELECT * FROM book WHERE book_title = '자바프로그래밍입문';