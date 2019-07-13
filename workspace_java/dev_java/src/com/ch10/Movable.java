package com.ch10;
/*
 * 추상클래스보다 더 추상적이다.
 */

public interface Movable  {

	//public Movable() {} 생성자 X
	
	//public void back() {} 일반메소드 X
	
	public void back(); //abstract 생략해도 됨. 인터페이스는 100% 추상메소드이기 때문에.
	
	final int i=0;
	
	int a = 1;
	


	public abstract void move(int x,int y) ;
	
	
}
