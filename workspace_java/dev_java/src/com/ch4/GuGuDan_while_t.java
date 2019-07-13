package com.ch4;

public class GuGuDan_while_t {

	public static void main(String[] args) {
		
		int a=2;
		while(a<10) { //변수 i는 1부터 9까지 곱해지는 숫자(가만 있어야됨)
			
			int b=1; //변수 자리에 따라 결과가 달라짐 유의
			while(b<=9) {
				
				System.out.println(a+ " 곱하기 " + b +" = " +  a*b);
				b++;
			}
			a++;
		}
			
		

	}

	
}

