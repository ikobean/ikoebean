package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chat_t1 extends JPanel{
	Page_t1 		page 			= null;	//전체화면 객체주입되는 변수
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	Font 			myfont 			= new Font("HY견고딕",Font.PLAIN,26);
	JButton jbtn_set = new JButton(new ImageIcon(".\\src\\images\\setting01.png"));
	public Chat_t1(Page_t1 page,String name) {
		this.page = page;
		setLayout(null);
		jlb.setIcon(new ImageIcon(".\\src\\images\\chat02.png"));
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(myfont);
		initButton();
		jbtn_set.setBounds(330, 20, 50, 40);
		jbtn_set.setBackground(new Color(255,224,200));
		jbtn_set.setRolloverEnabled(false);
		jbtn_set.setBorder(null);
		setBackground(new Color(255,224,200));
		add(jlb);
		add(jbtn_set);
	}
	public void initButton() {
		jbtn_set.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
