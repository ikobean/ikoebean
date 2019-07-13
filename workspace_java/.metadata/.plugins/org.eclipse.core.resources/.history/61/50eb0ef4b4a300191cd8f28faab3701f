package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Setting_t1 extends JPanel{
	Page_t1 		page 			= null;	//전체화면 객체주입되는 변수
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	Font 			myfont 			= new Font("HY견고딕",Font.PLAIN,26);
	public Setting_t1(Page_t1 page,String name) {
		this.page = page;
		setLayout(null);
		jlb.setIcon(new ImageIcon(".\\src\\images\\setting01.png"));
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(myfont);
		setBackground(new Color(255,224,200));
		add(jlb);
	}
}
