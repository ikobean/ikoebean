package com.ch7;

public class ReturnTypeA {

	String[] methodC() {
		String home [] = {"가고싶다"};
		return home;
		
	}
	
	String[] methodZ() {
		String color[] = new String[5]; //문자를 담을 다섯 공간을 만들겠다
		color[0] = "white";
		color[1] = "orange";
		for(int i=0; i<color.length;i++) {			
			}
		return color;
		
	}
	
	
	 int methoda() {
		 int i = 1;
		 return i;
	 }
	 
	int[] methodD(){
		int deptno [] = {10,20,30};
		return deptno;
	}
	

	public static void main(String[] args) {
		ReturnTypeA rta = new ReturnTypeA();
		
		String color[] = rta.methodZ();
		for(String abc:color) {
			System.out.println(abc);
		 } 
		
		
		
		
		int deptno[] = rta.methodD();
			
		int i = rta.methoda();
		
		String home[] = rta.methodC();
		for(String ppoppo:home) {
		
			System.out.println(ppoppo);
		}
		//지변으로 선언된 배열도 다른 메소드 영역에서 사용이 가능하다.
		//원래 지역변수는 메소드 바깥으로 나갈 수 없지만  *리턴타입을 활용해서* 다른 메소드에서 부를 수 있음! 
		//리턴타입의 역할
		for(int dno:deptno) {
			System.out.println(dno);
		}
		System.out.println(i);
	}

	
}




