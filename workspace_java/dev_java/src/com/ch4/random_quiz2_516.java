package com.ch4;

import java.util.Random;

//0부터 9사이의 임의의 숫자를 5개 채번하고 오름차순 정렬하시오
public class random_quiz2_516 {

	public static void main(String[] args) {
		
   Random r = new Random();
  
   
   for(int i=0;i<5;i++) {
	   int com = r.nextInt(10);
	   
		   System.out.println(com);
		   
	}

}}



