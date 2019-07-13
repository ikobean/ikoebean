package com.ch7;

import java.util.Random;

//전역변수 선언



public class Bunpo3 {
	 /*
	 * 연습문제 2 - 분포도
	   100개의 정수를 담을 수 있는 1차배열을 선언하여
	      임의의 수를 (0부터 9까지) 채번하여 초기화 한 후
	      각 숫자의 분포도(빈도) 출력하시오
	 */
	int random[] = new int[100];
    int array[] = new int[10];
//포문
	public void formun() {
		for(int i=0; i<random.length;i++) {
			for(int j=0; j<array.length;j++) {
				if(random[i]==j) {
					array[j]++;
				}
				
		}}
		
		
		
	}
    
//랜덤채번
public void random() {
		Random r = new Random();
		for(int i=0; i<random.length;i++) {
		random[i]= r.nextInt(10);
		
		
		
	}}
	
//프린트
public void print() {
	for(int i=0; i<array.length;i++) {
		System.out.println(array[i]);
	}
	
	
}

	public static void main(String[] args) {
		Bunpo3 abc = new Bunpo3();
		abc.random();
		abc.formun();
		abc.print();
	
		
		
		
	}

}
