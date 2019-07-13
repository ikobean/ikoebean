package com.ch4;

import java.util.Random;

public class practice0515_2 {
	/*
	 * 10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하는 프로그램을 작성하시오. 9 -2 -3 8 0 -3 -8
	 * -6 -2 0
	 * 
	 */

	public static void main(String[] args) {
		Random num = new Random();
		// int com = num.nextInt(21)-10; //-10 부터 10까지 뽑겠다.

		int plus = 0; //채번한 양수들의 합계
		int minus = 0;// 채번한 음수들의 합계
		int b = 0;
		for (int i = 1; i <= 10; i++) {
			int com = num.nextInt(21) - 10; // 10번 받겠다

			if (com < 0) {
			//	com+=minus; //com = com + minus
				minus+=com;
			}

			else if (com > 0) {
				plus+=com;
			}
			

		} 
		System.out.println("양수의 합은" + plus + "음수의 합은" + minus);
	}

}


