package com.ch4;

import java.util.Random;
import java.util.Scanner;

public class nansu {
	

	public static void main(String[] args) {
		System.out.println("난수를 입력하세요.");
		
		Scanner scan = new Scanner(System.in);
         
         
		 Random r = new Random();
		 int nansu = r.nextInt(10);
		 
		 int i;
		 int chance;
		 for (chance=1;chance<6;chance++){{
			 
			 if(chance == 5) 
				 break;	 
		   }			 
			 for (i=0; i<10; i++) {
				 int a = scan.nextInt();
			 if(i == nansu ) {
				 System.out.println("정답입니다.");}
				 
				 else if (i < nansu) {
				
					 System.out.println("높여라");
				  }
				 else if (i > nansu) {
				
					 System.out.println("낮춰라");
				  }
			
					 
					 
				 }
	
				 }
		 System.out.println("넌 바보");
		 }}

	