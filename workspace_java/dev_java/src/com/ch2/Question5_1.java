package com.ch2;

public class Question5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int i = 1;
	int hap = 0;
	for(i=1;i<=5;i=i+1) {
		hap = hap + i;
		System.out.println("hap==>"+hap); //for문
	}
	//아래는 for문 밖에 있어요
	System.out.println("1부터 5까지의 합은 " +hap);
	//insert here - 변수(hap) 초기화 하세요.
	//int hap2;
	hap=0;
	for(i=1;i<=5;i=i+2) {
	hap = hap+i; 
	
	// 1 = 0+1
	// 3 = 1+2
	// 6 = 3+3 아!!!!!!!~~~~~~~~~
		}
	System.out.println("1부터 5까지의 홀수의 합은 " +hap); //9
	
	hap = 0;	
	int x = 1;
	for(x=1;x<=100;x=x+1) {
		
		hap = hap+x;
		
	
	}
	System.out.println("1부터 100까지의 합은"+hap);
	
	hap=0;
	int h = 0;
	for(h=0;h<=10;h=h+2) {
		hap = hap+h;
		System.out.println(h);
	}
	System.out.println("1부터 10까지 짝수의 더하기는" +hap);
	
		
	
}
	{
	double r1 = 10d;
	double r2 = 20d;
	double pi = 3.1416d; 
	double twon = r1*r2*pi;
	System.out.println("타원의 면적은"+twon);
		
	
	
	
	}

	
} 
