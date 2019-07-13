package com.ch8;

public class FigureAreaSimulation {

	public static void main(String[] args) {
		//인스턴스화하기
		FigureArea fa = new FigureArea();
		//삼각형 면적 구하는 메소드 호출한 후 결과값 출력하기
		double t_area = fa.area(10, 10, 0.5);
		System.out.println("삼각형의 면적은 : " +t_area);
		//사각형 면적 구하는 메소드 호출한 후 결과값 출력하기
		double r_area=fa.area(50, 90);
		System.out.println("사각형의 면적은 : " +r_area);
		//원의 면적 구하는 메소드 호출한 후 결과값 출력하기
		double c_area=fa.area(3.14, 0.5);
		System.out.println("원의 면적은 : " +c_area);
	}

}
