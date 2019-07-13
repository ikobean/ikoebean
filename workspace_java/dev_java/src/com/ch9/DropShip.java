package com.ch9;

import com.ch10.Movable;

public class DropShip extends Unit implements Movable{

	@Override
	public void move(int x, int y) {
		System.out.println("dropship이"+x+","+y+"좌표로 이동하였다.");
	}
	
	//	{}가 있다는 것 만으로 구현하겠다는 뜻이다.
	
	/*
	 * 메소드 선언시 좌중괄호, 우중괄호가 있다는 것 만으로도 구현으로 본다.
	 * 선언이 아니다. 
	 * 선언은 ; 끝났을 때가 선언이다.
	 * 아래 메소드는 Movable 인터페이스에서 선언된 추상메소드를 구현한 메소드이다.
	 * 따라서 인터페이스 안에는 구현된 부분이 없다.
	 * 구현체 클래스는 Movable 이라는 인터페이스를 implements 한 클래스가 구현체 클래스인 것이다.
	 */
	
	void load() {
		//유닛을 태운다
	}
	void unload() {
		//유닛을 내린다
	}
	@Override
	void display() {
		System.out.println("나는 DropShip입니다.");
	}
	@Override
	public void back() {
		// TODO Auto-generated method stub
		
	}
}
