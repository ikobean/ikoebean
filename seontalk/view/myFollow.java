package seontalk.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myFollow extends JFrame {
	JPanel jp_bubble = new JPanel();
	MainPage page = null;
	JPanel jp_grid = new JPanel();
//	JScrollPane 	jsp_bubble		= new JScrollPane(this
//			,JScrollPane.VERTICAL_SCROLLBAR_NEVER
//			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	Theme theme = new Theme();

	JPanel jp_north = new JPanel();

	JLabel jl_following = new JLabel("팔로잉", JLabel.CENTER);
	JLabel jl_following_num = new JLabel("27", JLabel.CENTER);
	JLabel jl_follower = new JLabel("팔로워", JLabel.CENTER);
	JLabel jl_follower_num = new JLabel("30", JLabel.CENTER);
	JTextField jtf_search = new JTextField("아이디를 입력하세요");

	public myFollow(MainPage page) {
		this.page = page;
		initFlollow();
		jp_bubble.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));

	}

	public myFollow() {
		
	}

	public void initFlollow() {
		jp_north.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp_north.setPreferredSize(new Dimension(410, 100)); // 패널사이즈 설정하는 법
		jp_north.add(jl_following);
		jp_north.add(jl_follower);
		jp_north.add(jl_following_num);
		jp_north.add(jl_follower_num);
		jp_north.add(jtf_search);
		
		jl_following.setPreferredSize(new Dimension(150, 30)); 
		jl_follower.setPreferredSize(new Dimension(150, 20)); 
		jl_following_num.setPreferredSize(new Dimension(150, 60)); 
		jl_follower_num.setPreferredSize(new Dimension(150, 60)); 
		
		jtf_search.setPreferredSize(new Dimension(290,30));
		//jp_north.setBackground(new Color(255, 225, 201));
		jp_north.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		List<followList_h> followList = new ArrayList<>();
		followList_h follow = null;
		for (int i = 0; i < 100; i++) {
			follow = new followList_h(i, page);
			followList.add(follow);
		}
		jp_grid.setLayout(new GridLayout(followList.size(), 1));
		for (int i = 0; i < followList.size(); i++) {
			jp_grid.add(followList.get(i));
		}
		GroupLayout layout = new GroupLayout(jp_bubble);
		jp_bubble.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jtf_search)
						.addComponent(jp_grid)));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(jtf_search)
				.addComponent(jp_grid));
		
		add(jp_north, "North");
		add(jp_bubble, "Center");

		setSize(410, 545);
		setVisible(false);
		setResizable(false);

	}

	public static void main(String args[]) {
		 MainPage mp = new MainPage();
		 myFollow mf = new myFollow(mp);
//		myFollow mf = new myFollow();
//		mf.initFlollow();
//		

	}
}
