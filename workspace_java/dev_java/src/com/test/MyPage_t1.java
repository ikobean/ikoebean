package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyPage_t1 extends JPanel {
	Page_t1 		page 			= null;	//전체화면 객체주입되는 변수
	JPanel 			jp_bubble 		= new JPanel();	//GroupLayout을 이용하기 위한 panel
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	Font 			myfont 			= new Font("HY견고딕",Font.PLAIN,26);
	//버튼처럼 사용될 panel(코드 최하단에 중복클래스)
	MyPageButton_t1 jp_bt_myPage 	= new MyPageButton_t1("내 정보");
	MyPageButton_t1 jp_bt_myPost 	= new MyPageButton_t1("내 게시글");
	MyPageButton_t1 jp_bt_myFollow  = new MyPageButton_t1("팔로우");
	MyPageButton_t1 jp_bt_my 		= new MyPageButton_t1("?");
	
	//맨위에 마이페이지 
	public MyPage_t1(Page_t1 page,String name) {
		this.page = page;
		setLayout(null);
		jlb.setIcon(new ImageIcon(".\\src\\images\\person01.png"));
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(myfont);
		setBackground(new Color(255,224,200));
		add(jlb);
		initGroup();
		initButton();
	}
	public void initGroup() {
		GroupLayout pageLayout = new GroupLayout(jp_bubble);
		jp_bubble.setLayout(pageLayout);
		pageLayout.setHorizontalGroup(pageLayout.createSequentialGroup()
			.addGroup(pageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this)
				.addGroup(pageLayout.createSequentialGroup()
					.addGroup(pageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jp_bt_myPage)
						.addComponent(jp_bt_myFollow)
					)
					.addGroup(pageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jp_bt_myPost)
						.addComponent(jp_bt_my)
					)
				)
			)
		);
		pageLayout.setVerticalGroup(pageLayout.createSequentialGroup()
			.addComponent(this,75,75,75)
			.addGroup(pageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pageLayout.createSequentialGroup()
					.addGroup(pageLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jp_bt_myPage,200,200,200)
						.addComponent(jp_bt_myPost,200,200,200)
					)
					.addGroup(pageLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jp_bt_myFollow,200,200,200)
						.addComponent(jp_bt_my,200,200,200)
					)
				)
			)
		);
	}
	public void initButton() {
		jp_bt_myPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getX()>=20&&e.getX()<=180&&e.getY()>=20&&e.getY()<=180) {
					JOptionPane.showMessageDialog(MyPage_t1.this, "x :"+e.getX()+" y: "+e.getY());
				}
				super.mouseClicked(e);
			}
		});
		jp_bt_myPost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//밑에 버튼 눌렀을때 마이 페이지로 돌아가는거
				if(e.getX()>=20&&e.getX()<=180&&e.getY()>=20&&e.getY()<=180) {
					page.remove(page.jp_page);
					page.jp_page = page.jp_myPost;
					page.add(page.jp_page);
					page.revalidate();
					page.repaint();
				}
				super.mouseClicked(e);
			}
		});
		jp_bt_myFollow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getX()>=20&&e.getX()<=180&&e.getY()>=20&&e.getY()<=180) {
					JOptionPane.showMessageDialog(MyPage_t1.this, "x :"+e.getX()+" y: "+e.getY());
				}
				super.mouseClicked(e);
			}
		});
		jp_bt_my.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getX()>=20&&e.getX()<=180&&e.getY()>=20&&e.getY()<=180) {
					
				}
				super.mouseClicked(e);
			}
		});
	}
}

class MyPageButton_t1 extends JPanel{
	JLabel jlb = new JLabel();
	Font myfont = new Font("HY견고딕",Font.PLAIN,24);
	Shape s; //인터페이스 구현체 클래스가 paintComponent?
	public MyPageButton_t1(String name) {
		setLayout(null);
		s = new RoundRectangle2D.Float(20,20,160,160,30,30);
		jlb.setHorizontalAlignment(SwingConstants.CENTER);
		jlb.setBounds(20, 130, 160, 40);
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
