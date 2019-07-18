package com.seontalk_alone;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class ToggleButton extends JFrame {
	/*
	 * imgicon btn setselected
	 */
	JPanel panel  = new MyPanelzTop("마이페이지","HY견고딕",25,"PINK");
	JPanel panel2 = new MyPanelzButton("쪽지함","HY견명조",25,"PINK");
	JPanel panel3 = new MyPanelzButton("내 게시글","바탕체",25,"PINK");
	JPanel panel4 = new MyPanelzButton("마이멘토","HY견고딕",25,"PINK");
	JPanel panel5 = new MyPanelzButton("?","HY견고딕",25,"PINK");
	
	Container con;
	JPanel jp_south = new JPanel();
	
	ImageIcon icon1 = new ImageIcon("C:/Users/User/Desktop/seontalkImage/icon1.png");
	ImageIcon icon2 = new ImageIcon("C:/Users/User/Desktop/seontalkImage/icon2.png");
	ImageIcon icon3 = new ImageIcon("C:/Users/User/Desktop/seontalkImage/icon3.png");
	ImageIcon icon4 = new ImageIcon("C:/Users/User/Desktop/seontalkImage/icon4.png");
	ImageIcon icon5 = new ImageIcon("C:/Users/User/Desktop/seontalkImage/icon5.png");
	ImageIcon icon6 = new ImageIcon("C:/Users/User/Desktop/seontalkImage/icon6.png");
	ImageIcon icon7 = new ImageIcon("C:/Users/User/Desktop/seontalkImage/icon7.png");
	ImageIcon icon8 = new ImageIcon("C:/Users/User/Desktop/seontalkImage/icon8.png");
	ImageIcon icon9 = new ImageIcon("C:/Users/User/Desktop/seontalkImage/icon9.png");
	ImageIcon icon10 = new ImageIcon("C:/Users/User/Desktop/seontalkImage/icon10.png");
	
	
	  JToggleButton jbtn_myPage = new JToggleButton(icon1);
	  JToggleButton jbtn_chat  = new JToggleButton(icon2); 
	  JToggleButton jbtn_post = new 	  JToggleButton(icon3);
	  JToggleButton jbtn_mentor = new JToggleButton(icon4);
	  JToggleButton jbtn_setting = new JToggleButton(icon5);
	 
	/*
	 * JToggleButton jbtn_myPage = new JToggleButton(); JToggleButton jbtn_chat =
	 * new JToggleButton(); JToggleButton jbtn_post = new JToggleButton();
	 * JToggleButton jbtn_mentor = new JToggleButton(); JToggleButton jbtn_setting =
	 * new JToggleButton();
	 */
	ButtonGroup bg = new ButtonGroup();
	
	public ToggleButton() {
		setSize(410, 600);
		setResizable(false);
		setTitle("Java 2D Shapes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //메모리관련
		
		bg.add(jbtn_myPage);
		bg.add(jbtn_chat);
		bg.add(jbtn_post);
		bg.add(jbtn_mentor);
		bg.add(jbtn_setting);
		
		jp_south.setLayout(new GridLayout(1,5)); //버튼 붙일 패널 레이아웃 잡고 붙임
		jp_south.add(jbtn_myPage);
		jp_south.add(jbtn_chat);
		jp_south.add(jbtn_post);
		jp_south.add(jbtn_mentor);
		jp_south.add(jbtn_setting);
		
		jbtn_myPage.setSelectedIcon(icon6);
		jbtn_chat.setSelectedIcon(icon7);
		jbtn_post.setSelectedIcon(icon8);
		jbtn_mentor.setSelectedIcon(icon9);
		jbtn_setting.setSelectedIcon(icon10);
		
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(false);
		
		
		/* 
		 * grouptLayout은 수직축 수평축을 따로 관리함.
		 * GroupLayout.SequentialGroup  요소의 배치와 사이즈 설정을 1개씩 차례로 실시하는Group
		 * GroupLayout.ParallelGroup  아이의 배치와 사이즈 설정을 실시하는Group
		 * 
		 * GroupLayout 은 계층 적 구성과 결합 된 순차 및 병렬의 두 가지 유형의 배열을 사용합니다.
		 * 순차적 배열을 사용하면 BoxLayout 또는 FlowLayout 이 한 축을 따라하는 것처럼 구성 요소가 차례로 배치됩니다.
		 * 각 구성 요소의 위치는 선행 구성 요소를 기준으로 정의됩니다.
		 * 두 번째 방법은 구성 요소를 동일한 공간에서 서로의 상단에 병렬로 배치합니다. 세로 축을 따라 기준선, 상단 또는 하단 정렬 할 수 있습니다.
		 * 구성 요소가 모두 같은 크기가 아닌 경우 가로 축을 따라 왼쪽, 오른쪽 또는 가운데 맞춤을 사용할 수 있습니다.
		 * 
		 * https://translate.google.com/translate?hl=ko&sl=en&u=https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html&prev=search
		 */
		//set Horizontal
		//덩어리 덩어리로 가로로 붙는다.
		//쪽지함            내게시글
		//마이멘토           <?>
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				//그룹 레이아웃에 제일 큰 바깥 패널을 붙임
				.addComponent(panel)
				//그 바깥 패널에 컴퍼넌트를 1개씩 레이아웃하는 메소드를 불러서
				//panel2 <쪽지함> , panel4 <마이멘토 >를 붙임
				//요소의 배치와 사이즈 설정을 1개씩 차례로 실시하는Group
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panel2)
						.addComponent(panel4)
					)
					//<내게시글> <?>
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panel3)
						.addComponent(panel5)
					)
				)//버튼부분 붙임
				.addComponent(jp_south)
			)
		);
		//덩어리 덩어리가 세로로 붙는다.
		//그래서 쪽지함 내게시글
		//	   마이멘토  ?
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(panel,100,100,100)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						//component - the Component to addmin - 
						//the minimum size or one of DEFAULT_SIZE or
						//PREFERRED_SIZEpref - the preferred size or one of DEFAULT_SIZE or PREFERRED_SIZE
						//max - the maximum size or one of DEFAULT_SIZE or PREFERRED_SIZE
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(panel2,200,200,200)
						.addComponent(panel3,200,200,200)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(panel4,200,200,200)
						.addComponent(panel5,200,200,200)
					)
				)
			)
			.addComponent(jp_south,100,100,100)
		);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ToggleButton();
	}
}


