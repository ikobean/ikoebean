����Ŭ������ DML. DDL, DCL ������ �� ����
CREATE TABLE book()

DROP TABLE book()

SELECT�� : ��ȸ�� ��

SELECT book_no, book_title, author, publisher FROM book;

INSERT INTO book(book_no, book_title, author, publisher) 
        VALUES(1,'����Ŭ 11g','�̼���', '�ڽ���');

INSERT INTO book(book_no, book_title, author, publisher) 
       VALUES(2,'�ڹ����α׷����Թ�','������','�������ۺ���');

INSERT INTO book(book_no, book_title, author, publisher) 
        VALUES(3,'html','�̼���', '�ڽ���');
        
        DROP TABLE BOOK_
        
INSERT INTO book(book_no, book_title, author, publisher)
        VALUES(4, '���̽��Ƹ޸�ī��','�ٸ���Ÿ','502');
        
SELECT * FROM MEMBER;

INSERT INTO member(name, hp, address, sex, id)
 VALUES('���', 01055559999, '��⵵','��',1958);
 
 SELECT * FROM MEMBER;
 
 DELETE FROM BOOK WHERE book_no=1 ;
 
SELECT * FROM book WHERE book_title = '�ڹ����α׷����Թ�';