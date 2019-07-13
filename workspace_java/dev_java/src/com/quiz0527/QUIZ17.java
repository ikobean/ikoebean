package com.quiz0527;

public class QUIZ17 {

	public static void go(short n) {System.out.println("short"); }
	 public static void go(Short n) {System.out.println("SHORT");}
	 public static void go(Long n) {System.out.println(" LONG"); }
	 public static void go(long n) {System.out.println(" long"); }
	 //public static void go(int n) {System.out.println(" INT"); }
	 
	 
	 
	 public static void main(String [] args) {
	 Short y= 6;  // ---SHORT
	 int z=7;    //
	 
	 go(y);  
	 go(z);  
	
		/*아하...Short과 short은 다르다.
		 * short는 원시형 타입이고
		 * Short는 wrapper 클래스.
		 * 
		 */
	

	}

}
