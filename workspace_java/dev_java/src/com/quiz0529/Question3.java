package com.quiz0529;

public class Question3 {
/****************생성자와 this*****************
 * 
 * this : 자기 자신의 주소번지
 * this() : 자기자신 생성자 호출
 * 생성자도 메소드 오버로딩의 규칙을 따른다.
 * 리턴타입이 있다면 생성자가 아님!!!!! 
 * 
 ******************************************/
	String name ="김유신";
	int age=40;
	
	public Question3(){
		
	}
	//this는 반드시 맨 앞에
	public Question3(int age){
		this("이순신",20);
		System.out.println("파라미터 한개짜리 호출"); 
		//순서 바꾸면 안됨. 왜냐면  this가 먼저 쓰기로 약속돼있음
	}
	public Question3(String name, int age){
		System.out.println("파라미터 두개짜리 호출");
	}
	
	public static void main(String[] args) {
		Question3 a = new Question3(20);
		new Question3(25); //변수 선언을 하지 않았으니까 접근이 불가함. 
		Question3 q3 = new Question3(25); //변수가 있어서 접근이 가능함
		//위 생성자를 호출했을 때 전역변수 age가 초기화 된다|안된다
		//초기화가 된다면 25가 출력될 것이고
		//초기화가 안된다면 40일 것이다.
		System.out.println(new Question3(25).age); //변수명이 없어서 재사용불가함.
		//위 상태에서 실행하면 객체는 몇개 생성될까요? -3개가 생성됨.
		
		
		
	}

}
