package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPostSet_t1 extends JPanel{
	Page_t1 		page 			= null;	//전체화면 객체주입되는 변수
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	Font 			myfont 			= new Font("HY견고딕",Font.PLAIN,26);
	public MyPostSet_t1(Page_t1 page,String name) {
		this.page = page;
		setLayout(null);
		jlb.setIcon(new ImageIcon(".\\src\\images\\preview01.png"));
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(myfont);
		initButton();
		setBackground(new Color(255,224,200));
		add(jlb);
	}
	public void initButton() {
		
		jlb.addMouseListener(new MouseAdapter() {
			@Override
			//내 게시글 화면으로 넘어가는거
			public void mouseClicked(MouseEvent e) {
				if(e.getX()>=5&&e.getX()<=35&&e.getY()>=0&&e.getY()<=40) {
					super.mouseClicked(e);
					page.remove(page.jp_page);
					page.jp_page = page.jp_myPost;
					page.add(page.jp_page);
					page.revalidate();
					page.repaint();
				}
			}
		});
	}
}