class MyPanelzTop extends JPanel{
	JLabel jlb = new JLabel();
	Font myfont = new Font("HY견명조",Font.BOLD,20);
	Shape s;
	Map<String,Color> themes = new HashMap<String, Color>();
	//맨 위에 "마이페이지" 모양잡고 위치잡고 폰트 설정해줌.
	//
	public MyPanelzTop() {
		setLayout(null);
		s = new RoundRectangle2D.Float(10,10,380,80,20,20);
		jlb.setBounds(30, 25, 150, 50);
		jlb.setFont(myfont);
		setBackground(new Color(255,213,192));
		add(jlb);
	}
	//파라미터가 있는 생성자. 이름,폰트,폰트사이즈,컬러 
	public MyPanelzTop(String name ,String font, int fontSize, String color) {
		String themeName = "BLACK";
		Color themeColor = Color.BLACK;
		themes.put(themeName, themeColor); //themes => hashmap
		//쌤처럼 초기화 안하는 이유는 여러개 저장할 피룡가 없기 떄문에?
		
		themeName = new String("PINK");
		themeColor = new Color(235,157,190);
		themes.put(themeName, themeColor);
		
		themeName = new String("CYAN");
		themeColor = new Color(30,140,165);
		themes.put(themeName, themeColor);
		
		setLayout(null);
		myfont = new Font(font,Font.BOLD,fontSize);
		jlb.setFont(myfont);
		jlb.setText(name);
		jlb.setBounds(30, 25, 150, 50);
		s = new RoundRectangle2D.Float(10,10,380,80,20,20);
		
		Color setColor = themes.get(color);
		setBackground(setColor);
		add(jlb);
	}
/*
 * 모든 스윙 컴포넌트는 paintComponent를 가짐.
 * 자신의 모양을 그리는 메서드.
 * 매개 변수인 Graphics 객체
 * 
 * class ㅇㅇㅇ extends Jㅌㅌ
 * public void paintComponent(Graphics g) {
		super.paintComponent(g);
		필요한 그리기 코드 작성
 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(new Color(237,134,81));
		g2.fill(s);
		g2.setColor(Color.black);
		g2.draw(s);

	}
}
class MyPanelzButton extends JPanel{
	JLabel jlb = new JLabel();
	Font myfont = new Font("HY견명조",Font.BOLD,30);
	Shape s;
	Map<String,Color> themes = new HashMap<String, Color>();
	
	public MyPanelzButton() {
		setLayout(null);
		s = new RoundRectangle2D.Float(20,20,160,160,30,30);
		jlb.setHorizontalAlignment(SwingConstants.CENTER);
		jlb.setBounds(20, 130, 160, 40);
		jlb.setFont(myfont);
		setBackground(new Color(255,213,192));
		add(jlb);
	}

	public MyPanelzButton(String name ,String font, int fontSize, String color) {
		String themeName = "BLACK";
		Color themeColor = Color.BLACK;
		themes.put(themeName, themeColor);
		themeName = new String("PINK");
		themeColor = new Color(235,157,190);
		themes.put(themeName, themeColor);
		themeName = new String("CYAN");
		themeColor = new Color(30,140,165);
		themes.put(themeName, themeColor);
		setLayout(null);
		myfont = new Font(font,Font.BOLD,fontSize);
		jlb.setHorizontalAlignment(SwingConstants.CENTER);
		jlb.setFont(myfont);
		jlb.setText(name);
		jlb.setBounds(20, 130, 160, 50);
		s = new RoundRectangle2D.Float(20,20,160,160,30,30);
		
		Color setColor = themes.get(color);
		setBackground(setColor);
		add(jlb);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.PINK);
		g2.fill(s);
		g2.setColor(Color.black);
		g2.draw(s);

	}
}
