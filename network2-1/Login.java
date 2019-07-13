package com.network2;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	//선언부
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	ImageIcon ig = new ImageIcon(imgPath+"main.PNG");
	//폰트 추가하기
	Font font = new Font("휴먼매직체",Font.BOLD, 30);
	//아이디와 패스워드 라벨 추가하기
	JLabel jlb_id = new JLabel("아이디");
	JTextField jtf_id = new JTextField("test");
	JLabel jlb_pw = new JLabel("패스워드");
	JPasswordField jpf_pw = new JPasswordField("123");
	JButton jbtn_login = new JButton(new ImageIcon(imgPath+"login.png"));
	JButton jbtn_join = new JButton(new ImageIcon(imgPath+"confirm.png"));
	String nickName = null;//전역변수만이 다른 클래스에서 재사용됨.
	TalkClientVer2 tc2 = null;
	//생성자
	//내부클래스 추가하기 - JPanel이미지를 입히기
	class myPanel extends JPanel{
		public void paintComponent(Graphics g) {
			g.drawImage(ig.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}
	//화면처리부
	public void initDisplay() {
		setContentPane(new myPanel());
		jbtn_login.addActionListener(this);
		jbtn_join.addActionListener(this);
		this.setLayout(null);//BorderLayout에서 배치레이아웃 잃음
		jlb_id.setBounds(45, 200, 80, 40);
		jtf_id.setBounds(140, 200, 155, 40);
		jlb_id.setFont(font);
		jlb_pw.setBounds(45, 240, 80, 40);
		jpf_pw.setBounds(140, 240, 155, 40);
		jlb_pw.setFont(font);
		jbtn_login.setBounds(175, 285, 120, 40);
		jbtn_join.setBounds(45, 285, 120, 40);
		this.add(jbtn_login);
		this.add(jbtn_join);
		this.add(jlb_id);
		this.add(jtf_id);
		this.add(jlb_pw);
		this.add(jpf_pw);
		//창이 닫힐때 자원반납하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350, 600);
		this.setVisible(true);
		this.setLocation(800,250);
	}
	//메인메소드
	public static void main(String[] args) {
		Login login = new Login();
		login.initDisplay();
	}
	public void login() {
		//사용자가 입력한 아이디와 비번 담기
		String mem_id = jtf_id.getText();
		String mem_pw = jpf_pw.getText();
		if(mem_id==null && mem_id.length()==0) {
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
			return;
		}
		else if(mem_pw==null && mem_pw.length()==0) {
			JOptionPane.showMessageDialog(this, "비번을 입력하세요.");
			return;
		}
		ChatDao cDao = new ChatDao();
		nickName=cDao.login(mem_id, mem_pw);
		if("실패".equals(nickName)) {//실패일 경우
			JOptionPane.showMessageDialog(this, "아이디와 비번을 확인하세요.");
			return;
		}
		else {//성공의 경우
			JOptionPane.showMessageDialog(this, nickName+"님을 환영합니다.");
			this.setVisible(false);//메모리상에는 상주하고 있음.
			jtf_id.setText("");
			jpf_pw.setText("");
			//TalkClientVer2
			tc2 = new TalkClientVer2(this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_login) {
			login();
		}else if(obj == jbtn_join) {
			
		}
	}

}








