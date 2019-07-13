package com.ch5;

public class TVSimulation {
    
	public static void main(String[] args) {
      TV myTV = new TV();        //객체주입
      TV herTV = new TV();      //객체주입 인스턴스화
     // TV hisTV = new TV();      //객체주입
      
      
      //TV gnomTV = null;
      
      TV gnomTV = new TV(); //디폴트 생성자
      
      gnomTV.onoff = true;  
      //이렇게 써서 초기화 할거를 밑에꺼처럼 쓰면 한방에 할 수 있음
      TV hisTV = new TV(false); //파라미터가 있는 생성자 호출
      System.out.println(gnomTV.onoff);
          
     //himTV=null;       //초기화
      
      TV himTV = new TV(true);
      
      
      //파라미터가 있는 생성자 호출
      
      System.out.println("그의 TV는 현재 켜진 상태인가요?" + himTV.onoff);
      //flase 나오는 이유. TV에서 초기화가 안되어 있기 때문에.
      
      himTV.onoff = true;
      System.out.println("그의 TV는 현재 켜진 상태인가요?"+himTV.onoff);

      
      

	}

	
}




