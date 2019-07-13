package com.baseball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseballGameView extends JFrame {
	
		BaseballGameEvent bbge =  new BaseballGameEvent();
		
		public  BaseballGameView() {
			bbge = new BaseballGameEvent(this);
			
			
		}
	
	
	    JPanel jp_center 		= new JPanel();
	    JTextArea jta_display   = new JTextArea();
	    JScrollPane jsp_display  = new JScrollPane(jta_display
	    		  ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
	    		  ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	    	     );
        JTextField jtf_user	    = new JTextField();
        JPanel jp_east 			= new JPanel();
        JButton jbtn_new 	    = new JButton("새게임");
        JButton jbtn_dap 		= new JButton("정답");
        JButton jbtn_clear	    = new JButton("지우기");
        JButton jbtn_exit 		= new JButton("나가기");
      	public void initDisplay() {//사용자정의메소드
		     //이벤트 소스와 이벤트 처리를 담당하는 클래스 연결
      		 BaseballGameEvent baseEven = new BaseballGameEvent(this); 	
		     jtf_user.addActionListener(baseEven);//this는 자기자신안에서 꺼내온다는 뜻
		     jbtn_new.addActionListener(baseEven);
		     jbtn_dap.addActionListener(baseEven);
		     jbtn_clear.addActionListener(baseEven);
		     jbtn_exit.addActionListener(baseEven);
		     //버튼의 배경색과 글자색변경				
		     jbtn_new.setBackground(new Color(110,140,120));
		     jbtn_new.setForeground(new Color(210,210,210));
		     jbtn_dap.setBackground(new Color(110,140,120));
		     jbtn_dap.setForeground(new Color(210,210,210));
		     jbtn_clear.setBackground(new Color(110,140,120));
		     jbtn_clear.setForeground(new Color(210,210,210));
		     jbtn_exit.setBackground(new Color(110,140,120));
		     jbtn_exit.setForeground(new Color(210,210,210));
		     jp_center.setBackground(Color.pink);
		     jp_east.setBackground(Color.black);
		     int width = 500;
		     int height = 600;//지역변수 - 메소드 안에 선언했을 때
		     String title = "야구숫자게임 - Ver1.0";
		     //속지의 레이아웃을BorderLayout으로 변경
		     jp_center.setLayout(new BorderLayout());
	         //jp_east속지 레이아웃을 GridLayout으로 변경
		     jp_east.setLayout(new GridLayout(4,1));
	         //jp_center중앙에 배치함
		     jp_center.add("South",jtf_user);
		     jp_center.add("Center",jsp_display);
		     jtf_user.setBackground(new Color(200,210,255));
		     jta_display.setBackground(new Color(215,240,200));
		     //JFrame 중앙에 jp_center속지 붙이고 동쪽에는 jp_east속지 붙이자
		     jp_east.add(jbtn_new);
		     jp_east.add(jbtn_dap);
		     jp_east.add(jbtn_clear);
		     jp_east.add(jbtn_exit);
		     this.add("Center",jp_center);
		     this.add("East",jp_east);
		     this.setTitle(title);
		     this.setSize(width, height);
		     this.setVisible(true);
	}
}
