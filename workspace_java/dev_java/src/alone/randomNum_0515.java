package alone;

import java.util.Random;

public class randomNum_0515 {

	public static void main(String[] args) {
		/*
		 * 10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하는 프로그램을 작성하시오. 9 -2 -3 8 0 -3 -8
		 * -6 -2 0
		 * 
		 *
		 */

		
		Random num = new Random();
		//int com = num.nextInt(21) -10;
		int plus=0;
		int minus =0;
		for	(int i=0; i<10; i++) {
			int com = num.nextInt(21) -10;	
			
			if (com>0) {
				plus +=com;
				}
			else if (com<0) {
				minus+=com;
			}
			
			
		}System.out.println("양수의 합은"+ plus + "음수의 합은" + minus);
	
	}

}





