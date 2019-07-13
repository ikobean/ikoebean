package com.baseball;

public class ClassB {

	int b;
	
	ClassA classa = null;
	
	public ClassB() {
		
	}
	
	public ClassB(ClassA classa) {
		System.out.println("B생성자 호출 성공");
		this.classa=classa; 
		
	}

	public void methodB() {
		//생성자의 파라미터로 넘어온 a변수를 전역변수와 초기화를 
		//14번라인에서 했으므로 22번 정상 호출
		
		System.out.println("나는 메소드 B");
		classa.methodA();
		
	}
}


