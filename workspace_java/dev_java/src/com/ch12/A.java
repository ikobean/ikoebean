package com.ch12;

import java.util.ArrayList;

public class A {
	ArrayList<String> chatList = null;
	//ArrayList<String> chatList = new ArrayList<>(); //첫번째 방법
	
	public A() {
		//디폴트 생성자는 생략할 수 있다.
		//그러나 파라미터가 있는 생성자는 생략 불가
		chatList = new ArrayList<>();
		B b = new B(this);
		//chatList = new ArrayList<>(); //이미 a에 대한 주소번지가 넘어간 후 인스턴스화가 됨.==null
		
		
	}

}

