package com.ch4;

public class arrayFor {

	public static void main(String[] args) {
		int deptnos[] = new int[3]; //초기화 안 되어 있다. 방 세개에 다 0 0 0만 들음.
		deptnos[0] = 10;
		deptnos[1] = 20;
		deptnos[2] = 30;
		
/*	System.out.println(0);    //for문을 쓰지 않으면 sysout을 3개 써야함 
	System.out.println(1);    //한 번에 for문으로 처리
	System.out.println(2);
*/		 
	
	    for(int i=0; i<3; i++) {
	    	System.out.println("==============");
	    	for(int num: deptnos) { //개선된 for문 : 전체를 모두 출력할 때 . 니가 가진 거 다 출력해주세요.
	    		      //for( 값을 담을 변수지정(변수선언) :주소번지  )
	    		System.out.println(num);
	    	}
	    }	    
	    System.out.println("==============");
	    String nickNames[] = new String[3];
	    nickNames[0] = "이순신";
	    nickNames[1] = "김유신";
	    nickNames[2] = "스미스";
	    for(String name: nickNames) {
	    	System.out.println(name);
	    }
	}

}


