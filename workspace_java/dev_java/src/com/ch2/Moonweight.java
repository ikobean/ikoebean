package com.ch2;

public class Moonweight {

	public static void main(String[] args) {
     //지구의 몸무게를 담을 변수 선언해 볼까?
	int earth_weight = 100;
	String unit = "kg";
	double moon_weight = 0.0;
	//달의 몸무게를 계산해서 출력하시오.
	System.out.println(100*0.17);
	//insert here
	double gravity = 0.17d;
	System.out.println(earth_weight*gravity);
	
    int a = 17;
	int b = 100;
	
	    System.out.println("a/b ===>" + (a+b)); //이거 그냥 예를 보여 주신거? 이건가?하고?
		System.out.println("a/b ===>" + (a/100.0));
		System.out.println("a/b ===>" + (a/100.0f));
		System.out.println("a/b ===>" + (a/b));
		System.out.println("a/b ===>" + (a/b));
	
	
	System.out.println(100*(17/100.0));
	
	
	
	
	System.out.println(earth_weight*(a/b));

	int x = 5;
	int y = 0;
	y = x;	
	moon_weight = earth_weight*(a/b);
	moon_weight = earth_weight*(17/100); //변수 두개에 상수 두개 사용
	moon_weight = earth_weight*(0.17); //변수 두개에 상수 한 개 사용
	System.out.println(moon_weight);
	
	double q = 17;
	double w = 100;
	moon_weight = earth_weight*(a/b);
	System.out.println(earth_weight*(q/w));
	System.out.println(earth_weight*(q/w)+unit);// +변수명 
	
	String mycat = "내복이";
	String catsr = "귀여워";
	System.out.println(mycat+" "+catsr);
	
	double nbkg = 9.4;
	System.out.println(mycat+" "+nbkg+unit);
		
	
	
	
	
	
			
	
	
	
		
		
		
	}

}
