package com.ch7;

public class 연습장 {

	public static void main(String[] args) {
		Rent bVO = new Rent();  //bVO는 주소번지!! 객체!!
		Rent bVOS[] = new Rent[3];	
		
				
		for(Rent bVO2:bVOS) {   //bVO2는 초기화 안해도 되는거?? 변수 선언만 해도 돼? 된다! 왜냐면 따로 초기화와 종료 조건이 없기 떄문에.
		System.out.println(bVO2);
		}
	    for(int i =0; i<bVOS.length;i++) {
	    	System.out.println(bVOS[i]);
	    }
	      //bVOS[0].book_title(); //불법 PRIVATE으로 선언한 건 못씀 . 그래서 getter setter 만들어줌
	     // String book_title= bVOS[0].getBook_title();
	      //System.out.println(book_title);
	    
	      bVOS[0]=bVO; //bVOS==풍선줄, [0]==풍선줄, bVO==풍선
	                   //그래서 밑에서 bVOS로 호출을 해야 바뀌는 값을 호출 가능
	      
	      
	      bVO.setBook_title("자바의 정석"); //BVO로 갈거야! 그리고 북타이틀에 자바의 정석을 쓸거야.
	      bVO.setBook_price(35000);
	      bVO.setBook_author("이승우");
	      

	      System.out.println(bVO);
	      
	      
	      
	      
	      if(bVOS[0]!=null) {
	    	  System.out.println(bVOS[0].getBook_title()+bVOS[0].getBook_price()+bVOS[0].getBook_author());
	      }
	      else {
	    	  System.out.println("bVOS[0]안에 객체가 생성되지 않았음.");
	      }
	  
		}
	}




