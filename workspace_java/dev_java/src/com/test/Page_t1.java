package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
//메인. 제이프레임. 각 페이지가 설정돼있음.
//page.으로 호출
public class Page_t1 extends JFrame{
	//////////////////////////////////상단 화면////////////////////////////////////
	MyPage_t1 		jp_myPage 		= new MyPage_t1(this,"마이페이지");
	MyPost_t1 		jp_myPost 		= new MyPost_t1(this,"내 게시글");
	MyPostSet_t1 	jp_myPostSet 	= new MyPostSet_t1(this,"게시글 설정");
	Chat_t1 		jp_chat 		= new Chat_t1(this,"채팅");
	Post_t1 		jp_post 		= new Post_t1(this, "게시글");
	MentorRank_t1	jp_rank			= new MentorRank_t1(this);
	MentorList_t1	jp_list			= new MentorList_t1(this);
	MentorSearch_t1	jp_search		= new MentorSearch_t1(this);
	Mentor_t1 		jp_mentor 		= new Mentor_t1(this, "멘토");
	Setting_t1 		jp_setting 		= new Setting_t1(this, "설정");
	JPanel 			jp_page 		= new JPanel(); // 페이지가 교체되는 panel
	//////////////////////////////////상단 화면////////////////////////////////////
	//////////////////////////////////하단 버튼////////////////////////////////////
	JToggleButton 	jbtn_myPage  	= new JToggleButton(new ImageIcon(".\\src\\images\\person01.png"));
	JToggleButton 	jbtn_chat    	= new JToggleButton(new ImageIcon(".\\src\\images\\chat02.png"));
	JToggleButton 	jbtn_post    	= new JToggleButton(new ImageIcon(".\\src\\images\\list02.png"));
	JToggleButton 	jbtn_mentor  	= new JToggleButton(new ImageIcon(".\\src\\images\\people01.png"));
	JToggleButton 	jbtn_setting 	= new JToggleButton(new ImageIcon(".\\src\\images\\setting01.png"));
	ButtonGroup 	bg 				= new ButtonGroup(); //토글버튼 그룹화
	JPanel 			jp_south 		= new JPanel(); //버튼이 붙는 panel
	//////////////////////////////////하단 버튼////////////////////////////////////
	
	public Page_t1() {
		init();
	}
	
	public void init() {	//화면 초기화 메소드
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
		//교체 패널에 초기화면을 마이페이지를 저장
		jp_page = jp_myPage.jp_bubble;
		add(jp_page);
		//버튼 붙이기
		initButton();
		jp_south.setLayout(new GridLayout(1,5));
		jp_south.add(jbtn_myPage);
		jp_south.add(jbtn_chat);
		jp_south.add(jbtn_post);
		jp_south.add(jbtn_mentor);
		jp_south.add(jbtn_setting);
		add("South",jp_south);
		//전체화면 설정
		setBackground(new Color(255,202,158));
		setSize(410,545);
		setResizable(false);
		setVisible(true);
	}
	public void initButton() {	//버튼초기화 메소드
		//토글버튼 그룹추가
		bg.add(jbtn_myPage);
		bg.add(jbtn_chat);
		bg.add(jbtn_post);
		bg.add(jbtn_mentor);
		bg.add(jbtn_setting);
		//버튼 이벤트 추가
		jbtn_myPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(jp_page);
				jp_page = jp_myPage.jp_bubble;
				add(jp_page);
				revalidate();
				repaint();
			}
		});
		jbtn_chat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(jp_page);
				jp_page = jp_chat;
				add(jp_page);
				revalidate();
				repaint();
			}
		});
		jbtn_post.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(jp_page);
				jp_page = jp_post.jp_bubble;
				add(jp_page);
				revalidate();
				repaint();
			}
		});
		jbtn_mentor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(jp_page);
				jp_page = jp_mentor;
				add(jp_page);
				revalidate();
				repaint();
			}
		});
		jbtn_setting.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(jp_page);
				jp_page = jp_setting;
				add(jp_page);
				revalidate();
				repaint();
			}
		});
		jbtn_myPage.setBackground(new Color(189,117,58));
		jbtn_chat.setBackground(new Color(189,117,58));
		jbtn_post.setBackground(new Color(189,117,58));
		jbtn_mentor.setBackground(new Color(189,117,58));
		jbtn_setting.setBackground(new Color(189,117,58));
		jbtn_myPage.setRolloverEnabled(false);
		jbtn_chat.setRolloverEnabled(false);
		jbtn_post.setRolloverEnabled(false);
		jbtn_mentor.setRolloverEnabled(false);
		jbtn_setting.setRolloverEnabled(false);
		jbtn_myPage.setSelected(true);
	}
	
	public static void main(String[] args) {
		Page_t1 p1 = new Page_t1();
	}
}


