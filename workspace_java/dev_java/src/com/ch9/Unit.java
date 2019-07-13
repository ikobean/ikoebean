package com.ch9;

//public > protected > friendly > private 접근제어자 순서
//protected & friendly - 둘 다 같은 패키지 안에서만 가능
//protected - 상속관계에 있으면 사용 가능

public abstract class Unit {
	int x,y; //추상클래스 안에 멤버변수 ok
	
	public Unit() {
		
		System.out.println("Unit 디폴트 생성자 호출 성공");
		
	}
	abstract void display();
	
	void stop() {}; 					//추상 메소드
}


/*
 * 오버라이딩은 반드시 부모 메소드와 동일해야함.(파라미터, 리턴타입)
 * 단 접근제한자는 더 넓은 것은 가능
 * 
 */




