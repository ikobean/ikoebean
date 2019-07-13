package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Post_t1 extends JPanel{
	Page_t1 		page 			= null;	//전체화면 객체주입되는 변수
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	Font 			myfont 			= new Font("HY견고딕",Font.PLAIN,26);
	JPanel jp_bubble2 = new JPanel();
	JScrollPane jsp_bubble = new JScrollPane(jp_bubble2
										,JScrollPane.VERTICAL_SCROLLBAR_NEVER
										,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_bubble = new JPanel();
	MyPostButton_t1 jp_bt_java = new MyPostButton_t1("자바,JSP");
	MyPostButton_t1 jp_bt_oracle = new MyPostButton_t1("오라클 SQL");
	MyPostButton_t1 jp_bt_javascript = new MyPostButton_t1("자바스크립트");
	MyPostButton_t1 jp_bt_html = new MyPostButton_t1("HTML");
	MyPostButton_t1 jp_bt_android = new MyPostButton_t1("안드로이드");
	public Post_t1(Page_t1 page,String name) {
		this.page = page;
		setLayout(null);
		jlb.setIcon(new ImageIcon(".\\src\\images\\list02.png"));
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(myfont);
		initGroup();
		initMouseDrag();
		jsp_bubble.setBorder(null);
		jp_bubble.add(jsp_bubble);
		setBackground(new Color(255,224,200));
		add(jlb);
	}
	public void initMouseDrag() {
		MouseAdapter ma = new MouseAdapter() {
            Point origin;
            @Override
            public void mousePressed(MouseEvent e) {
                origin = new Point(e.getPoint());
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                if (origin != null) {
                    JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, jp_bubble2);
                    if (viewPort != null) {
                        int deltaY = origin.y - e.getY();

                        Rectangle view = viewPort.getViewRect();
                        view.y += deltaY;
                        jp_bubble2.scrollRectToVisible(view);
                    }
                }
            }
        };
        jp_bubble2.addMouseListener(ma);
        jp_bubble2.addMouseMotionListener(ma);
	}
	public void initGroup() {
		GroupLayout pageLayout = new GroupLayout(jp_bubble2);
		jp_bubble2.setLayout(pageLayout);
		pageLayout.setHorizontalGroup(pageLayout.createSequentialGroup()
			.addGroup(pageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jp_bt_java)
				.addComponent(jp_bt_oracle)
				.addComponent(jp_bt_javascript)
				.addComponent(jp_bt_html)
				.addComponent(jp_bt_android)
			)
		);
		pageLayout.setVerticalGroup(pageLayout.createSequentialGroup()
			.addComponent(jp_bt_java,100,100,100)
			.addComponent(jp_bt_oracle,100,100,100)
			.addComponent(jp_bt_javascript,100,100,100)
			.addComponent(jp_bt_html,100,100,100)
			.addComponent(jp_bt_android,100,100,100)
		);
		GroupLayout pageLayout2 = new GroupLayout(jp_bubble);
		jp_bubble.setLayout(pageLayout2);
		pageLayout2.setHorizontalGroup(pageLayout2.createSequentialGroup()
			.addGroup(pageLayout2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this)
				.addComponent(jsp_bubble)
			)
		);
		pageLayout2.setVerticalGroup(pageLayout2.createSequentialGroup()
			.addComponent(this,75,75,75)
			.addComponent(jsp_bubble)
		);
	}
}

class MyPostButton_t1 extends JPanel{
	JLabel jlb = new JLabel();
	Font myfont = new Font("HY견고딕",Font.PLAIN,24);
	Shape s;
	public MyPostButton_t1(String name) {
		setLayout(null);
		s = new RoundRectangle2D.Float(20,10,360,80,30,30);
		jlb.setHorizontalAlignment(SwingConstants.CENTER);
		jlb.setBounds(120, 30, 160, 40);
		jlb.setText(name);
		jlb.setFont(myfont);
		setBackground(new Color(255,224,200));
		add(jlb);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(new Color(231,164,100));
		g2.fill(s);
		g2.setColor(Color.black);
		g2.draw(s);
	}
}

