package seontalk.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class myFollow extends JFrame{
	JPanel jp_bubble = new JPanel();
	MainPage page = null;
	JPanel jp_grid = new JPanel();
//	JScrollPane 	jsp_bubble		= new JScrollPane(this
//			,JScrollPane.VERTICAL_SCROLLBAR_NEVER
//			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	Theme theme = new Theme();
	
	JPanel jp_north = new JPanel();
	JPanel jp_center = new JPanel();
	
	JLabel jl_following = new JLabel("팔로잉",JLabel.CENTER);
	JLabel jl_following_num = new JLabel("27",JLabel.CENTER);
	JLabel jl_follower = new JLabel("팔로워",JLabel.CENTER);
	JLabel jl_follower_num = new JLabel("30",JLabel.CENTER);
	JTextField  jtf_search = new JTextField("아이디를 입력하세요");
 
   public myFollow(MainPage page) {
   	this.page = page;
   	initFlollow();
   	setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
   	//jsp_bubble.setBorder(null);

   }
    public myFollow() {
		// TODO Auto-generated constructor stub
	}
	public void initFlollow() {
    	
    	jp_north.setLayout(new GridLayout(2,2));
    	
    	jp_north.setPreferredSize(new Dimension(410,100)); //패널사이즈 설정하는 법
    	jp_north.add(jl_following);
    	jp_north.add(jl_follower);
    	jp_north.add(jl_following_num);
    	jp_north.add(jl_follower_num);
    	
    	//jtf_search.setPreferredSize(new Dimension(290,30));
    	
    	//jp_center.add(jtf_search);
    	//jp_center.setLayout(new FlowLayout());
        
    	jp_north.setBackground(new Color(255,225,201));
    	jp_center.setBackground(new Color(255,225,201));
	
        
        List<followList_h> followList = new ArrayList<>();
		followList_h follow = null;
		for(int i=0;i<100;i++) {
			follow = new followList_h(i,page);
			followList.add(follow);
		}
		jp_grid.setLayout(new GridLayout(followList.size(),1));
		for(int i=0;i<followList.size();i++) {
			jp_grid.add(followList.get(i));
		}
		GroupLayout layout = new GroupLayout(jp_bubble);
		jp_bubble.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jp_grid)
			)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(jp_grid)
		);
		
		jp_bubble.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		
    	add(jp_north,"North");
    	add(jp_bubble,"Center");
    	
        setSize(410,545);
        setVisible(false);
    	
    }
	public void initGroup() {
	
	}
    
	 public static void main(String args[]) {
		 MainPage mp = new MainPage();
	     myFollow mf = new myFollow(mp);
     }
}
