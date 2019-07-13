package com.ch5;

import javax.swing.JButton;

public class TV {
       JButton jtbn_onoff = new JButton("전원");// 전원 버튼을 만들어 줌
       JButton jtbn_plus = new JButton("+");// 소리 버튼을 만들어 줌
       boolean onoff = false; //껐다켰다 하는 거
       int voulume = 0; //노이즈 값
     //전역변수 - 초기화를 생략 가능함.
   	//왜냐하면 생성자가 대신 해주니까....
   	public TV() { //생성자라고 함.
   		System.out.println("디폴트 생성자 호출 성공");
   		
   	}
   	public TV(boolean A) { //생성자라고 함.
   		System.out.println("파라미터가 있는 생성자 호출 성공");   		
   		
   		
   	}
       public void poweron() {
    	   onoff = true; //초기화
       }
       public void poweroff() {
    	   onoff = false; //초기화
       }
}










