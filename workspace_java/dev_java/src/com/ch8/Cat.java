package com.ch8;

public class Cat {
	String name = "내복이";
	String name2 = "사랑해";
	String g=null;
	
 public Cat() {
	 System.out.println("Cat 디폴트 생성자 호출");
 }
 
 public Cat(String name) {
	 this.name = name;
	 System.out.println(this.name);
	 
 }
 
 public void walk() {
	 System.out.println("내복이의 걸음걸이는 귀엽지요오");
 }
 public void walk(int i) {
	System.out.println("허버허버 귀여운 int");
	
 }
	
 public String walk(String g) {
	 g = "간식을 주세요 간식간식";
			 return g;
 }
 
}
