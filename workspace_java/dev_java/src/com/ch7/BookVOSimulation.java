package com.ch7;

public class BookVOSimulation {

	public static void main(String[] args) {
	Rent bVO = new Rent();  //책정보를 하나만 담을 수 있다. //렌트 클래스를 쓰기 위한 인스턴스화
	//방이 3개, 그 안에 있는 건 - null	
	Rent bVOS[] = new Rent[3];	//배열 선언, 초기화
	
	for(Rent bVO2:bVOS) {   
	System.out.println(bVO2);
	}
	
    for(int i =0; i<bVOS.length;i++) {
    	System.out.println(bVOS[i]);
    }
      //bVOS[0].book_title(); //불법 PRIVATE으로 선언한 건 못씀 . 그래서 getter setter 만들어줌
     // String book_title= bVOS[0].getBook_title();
      //System.out.println(book_title);
      bVOS[0]=bVO;
      bVO.setBook_title("자바의 정석");
      bVO.setBook_price(35000);
      bVO.setBook_author("이승우");
      
    
      if(bVOS[0]!=null) {
    	  System.out.println(bVOS[0].getBook_title()+bVOS[0].getBook_price()+bVOS[0].getBook_author());
      }
      else {
    	  System.out.println("bVOS[0]안에 객체가 생성되지 않았음.");
      }
  
	}
}






