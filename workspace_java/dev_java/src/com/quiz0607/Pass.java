package com.quiz0607;

public class Pass {
	int x ;
	public static void main(String []args) {
		
		int x = 5;
		Pass p = new Pass();
		p.x=3;
		p.doStuff(p); //호출 
		p.doStuff(7);
		
		System.out.println("main x = "+ x);  }

	
	public void doStuff(Pass p) {
		System.out.println(" doStuff x = "+ ++p.x);
		
	}
	void doStuff(int x) {
			System.out.println(" doStuffff x = "+ x++);
			
			System.out.println(x);
			
 }
	

		
 }

