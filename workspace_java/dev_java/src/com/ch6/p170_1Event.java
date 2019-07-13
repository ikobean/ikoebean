package com.ch6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//객체 협업

public class p170_1Event implements ActionListener{
    //p170_1클래스에서 생성된 버튼을 사용하고 싶다.
	//어떡하지?
	 p170_1 p2 = null;  //전역변수로 다시 설정해준 이유는 지역변수만 설정했을때 (파라미터생성자)는 다른 데서 쓸 수 없기 때문임.
	 
	public p170_1Event() {   //디폴트 생성자
	}
	
	public p170_1Event(p170_1 p) {//타입 변수명 파라미터가 있는 생성자.
		this.p2=p;
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		/*  오버라이딩
		 *  같은 이름의 메소드를 두 개 이상 정복 정의 하는 설계
		 *  서로 상속관계나 구현체 관계가 있을 때만 가능
		 */
	       String label = e.getActionCommand(); //전송
	          if("전송".equals(label)) {
	        	  System.out.println("전송 버튼 클릭2");
	        	  p2.jbtn.setText("보내기");
	        	  
	        	  
	        	  
	}
	}}
