package com.ch8;

public class CatSimulation {

	public static void main(String[] args) {
	  Cat nb = new Cat();	
	  
	  King kiki = new King();
	  
	 System.out.println(nb.name);
	 
	 nb = null;
	 nb = new Cat();
	 System.out.println(nb.name);
	 System.out.println(nb.name2);

	 System.out.println("====[[메소드 오버 라이딩]]====");
	 //메소드 오버라이딩
	 nb.walk();
	 kiki.walk();
	 System.out.println("");
	 System.out.println("====[[메소드 오버 로딩]]====");
	 //메소드 오버 로딩
	 nb.walk();
	 kiki.walk(3);


	}

}
