package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Gc_Java2D extends JFrame {
	
	JPanel panel  = new MyPanelzTop("마이페이지","HY견고딕",25,"PINK");
	JPanel panel2 = new MyPanelzButton("내 정보","HY견명조",25,"PINK");
	JPanel panel3 = new MyPanelzButton("내 게시글","바탕체",25,"PINK");
	JPanel panel4 = new MyPanelzButton("팔로우","HY견고딕",25,"PINK");
	JPanel panel5 = new MyPanelzButton("미정","HY견고딕",25,"PINK");
	JButton jbtn_myPage  = new JButton();
	JButton jbtn_chat 	 = new JButton();
	JButton jbtn_post    = new JButton();
	JButton jbtn_mentor  = new JButton();
	JButton jbtn_setting = new JButton();
	JPanel jp_south = new JPanel();

	public Gc_Java2D() {
		setSize(410, 600);
		setResizable(false);
		setTitle("Java 2D Shapes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp_south.setLayout(new GridLayout(1,5));
		jp_south.add(jbtn_myPage);
		jp_south.add(jbtn_chat);
		jp_south.add(jbtn_post);
		jp_south.add(jbtn_mentor);
		jp_south.add(jbtn_setting);
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(false);
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(panel)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panel2)
						.addComponent(panel4)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panel3)
						.addComponent(panel5)
					)
				)
				.addComponent(jp_south)
			)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(panel,100,100,100)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
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
		new Gc_Java2D();
	}
}

class MyPanelzTop extends JPanel{
	JLabel jlb = new JLabel();
	Font myfont = new Font("HY견명조",Font.BOLD,20);
	Shape s;
	Map<String,Color> themes = new HashMap<String, Color>();
	
	public MyPanelzTop() {
		setLayout(null);
		s = new RoundRectangle2D.Float(10,10,380,80,20,20);
		jlb.setBounds(30, 25, 150, 50);
		jlb.setFont(myfont);
		setBackground(new Color(255,213,192));
		add(jlb);
	}
	
	public MyPanelzTop(String name ,String font, int fontSize, String color) {
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
		jlb.setFont(myfont);
		jlb.setText(name);
		jlb.setBounds(30, 25, 150, 50);
		s = new RoundRectangle2D.Float(10,10,380,80,20,20);
		
		Color setColor = themes.get(color);
		setBackground(setColor);
		add(jlb);
	}

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
