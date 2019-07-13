package com.ch4;

public class EVENODD {

	public static void main(String[] args) {
		int i = 0;
		int sum = 0;
		for (i = 0;  i<=10 ; i++) {
			sum = i;
			if(sum % 2 == 0) {
				System.out.println("주사위 합이 짝수가 나왔다.");
			}
				else{
					System.out.println("주사위 합이 홀수가 나왔다.");
					
				}
			}
			
			System.out.println(sum);
		
			
		
		
	}

}
