package com.ch3;

public class QUIZ {

	public static void main(String[] args) {
		
			 int i = 1;
			 System.out.println("i:" +1);
			 int j = i++;  
			 System.out.println("i:" + 2 +"j: " +1); //1
			 /*
			  * |(OR 연산자)가 한개이든 두개이든 실행문이 실행되고 안되고는 동일하다.
			  * | 연산자가 한개이든 두개이든 실행문은 무조건 실행된다.
			  * 다른 것은 한 개일 때는 두번 째 조건을 무조건 따진다.
			  * 두 번째 조건에서 증감연산자가 있게 되면 변수 i나 변수 j값에 영향을 미친다.			   
			  */
			 if((i == ++j) | (i++ == j)) {
			 i += j;
			 }
			 System.out.println("i = " + i);
			 
			
		/*	What is the result? E
			A. i = 1
			B. i = 2
			C. i = 3
			D. i = 4
			E. i = 5
			F. Compilation fails. */

	}

}
