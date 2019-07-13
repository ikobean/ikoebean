package com.ch2;

public class p49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //sal number(7,2)
		int sal = 800;
		//i2=100을 써야 초기화가 일어나고 100이라는 값이 담겨요.
		int i2=1000;
		//자료형 중에서 long타입이 있어요. int보다는 훨씬 더 큰 값도 담을 수 있어요.
		long l = 500;
		//변수 i2에 다른 변수에 저장된 값을 담을 수 있어요
		//이것도 초기화의 한 방법이죠.
		//그런데 문제가 있어요. 오른쪽에 온 타입이 왼쪽에 선언된 타입보다 큰타입이에요.
		i2=500;
		//다르게 표현해 보기
		i2=500;
		//아래는 무엇이 문제일까요?
		float sal2 = 800.6f; //800.6 => 800.6d
	//	double sal2 = 800.6;
	System.out.println(l);
	System.out.println(sal2);
		

	//long i2 = 1000;   
	//long l = 500;  L을 빼고 정수로 하던가       
	//i2=l;
	//i2=500L
		
			//int i2 = 1000;
			//long l = 500;     
			//i2=1;
			//i2=500L;

	int i = 5;
	int j = 10;
	i = j; //j를 i에 대입하라
	System.out.println(i);
	// l 을 안써주면 int로 인식됨
	//
	
	}

}
