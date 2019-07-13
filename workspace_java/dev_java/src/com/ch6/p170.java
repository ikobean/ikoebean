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
 */

public class p170 extends JFrame implements ActionListener {
	 //this.setTitle(title); 에서 title 변수가 선언되지 않았다.
	//선언이 먼저 사용이 다음
	  String title;
	  JButton jbtn = new JButton("전송");
       public p170() {
    	   initDisplay();
  
    	   
    	   
    	   
    	   
    	 } //디폴트 생성자
    
       public p170(String title) {
    	    	 this.title=title;    	 
    	    	 //주의 : title을 먼저 초기화하고 화면을 출력해야 함.
    	         initDisplay();
       }
       
      public void initDisplay() {
    	  //이벤트 소스(버튼)->감지 (JVM) -> callback 호출 - actionPerformed(ActionEvent)
    	  //e.getSource();->이벤트소스의 주소번지
    	  jbtn.addActionListener(this); //이벤트 처리를 전담하는 클래스 = 이벤트 핸들러 클래스//연결
    	  this.add("North",jbtn);
    	  this.setTitle(title);
	      this.setSize(400,500);
	      this.setVisible(true);
         }
	   public static void main(String[] args) {
          p170 p = new p170();
          p170 p2 = new p170("JAVA SCRIPT");
    
     //p.initDisplay();
      //생성자 안에서 내 안에 있는 메소드를 호출할 수 있다~ 뭔소리야

	}

	@Override
	public void actionPerformed(ActionEvent e) {
          String label = e.getActionCommand(); //전송
          if("전송".equals(label)) {
        	  System.out.println("전송 버튼 클릭");
          }
	}

}
       


