package com.ch7;

import java.util.Random;

public class Bunpo2 {
 /*
 * 연습문제 2 - 분포도
   100개의 정수를 담을 수 있는 1차배열을 선언하여
      임의의 수를 (0부터 9까지) 채번하여 초기화 한 후
      각 숫자의 분포도(빈도) 출력하시오
 */
	//
	
	int jungsu[]= new int[20]; // 20개의 정수를 담을 수 있는 1차배열을 선언, 초기화
	  //방 10개 만들어줘!!
	int index[]= new int[10]; 
	
	public void arrayInit() {
		Random r = new Random();
		for(int i=0; i<jungsu.length;i++) {   //랜덤 채번. 
		jungsu[i]=r.nextInt(10); //랜덤 채번한 거 초기화
		//System.out.println(jungsu[i]);
	
		
	}}
	
	public void orderBy() {
		
		for(int i=0; i<jungsu.length; i++) {
			for(int j=0; j<index.length; j++)
			if(jungsu[i]==j) {
				index[j]++;
			}
		}
	}
		
	public void arrayPrint() {
		for(int i=0; i<index.length;i++) {
			System.out.println(index[i]);
	
	}}
	
	public static void main(String[] args) {
		Bunpo2 t1 = new Bunpo2 ();
		t1.arrayInit();//랜덤호출
		t1.orderBy();
	    t1.arrayPrint();
	    
	    
	    
	    
		
	 

	}

}
