package com.chain;

public class ChainTest1 {

	public static void main(String[] args) {
		Block firstBlock = new Block("2000","0");
		System.out.println("first ==>" +firstBlock.hash);
	
		Block secondBlock = new Block("3000",firstBlock.hash);
		System.out.println("second ==>" +secondBlock.hash);
		
		Block thirdBlock = new Block("5000",secondBlock.hash);
		System.out.println("first ==>" +thirdBlock.hash);
		
	}

}