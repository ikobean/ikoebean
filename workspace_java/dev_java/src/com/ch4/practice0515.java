package com.ch4;

import java.util.Random;
import java.util.Scanner;

public class practice0515 {
/* 0부터 9까지의 난수를 채번하여
 * 그 숫자를 맞추는 게임을 구현해 보세요.
 * 
 * 기회는 5번까지만 제공하고
 * 5번 동안 맞추지 못하면 넌 바보라고 출력하시오.
 * 
 * 힌트는 낮춰라, 높여라로 한다.
 * 
 * random r = new random();
 * int nansu = r.nextInt(10);
 * 
 */
	public static void main(String[] args) {
	
		System.out.println("난수를 입력하세요.");
		
		Scanner scan = new Scanner(System.in);
         
         
		 Random r = new Random();
		 int nansu = r.nextInt(10);
		 
		 int i ;
		 int chance;
		 for (chance=1;chance<5;chance++){{
			 System.out.println("0~9사이 정수만 입력하세요.");
		 }
			
			 for (i=0; i<10; i++) {
				 
			 if(i == nansu ) {
				 System.out.println("정답입니다.");}
				 
				 else if (i < nansu) {
					 int no1 = scan.nextInt();
					 System.out.println("높여라");
				  }
				 else if (i > nansu) {
					 int no2 = scan.nextInt();
					 System.out.println("낮춰라");
				  }
		
				 else {
					 System.out.println("넌 바보");
					 
					 
				 }
					
				 }}
			 
		 }}

	
	 


		
	







