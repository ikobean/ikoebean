package com.ch4;

public class Fibonacci {


	

	public static void main(String[] args) {
 
		int a1 = 1; //a1
		System.out.println("a1은 " +  a1 + "입니다.");
		int a2 = 1;
		System.out.println("a2은 " +  a1 + "입니다.");
		
		for(int a = 1; a < 9 ; a++) {
		       int next = a1 + a2;
		          // next2 = a2+ next;
		           //next3 = next + next2;
		           a1 = a2;
		           a2 = next;
		           
		System.out.println("a"+(a+2)+"는 "+next+" 입니다");           
		    	   	    
		}
		
		
		
	}

}


/*



*/