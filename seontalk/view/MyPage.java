package seontalk.view;

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

public class MyPage extends JPanel {	//우선 자기자신도 panel(상단 제목이 그려짐.)
	MainPage 		page 			= null;	//전체화면 객체주입되는 변수
	JPanel 			jp_bubble 		= new JPanel();	//GroupLayout을 이용하기 위한 panel(화면전환시 jp_page에는 얘를 대입함.)
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	//버튼처럼 사용될 panel(코드 최하단에 중복클래스)
	ButtonPanel jp_bt_myPage 	= null;
	ButtonPanel jp_bt_myPost 	= null;
	ButtonPanel jp_bt_myFollow  = null;
	ButtonPanel jp_bt_myBest 	= null;
	
	Theme theme = new Theme();
	

	public MyPage(MainPage page,String name) {
		this.page = page;
		setLayout(null);
		///////////////////////제목 세팅/////////////////////////
		if(Theme.BLACK.equals(page.memVO.getTheme())) {
			jlb.setIcon(new ImageIcon(".\\src\\images\\person01_rev.png"));
		}
		else {
			jlb.setIcon(new ImageIcon(".\\src\\images\\person01.png"));
		}
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(new Font(page.memVO.getFont(),Font.PLAIN,26));
		jlb.setForeground(theme.setFontColor(page.memVO.getTheme()));
		setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		add(jlb);
		///////////////////////////////////////////////////////
		initButton();
		initGroup();
	}
	public void initGroup() {	//상단제목,버튼panel(4개)를 GroupLayout으로 처리
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
						.addComponent(jp_bt_myBest)
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
						.addComponent(jp_bt_myBest,200,200,200)
					)
				)
			)
		);
	}
	public void initButton() {	//버튼panel에 버튼처럼 동작될 MouseClick이벤트 처리
		jp_bt_myPage   = new ButtonPanel("내 정보", 20, 20, 160, 160, 30, 30, page.memVO);
		jp_bt_myPost   = new ButtonPanel("내 게시글", 20, 20, 160, 160, 30, 30, page.memVO);
		jp_bt_myFollow = new ButtonPanel("팔로우", 20, 20, 160, 160, 30, 30, page.memVO);
		jp_bt_myBest   = new ButtonPanel("내 추천글", 20, 20, 160, 160, 30, 30, page.memVO);
		jp_bt_myPage.init(20, 130, 160, 40);
		jp_bt_myPost.init(20, 130, 160, 40);
		jp_bt_myFollow.init(20, 130, 160, 40);
		jp_bt_myBest.init(20, 130, 160, 40);
		jp_bt_myPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//둥근사각형 내부에서의 클릭만 적용되도록 좌표범위를 if문으로 처리
				if(e.getX()>=20&&e.getX()<=180&&e.getY()>=20&&e.getY()<=180) {
					//JOptionPane.showMessageDialog(MyPage.this, "x :"+e.getX()+" y: "+e.getY());
					myProfile mp = new myProfile();
					mp.setVisible(true);
					
				     
				}
				super.mouseClicked(e);
			}
		});
		jp_bt_myPost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
					//JOptionPane.showMessageDialog(MyPage.this, "x :"+e.getX()+" y: "+e.getY());
					myFollow mf= new myFollow(page);
					//
					mf.setVisible(true);
					
					
				}
				super.mouseClicked(e);
			}
		});
		jp_bt_myBest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getX()>=20&&e.getX()<=180&&e.getY()>=20&&e.getY()<=180) {
					page.remove(page.jp_page);
					page.jp_page = page.jp_myBest;
					page.add(page.jp_page);
					page.revalidate();
					page.repaint();
				}
				super.mouseClicked(e);
			}
		});
	}
}
