package com.ch8;

public class FigureArea {

	//삼각형의 면적을 구해줄래?
	public double area(int width, int height, double d) {
	/*	a = 3;
		b = 5;
		e = 1/2;
		double triangle =  a*b*e;
		return  triangle; 
		*/
		double t_area = 0.0;
		t_area = width*height*d;
		return t_area;

		
	}
	//사각형의 면적을 구해볼까?
	public double area(int width, int height) {
	/*	c = 4;
		d = 6;
		double nemo = c*d;
		return nemo;
		*/	
		double r_area = 0;
		r_area = width*height;
		return r_area;
		
	}
	//원의 면적은 얼마니?
	public double area(double pi , double r) {
	/*  q = 8;
		pi = 3.14;
		double one = (q/2)*(q/2)*pi;
		return one;
		*/
		double c_area = 0.0;
		c_area = r*r*pi;
		return c_area;
		
	}
}

