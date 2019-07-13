package com.baseball;

public class ClassA {
	
	int a;
	//메소드B를 클래스 A에서 호출할 수 있다.
	ClassB classb = new ClassB(this);
	
	public ClassA() {
		classb.methodB();
	}
	public void methodA() {
		System.out.println("나는 메소드 A");
	}
	public static void main(String arg[]) {
		ClassA a = new ClassA();
		a.methodA();
	}
}





