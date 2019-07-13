package com.ch2;

public class practice0507 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int earth = 68;
	//double moon = 0.17;
	
	//System.out.println("달에서의 몸무게"+ earth*moon);
	
	//double moon = 0.17; 이거는 왜 초기화가 안돼?
	
	int a = 17;
	int b = 100;
	int earth2 = 100;
	double moon = 0.0;
	
	System.out.println("달에서의 몸무게"+ earth2*a/b); //17
	//이 값은 earth2 곱하기 a 나누기 b가 된 것? 
	//운좋게 정수로 떨어져서 값이 나온 것
	System.out.println("달에서의 몸무게"+ earth2*(a/b)); //0
	// 
	
	
	//for 문과 변수를 사용하여 안녕하세요1-10꺄재 차례로 출력하는 프로그램 작성
//	String hi = "안녕하세요";

//	int x = 0;
//	for(x=0; x<=10; x=x+1) {
	//	x=x;
	//	System.out.println(hi + x);
	//★왜 이렇게 변수 선언을 많이 했을까? 최대한 간결하게 하자
	
//////////////////////////////////////////////////////////////	
		//for(초기화식; 조건식; 증감식) {수행문}
		
		int i;
		for(i=1; i<=10; i++){

		

		   System.out.println("안녕하세요" + i);	
	
	}
		
		int q;
		for (q=11; q<=20; q++) {
			
			System.out.println("반갑습니다"+q);
		}

	
		int earth_w = 68;
		double moon_w = 0;
		float gravity = 0.17f;
		
		System.out.println(earth_w*gravity);
        moon_w = earth_w*gravity;
        // = 은 equal이 아님! 대입 연산자야. 꼭 기억해!

		
		int abc = (int)3.14;
		System.out.println(abc);
		
		
				
		
	}}
