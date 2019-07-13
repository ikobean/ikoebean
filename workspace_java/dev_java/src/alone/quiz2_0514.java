package alone;

import java.util.Scanner;

public class quiz2_0514 {

	public static void main(String[] args) {
		System.out.println("정수 두 개를 입력하세요.");
	    Scanner scan = new Scanner(System.in);
	    Scanner scan2 = new Scanner(System.in);
	    int num1= scan.nextInt();
	    int num2 = scan2.nextInt();       //스캐너라는 메소드가 nextint를 가지고 있어요. 리턴타입은 int에요. 
	    System.out.println("당신이 입력한 점수는 " + num1 + num2 + "입니다.");
	    
	    int first=0 ;
	    int second = 0;
	    int i = 0;
	    int cnt = 0;
	    for(i=first+1; i<second; i++)
	    	if(i%3==0) {
	    		cnt++; 
	    		}
	    System.out.println(cnt);
	    
	    
	    

	}

}
