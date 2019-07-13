package com.quiz0527;import oracle.net.aso.s;

public class QUIZ14 {

	
	public String makinStrings() {
		
		String s = "Fred";
		 s = s + "47";  //s=”Fred47”
		 s = s.substring(2, 5);  //s=”ed4”
		 s = s.toUpperCase();  //s=”ED4”
		 return s.toString();
		 

		
		
	}
	
	
	
	public static void main(String[] args) {
     QUIZ14 A = new QUIZ14();
     A.makinStrings();
     System.out.println(A.makinStrings());

	}

}
