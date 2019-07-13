package com.quiz0529;

public class Question04 {
	 public void testIfA() {
		 if(testIfB("True")) { //==if(true)
		 System.out.println("True");
		 } else {
		 System.out.println("Not true");
		 }
		 }
		 public Boolean testIfB(String str) {
		 return Boolean.valueOf(str); //스트링을 받아서 불리언 타입으로 바꿔주는 거.
		 }
		 /*non static 타입이니까 인스턴스 먼저 해볼게
		  * 17-18-19-4-5-6[True가 출력됨]
		  */
	public static void main(String[] args) {
		Question04 q4 = new Question04();
		q4.testIfA();
	}

}
/*************************************
 * 
 * 래퍼클래스 기억. 조건문에 불리언 타입만 쓸 수 있따
 * 
 *************************************/

