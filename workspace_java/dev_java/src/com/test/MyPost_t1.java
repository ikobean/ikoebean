package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPost_t1 extends JPanel {
	Page_t1 		page 			= null;	//전체화면 객체주입되는 변수
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	Font 			myfont 			= new Font("HY견고딕",Font.PLAIN,26);
	JButton jbtn_set = new JButton(new ImageIcon(".\\src\\images\\setting01.png"));
	public MyPost_t1(Page_t1 page,String name) {
		this.page = page;
		setLayout(null);
		jlb.setIcon(new ImageIcon(".\\src\\images\\preview01.png"));
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(myfont);
		initButton();
		setBackground(new Color(255,224,200));
		add(jlb);
		add(jbtn_set);
	}
	public void initButton() {
		//세팅버튼
		jbtn_set.setBounds(330, 20, 50, 50);
		jbtn_set.setBackground(new Color(255,224,200));
		jbtn_set.setRolloverEnabled(false);
		jbtn_set.setBorder(null);
		//넌 뭐야? 그룹 레이아웃 (첫화면)나오는거 가틍ㄴ데? ???
		jlb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getX()>=5&&e.getX()<=35&&e.getY()>=0&&e.getY()<=40) {
					super.mouseClicked(e);
					page.remove(page.jp_page);
					page.jp_page = page.jp_myPage.jp_bubble;
					page.add(page.jp_page);
					page.revalidate();
					page.repaint();
				}
			}
		});
		//아래의 세팅버튼 누르면 세팅 창으로 가는거~
		jbtn_set.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				page.remove(page.jp_page);
				page.jp_page = page.jp_myPostSet;
				page.add(page.jp_page);
				page.revalidate();
				page.repaint();
			}
		});
	}
}