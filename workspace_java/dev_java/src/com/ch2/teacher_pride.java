package com.ch2;
/* 메소드안에 메소드 선언은 불가하다
 * 메소드 안에서 다른 메소드 호출은 가능함.
 * 예) 평균을 구한다. 총점을 구하는 메소드를 선언할 수 있다.
 * 사용자가 입력하는 점수는 파라미터로 선언함.
 * 총점을 계산하면 그 결과는 리턴타입으로 넘긴다.
 * 사용자와 프로그램 사이의 소통
 * 
 */

public class teacher_pride {
    //선언부 - 전역변수 선언 - 초기화 생략 가능. 인스턴스화를 하면 다른 집에서도 사용 가능해요.
	//vt1.i -> 전역변수
	//전역변수는 다른 메소드 영역에서도 사용할 수 있다.
	//전역변수는 생성자가 대신 초기화를 해주니까!
	//지역변수는 생성자가 초기화를 할 수 없다.
	String carName=null;	
	    //메소드 선언하기1
	int speedUp() {
		//insert here - 전변 호출하기
		carName = "2019년형 pride";
		int speed = 0; //지역변수 초기화
		speed = speed + 1;
		return speed;
		
	}
	//메소드 선언하기2
	void volumeDown(int noise) {
	//메소드 선언시 리턴타입 자리에 void라고 쓰면 그 메소드 안에 return 예약어를 안쓴다.	
		int n = 0;
		for (n=1; n<9; n=n+1) {
			noise = n + 1;
		
		}
		System.out.println(noise);	

	}

		
	
	
	public static void main(String[] args) {
      teacher_pride myCar= new teacher_pride();
      myCar.speedUp();
      System.out.println(myCar.carName);
      myCar.volumeDown(0);
      
      
      

      
      
      
      
      
      
      
   
           
      
      
		
		
		
		
	}

}
