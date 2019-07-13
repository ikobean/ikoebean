package com.ch7;

import java.util.Random;

public class Bunpo {
	


	public static void main(String[] args) {
		int bunpo[]= new int[99];
		int count[]= new int[8];
		
		// 한번에 int a[] = new int[99];
		
		Random r = new Random();
	
		
		for(int i=0; i<bunpo.length;i++) {
			int num = r.nextInt(10);
		for(int index=0; index<bunpo.length;index++) {
			System.out.println(bunpo[index]);
		}
		/*for(int i=0; i<bunpo.length;i++) {
			int num = r.nextInt(10);
			System.out.println(num);
			
		    int j =0;
			if(bunpo[i]==count[j]) 
			 j++;
		
	   
			
		
			
			
		}*/

	}}}


