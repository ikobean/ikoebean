package com.ch10;

import java.util.ArrayList;

public class ListTest2 {
	public static void methodA(ArrayList<String> name) {
		for(String a: name) {
			System.out.println(a);
			
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		ArrayList<String> fruit = new ArrayList<String>();
		fruit.add("고양이");
		fruit.add("귀여워");
		fruit.add(2, " ");
		fruit.add(3, "냥냥");
		
		System.out.println(fruit);
	
	}

}
