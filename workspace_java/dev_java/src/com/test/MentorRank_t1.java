package com.test;

import java.util.List;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

public class MentorRank_t1 extends JPanel{
	Page_t1 page = null;
	List<MentorVO> mtVO = new ArrayList<>();
	public MentorRank_t1(Page_t1 page) {
		this.page = page;
		initGroup();
		setLayout(new GridLayout(2,1));
		
	}
	public void initGroup() {
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		//layout.setHorizontalGroup(group);
		
		//layout.setVerticalGroup(group);
	}
	
}
class MentorRank2_t2 extends JPanel{
	public MentorRank2_t2() {
		
	}
}