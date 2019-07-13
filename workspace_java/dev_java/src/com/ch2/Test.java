package com.ch2;

public class Test {

	public static void main(String[] args) {
		//회사를 인수하여 교육센터 이름을 IT사관학교 변경하고자 한다.
		System.out.println("소프트웨어인재개발원"); //문자열 상수를 사용했다.
		System.out.println("소프트웨어인재개발원"); 
		System.out.println("소프트웨어인재개발원");
		System.out.println("소프트웨어인재개발원");
		System.out.println("소프트웨어인재개발원");
		System.out.println("=======[[AFTER]]======");
		
		String name = "IT사관학교";
		System.out.println(name);
		System.out.println(name);
		System.out.println(name);
		System.out.println(name);
		System.out.println(name);
		//만일 바꾸어야 할 교육센터의 라벨이 교육장이 9개이고 모니터와 본체를 모두 바꾸어야 한다면 어떡하지?
		
//초기화가 중요한 이유
		
		//1부터 5까지의 합을 구하는 프로그램을 작성하시오
		int hap = 0;
		//hap = 1+2+3+4+5; 0 1 3 6 10 15
		hap = hap+1;
		System.out.println("1부터 5까지의 합은 " +hap); //15
		
		//1부터 10까지 중에서 홀수의 합을 구하시오

		hap = 1+3+5+7+9;
		System.out.println("1부터 10까지의 홀수 합은 " + hap); //25
	//초기화라는 건 뭐지? 
	
	
	}

}
