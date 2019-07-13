package com.quiz0607;
class Money2 {
	private String country, name;
	public String getCountry() { 
		System.out.println("getCounty호출 성공");
		return country; 
	}
}
class Yen2 extends Money2 {
	//public String getCountry() { return super.country; }
}
class Euro2 extends Money2 {
	public String getCountry(String timeZone) {
		return super.getCountry();
	}
}
public class Question4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Euro euro2 = new Euro();
		String s = euro2.getCountry();
		System.out.println("s:"+s);
	}
}
