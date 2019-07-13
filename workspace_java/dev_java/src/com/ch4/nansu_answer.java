package com.ch4;

import java.util.Random;
import java.util.Scanner;
/*
 * java.lang 폴더 안에 있는 클래스는 따로 import를 안해도 괜찮아.
 */
public class nansu_answer {

	public static void main(String[] args) {
	    
		//클래스 이름을 자바 가상머신이 찾을 수 없을 때 빨간색이 뜸.
		//java.util.Random r = new java.util.Random();
		//import java.util.Random; <<클래스 선언 앞에 해야함
		
		Random r = new Random(); //인스턴스화 , 메모리에 상주시키는거야. 이게 클래스
		//컴퓨터가 채번한 숫자를 담을 변수 선언 = 채번한 숫자를 반환하는 함수 호출
		//변수 r을 인스턴스 변수라고 부름
		//for문 안에 쓰면 안돼 채번 다섯번 받을 거 아니니까!
		
		int com = r.nextInt(10);
		//기회 카운트해서 담을 변수 선언
		
		int cnt = 0;
		
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<5; i++) {
		System.out.println("0~9사이의 정수만 입력하세요.");
		
		int user = scan.nextInt();
		System.out.println("사용자가 입력한 숫자는"+user);
		
		if(com==user) {//정답을 맞춘거야?
			System.out.println("축하합니다!!!!정답입니다.");
			System.exit(0); //프로그램 종료 //가상머신과 연결고리를 끊음.
		}
		else if (com<user) {//낮춰라
			System.out.println("낮춰라");
	        cnt++;
		}
		//너무 작은 숫자를 입력 했어요
		else if(com>user) {
			System.out.println("높여라");
            cnt++;		
 		}
		} //for문의 끝
		if(cnt==5) {		
			System.out.println("!!!!!!!!!바보!!!!!!!!!!!");	
		System.exit(0);
	
		}}}


	    /*
	     * for(int x = 0; x<10 ; x++) {
	     *	int com = r.nextInt(10);
	    	System.out.println(com);
	    */
		 //0.0~ 10.0(0포함 10미포함)
		//메소드는 클래스를 가져야해. - 인스턴스화  nextInt가 메소드.
		
		
				





