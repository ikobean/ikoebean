package com.ch4;

public class for_if_0514 {
	
/*FizzBuzz게임 구현해 보자
1부터 100까지 세면서  for
5의 배수이면 fizz라고 출력 if
7의 배수면 Buzz if
5와 7의 공배수이면 FizzBuzz
나머지는 그냥 출력 else
*/

	public static void main(String[] args) {
	
		int i ;
		for(i=0; i<=100; i++){
			if(i%35==0) {
				System.out.println("fizzbuzz");
					}
         	else if(i%7==0) {	
				System.out.println("buzz");
	         }
			else if (i%5==0) {
				System.out.println("fizz");
				}
			else { 
				System.out.println(i);
				}}
			
		  }}











