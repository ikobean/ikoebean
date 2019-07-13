 package com.ch11;

import com.ch2.Sonata;
import com.ch9.Car;

public class ClassTest {

	public static void main(String[] args) {
		Car myCar = new Sonata();
		Class c = myCar.getClass();
		c = Sonata.class; //컴파일 된 클래스 정보를 담을 수 있다.
		
		if(myCar instanceof Sonata) {
			
		}
		//p383
		Sonata yourCar = new Sonata();
		try {
			Class sc = Class.forName("com.ch2.Sonata");
			Sonata himCar =(Sonata)sc.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
