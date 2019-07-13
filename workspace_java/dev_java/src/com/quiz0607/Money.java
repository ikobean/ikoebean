package com.quiz0607;
public class Money {
	 private String country = "시골";
	 //, name;
		 public String getCountry() { 
			 System.out.println("getCountry호출성공");
			 return country; }
		 }
		 class Yen extends Money {
	/*	 public String getCountry() {
			 return super.country; }
		 }*/
		 }
		 //SUPER ->MONEY를 가르킴. 쟤는 private이라 안됨!
		
		 class Euro extends Money {
		 public String getCountry(String timeZone) {
			 return super.getCountry();
	
		 }
		 
			public static void main(String[] args) {
				Euro euro = new Euro();
				String s = euro.getCountry();
				System.out.println("s:"+s);
				
			}
		 }
		 
		 
		 
		 
		 
		 