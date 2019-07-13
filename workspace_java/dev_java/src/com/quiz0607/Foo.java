package com.quiz0607;

public interface Foo {
	 class Alpha implements Foo { 
		 
	 }
	 class Beta extends Alpha {
		 
	 }
	 class Delta extends Beta {
		 
	 public static void main( String[] args) {
		 
	 Beta x = new Beta();
	 //Foo f = (Dealta)x; //런타임에러.
	 Beta b = (Beta)(Alpha)x;

	 
}
	 }
}