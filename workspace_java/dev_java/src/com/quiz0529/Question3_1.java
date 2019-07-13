package com.quiz0529;

public class Question3_1 {
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
	
	public Question3_1(){
		
	}
	//this는 반드시 맨 앞에
	public Question3_1(int age){
		this("이순신",20);
		this.age = age;
		System.out.println("파라미터 한개짜리 호출"); 
		//순서 바꾸면 안됨. 왜냐면  this가 먼저 쓰기로 약속돼있음
	}
	public Question3_1(String name, int age){
		System.out.println("파라미터 두개짜리 호출");
	}
	
	public static void main(String[] args) {
		Question3_1 q3_1 = new Question3_1(25);
		System.out.println(q3_1.age);
		//25가 출력되도록 코드를 수정해 보세요.
		
		
		
		
	}

}
