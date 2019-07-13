package com.quiz0529;

public class Question05 {

	public static void main(String[] args) {
		
		 Integer i = new Integer(1) + new Integer(2);
		 switch(i) {
		 case 3: System.out.println("three"); break;
		 default: System.out.println("other"); break;
		 }
		 
		 Question05 q5 = new Question05();
		 int b = 10;
		 Integer b2 = new Integer(10);
		 b =b2;
		 System.out.println(b); //오토박싱
		 
		 
		 }
	}


