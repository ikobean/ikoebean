package com.ch2;

import com.ch9.Car;

public class Sonata extends Car {

    int wheelNum = 4; //전역변수 = 그 사물의 고유명사, 쭉 유지되는 것들
    int speed = 0;
    String carColor = "white";
    
    
    void move(int i) { //지역변수. 지역변수는 반드시 초기화를 해야함.
    	speed = speed + 1;
    	System.out.println("지역변수 i는");
    
    	    }
    
    void stop() {
    	speed = speed - 1;
    }
 public static void main(String[] args) {
	 //insert here - move메소드 호출하기
	 Sonata mycar = new Sonata();
	//너 바퀴수 몇개니?
	 	 System.out.println(mycar.wheelNum);
         System.out.println(mycar.carColor);
         
      
  
	}

@Override
public void display() {
	// TODO Auto-generated method stub
	
}

}
