package com.ch2;
//이 코드는 메인 메소드의 파라미터은 String[] args에 대해 알아보기 위함이다.
//메인메소드는 클래스 안에 있는 모든 코드들 중에서 가장 우선순위가 높다.
//메인 메소드는 개발자가 호출하는 메소드가 아닙니다.- 누가? 자바가상머신(JVM - jdk1.8)
//print메소드는 개발자가 호출하는 메소드가 맞다.
//메소드를 선언하는 것과 호출하는 것의 코드의 차이점 - 발견
//선언{} . 호출();
//메인메소드를 호출하는 건 가상머신이 자동으로 함 - 콜백메소드라 부름. callback method
/*
 * 이클립스가 없다면 컴파일 요청하는 명령어를 직접 작성해야 함.
 * javac MainTest.java ->MainTest.class(기계어)
 * 실행
 * java MainTest 이순신 유승기
 * 이 클래스 안에는 전역변수가 없다.
 *  지역변수는 있니? 네 -boolean
 *  */

public class MainTest_190508 {
    //전역변수 선언 위치
	public static void main(String[] args) {
        //파라미터에 있는 변수의 이름은 args이고
		//타입은 배열임.
        String name = args[0]; //0번째 있는 값을 대입해 주세요//name이 지역변수
        name=args[1];
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        
        
	}

}
