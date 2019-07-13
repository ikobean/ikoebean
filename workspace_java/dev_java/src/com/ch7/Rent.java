package com.ch7;
//데이터만 담는 타입
//VO = Value Object 데이터만 담겠따~

//도서에 대한 젇보를 담을 수 있는 클래스임. 다른 기능은 없어
//쓰기와 읽기
public class Rent {
   private String book_title = null;    //도서명
   private int    book_price = 0;    //도서가격
   private String book_author = null;   //저자
   
   
       
   
   
   //세터를 쓰지 않고 초기화  할 수 있다 . 생성자로!
   //디폴트 생성자 만들어 준 이유- 생성자가 하나라도 있으면 제공 안 됨.
   //제공되는 생성자는 디폴트 생성자 뿐이다.
   public Rent(){}
   
   
   public Rent(String book_title, int book_price, String book_author) {
	   this.book_title=book_title;
	   this.book_price=book_price;
	   this.book_author=book_author;
			  
   }
   //getter는 파라미터 필요 없음. 리턴값만 필요! 있는 걸 꺼내오는데 왜
public String getBook_title() {
	return book_title;
}
public void setBook_title(String book_title) {
	this.book_title = book_title;
}
public int getBook_price() {
	return book_price;
}
public void setBook_price(int book_price) {
	this.book_price = book_price;
}
public String getBook_author() {
	return book_author;
}
public void setBook_author(String book_author) {
	this.book_author = book_author;
}
   
}


