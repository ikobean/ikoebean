package com.ch8;

public class FatherSimulation {

	public static void main(String[] args) {
		Son myson2 = new Son();
		
		Son myson = new Son("멍멍");
		Father dad = new Father();
		
		myson.book= "성경책";
		
		
		System.out.println(myson.book);
		//기존에 가리키던 객체를 생성하기 위해서 null로 초기화한후
		myson=null; //기존에 참조하던 객체는 Candidate 상태로 빠짐
		//다시 생성하였음. 이 때 파라미터를 갖는 생성자를 호출함.
		//그러면 생성자 내부에서 전역변수  book이 다시 초기화됨.
		myson = new Son("oracle 프로그래밍");
		//출력해보면 성경책에서 오라클 프로그래밍으로 바뀐것을 확인할 수 있음.
		System.out.println(myson.book);
		
		myson.walk();
		
		System.out.println("=========[[오버라이딩 메소드]]==========");
		dad.walk();
		System.out.println("");		
		//insert here - 오버로딩 메소드 호출해보자
		System.out.println("=========[[오버로딩 메소드]]==========");
		dad.walk(3);
	}

}


