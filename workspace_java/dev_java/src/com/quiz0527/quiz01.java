package com.quiz0527;

public class quiz01 {

	public void doit1() {
			}
	public String doit() {
		return "a";
	}
	public double doit(int x) {
		return 1.0;
	}
//왜??메소드 오버라이딩이 안되지? 다 타입도 다르고 갯수도 다른데??
	
	public static void main(String[] args) {

		int []x = {1,2,3,4,5};
		int y[] = x;
		System.out.println(y[2]);
	}
}
