package com.quiz0529;

public class Question2 {
//메소드 오버 로딩
	/*
	 * 자바는 같은 이름의 메소드를 중복정의 가능
	 * 전제조건 - 반드시 메소드이름이 같을 때만 따짐.
	 */
	
	/**************************
	 * 파라미터의 갯수가 다르거나 타입이 다르면
	 * 리턴타입은 메소드오버로딩에 영향이 없다.
	 * 접근제한자가 있고 없고는 영향없다.
	 ****************************/
	
	 public void doit(String A) {
	 }
	 // void doit(String A) {
	 //} 불법
	 
	 public String doit(int y, int z) {  //String은 리턴타입!
	  return "a";
	 }
	 public double doit(int x) {
	 return 1.0;
	 }
	public static void main(String[] args) {
	
	}

}
