package com.quiz0527;

public class Hello {

	
		 String title;
		 int value;
		 
		 public Hello() { //디폴트생성자
		 title += " World";
		 }
		 
		 public Hello(int value) { //파라미터가 있는 생성자
		 this.value = value;
		 title = "Hello";
		 Hello();  ////????
		 }
		 
		 private void Hello() {
			// TODO Auto-generated method stub
			
			 
		}

		public static void main(String[] args) {
		 Hello c = new Hello(5);
		 System.out.println(c.title);
	
	
}}
