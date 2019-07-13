package com.ch3;

public class p71 {

	public static void main(String[] args) {

		int x = 2;
		int y = ++x;
		System.out.println("x는=" + x +" y는=" + y); //x=2, y=3
		
		
		
		int a = 2;
		int b = a++;
		System.out.println("a는=" + a +" b는=" +b); //a=3, b=2 대입을 나중에
		
		int q = 2;
		int w = --q;
		System.out.println(w);
		
		int e = 2;
		int r = e--;
		System.out.println(r);
		//r변수에 기존 e값을 먼저 대입한 후 e값 1 감소

	
	}

}
