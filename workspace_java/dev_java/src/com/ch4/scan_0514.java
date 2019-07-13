package com.ch4;

import java.util.Scanner;

import javax.swing.JOptionPane;
/*
 두 개의 정수를 입력 받아서
두 개의 정수 사이에 있는 
3의 배수는 몇개 인지 
출력하는 프로그램을 작성하시오
 */
public class scan_0514 {
	

	public static void main(String[] args) {
			
		System.out.println("정수 두개를 입력하세요.");
	    Scanner scan = new Scanner(System.in);
	    int no1 = scan.nextInt();
	    
	    Scanner scan2 = new Scanner(System.in);
	    int no2 = scan2.nextInt();       //스캐너라는 메소드가 nextint를 가지고 있어요. 리턴타입은 int에요. 
	  
	    System.out.println("당신이 입력한 정수는 " + no1 +" "+ no2 + "입니다.");
	    
	    int firstNumber = no1;
	    int secondNumber = no2;
	    int cnt = 0;
	    int i = 0;
	     for (i=firstNumber+1; i<secondNumber; i++) {
	    	 if(i%3==0) {
	    		 cnt++;
	    	 }
	     }
	     
	     
	     
	     System.out.println(cnt);
	     
		
	     
	}//////////////////////

}/////////////////////////

