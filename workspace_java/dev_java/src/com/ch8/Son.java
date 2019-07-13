package com.ch8;

public class Son extends Father {

	/*파라미터가 있는 생성자가 없으면 문법에러가 난다. 오버라이딩! 
	* 기준이 아빠껀데 아빠꺼의 원형이랑 같아야해~~~
	*
	*/
	//생성자는 메소드 오버로딩의 규칙을 준수한다.
	
	String book = "냥냥";
	 public Son() {
		 System.out.println("Son 디폴트 생성자 호출");
	 }
	 public Son(String book) {
		 this.book= book;
	 }
	 
	 @Override
	 public void walk() {
		 System.out.println("아들도 걸어요~~~오예~~");
	 }
	 public void walk(int i) {
		 System.out.println();
	 }
	 
}

//오버라이딩은 같을 때 
//오버로딩은  다를 떄