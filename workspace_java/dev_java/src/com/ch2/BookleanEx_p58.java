package com.ch2;

public class BookleanEx_p58 {
	/*
	 *아래코드는 메소드를 선언하는 코드임.
	 *메소드를 선언할 때 파라미터 자리에 변수를 선언할 수도 있음.
	 *이 메소드에서 선언한 변수 이름은 isOK이고 타입은 boolean 타입으로 선언함.
	 *네소드를 선언할 때는 아래와 같이 파라미터(매개변수)를 추가할 수 있음
	 *파라미터 자리에는 사용자가 입력한 값을 받는 변수가 되는 거임.
	 *선언한 메소드는 호출할 수 있음.
	 *클래스 안에서 어디서든 호출할 수 있음.
	 *단, 메소드 안에서만 가능함.
	 *메소드 밖에서는 호출할 수 없음.
	 *main 메소드에서 호출한 이유는 메인 메소드가 entry point이기 때문임.
	 *클래스 안에 작성된 코드 중에서 가장 먼저 실행되는 코드임.
	 *다른 코드는 호출하기 전까지는 가지고는 있지만 실행은 절대 안됨.
	 *실행하도록 하려면 반드시 메소드를 호출해야 됨.
	 *호출할 때 주의사항이 있음.
	 *반드시 파라미터의 갯수와 타입을 꼬오옥 맞추어야 됨.
	 *메인 메소드에서 if문을 사용한 이유는 boolean 타입을 언제 사용하는 것인지 보여주는 것
	 *if문은 조건을 만족했을 때 좌중괄호와 우중괄호 안에 있는 코드를 실행함.
	 *만일 거짓이라면 그 안에 있는 코드는 실행 기회를 갖지 못함.
	 *클래스 안에 다른 코드들을 얼마든지 작성할 수는 있지만 가지고 있다고 해서 모두 다 실행되는 것은 아님.
	 *반드시 불러주어야 실행되는 것임.
	 *
	 */
  static void methodA(boolean abc) { //boolean isOK 변수 선언한 것
	  System.out.println(abc);
	  
}
  
public static void main(String[] args) {
	
	methodA(4<3);
	 methodB(경애, 25)
	
	
			//if(1=1) 불법
			if(1==1) //합법 괄호 안에 boolean 타입이 온다.
			{	System.out.println("참"); //1==3이면 코드가 실행이 안됨.

			}}


 
 public static void methodB( String S, int age) {
	 System.out.println("안녕하세요");
	 System.out.println(S, age);
	 
	 

 
 
 } 
}
 


