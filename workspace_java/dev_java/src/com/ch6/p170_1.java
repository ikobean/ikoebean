package com.ch6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * A is a B 관계에 있다면 서로 상속처리한다.
 * 상속받을 땐 하위클래스를 상속받는 것이 더 많은 걸 누릴 수 있다. 뭘 누릴 수 있다? 메소드, 필드
 * 인터페이지는 추상메소드만 가지고 있다. -왜냐면 기능을 경절할 수 없어서...
 * 구현하는 클래스가 각각 다르기 떄문에...
 * 어플리케이션이 배포되는 디바이스가 다르니까...
 * ActionListener를 implements한 클래스가 구현체 클래스이다.
 */

public class p170_1 extends JFrame implements ActionListener{
	 
	  String title;
	  JButton jbtn = new JButton("전송");
	  
	  
       public p170_1() {
    	   initDisplay();
    	   
    	 } //디폴트 생성자
    
       public p170_1(String title) {
    	    	 this.title=title;    	 
    	    	 //주의 : title을 먼저 초기화하고 화면을 출력해야 함.
    	         initDisplay();
       }
       
       
      public void initDisplay() {
    	  //디폴트생성자는 없으면 jvm이 대신 추가해줌.
    	  //생성자가 하나라도 있으면 대신 해주지 않음.
    	  p170_1Event pEvent = new  p170_1Event(this); //p170_1Event 클래스에 파라미터가 있는 생성자를 인스턴스화 하고 호출한것.
    	  //p170_1Event pEvent = new  p170_1Event(jbtn);
    	  jbtn.addActionListener(pEvent); //이벤트 처리를 전담하는 클래스 = 이벤트 핸들러 클래스//연결
    	  
   	      this.add("North",jbtn);   	  
    	  this.setTitle(title);
	      this.setSize(400,500);
	      this.setVisible(true);
         }
      
	   public static void main(String[] args) {
          p170_1 p = new p170_1();
          p170_1 p2 = new p170_1("this의 활용기");
          
          
    
     //p.initDisplay();
      //생성자 안에서 내 안에 있는 메소드를 호출할 수 있다~ 뭔소리야

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}

}
       


