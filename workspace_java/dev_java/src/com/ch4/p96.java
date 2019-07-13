package com.ch4;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class p96 extends JFrame {
	public static void main(String[] args) {
		System.out.println("당신의 자바 점수를 입력하세요.");
	    Scanner scan = new Scanner(System.in);
	    int jumsu = scan.nextInt();       //스캐너라는 메소드가 nextint를 가지고 있어요. 리턴타입은 int에요. 
	    System.out.println("당신이 입력한 점수는 " + jumsu + "입니다.");
	    	    char hakjum = 'z';
	    	    if((jumsu/10)==9 || (jumsu/10)==10) { // 너 90점 이상이니?
	    	    	//if(90<=jumsu && 100>=jumsu)
	    	hakjum = 'A';
	    	    }else if((jumsu/10)==8) { // 너 89~80사이에 점수를 받은거니?
	         hakjum = 'B';
	            }else if((jumsu/10)==7) { //너 79~70 사이에 점수를 받은거니?
		     hakjum = 'C';
	            }else if((jumsu/10)==6){ //너 69~60 사이에 점수를 받은거니?
		     hakjum = 'D';
	            }else { //너 59점 아래 점수를 받은거니?
	    	hakjum = 'F';
	    }
	    	    System.out.println("당신의 학점은 " + hakjum + " 입니다.");
	    	  //static으로 선언된 메소드를 호출할 때는 인스턴스화 없이도 가능함.
	    	    p96 p96 = new p96();
	    	  JOptionPane.showMessageDialog(p96, "당신의 학점은" + hakjum + "입니다.");
	}
	
	
}