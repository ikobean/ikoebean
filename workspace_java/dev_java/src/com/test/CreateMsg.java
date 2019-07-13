package com.test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.util.DBConnectionMgr;

public class CreateMsg extends JFrame {
	
	String nick = "뭇매질ㅎ";
	
	JTextField jtf_title = new JTextField();
	JTextField jtf_rec = new JTextField();
	JTextArea jta_cont = new JTextArea();
	
	JButton jbtn_create = new JButton("등록");
	
	public void initDisplay() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
		setLayout(null);
		jtf_title.setBounds(10, 10, 360, 20);
		jtf_rec.setBounds(10, 40, 360, 20);
		jta_cont.setBounds(10, 70, 360, 500);
		jta_cont.setBackground(Color.LIGHT_GRAY);
		jbtn_create.setBounds(150, 600, 100, 30);
		jbtn_create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				create_msg();
			}
		});
		add(jtf_title);
		add(jtf_rec);
		add(jta_cont);
		add(jbtn_create);
		setSize(400, 700);
		setVisible(true);
	}
	
	public void create_msg() {
		String title = jtf_title.getText();
		String rec = jtf_rec.getText();
		String cont = jta_cont.getText();
		connect_process("injang",title,rec,cont);
		
	}
	
	public void connect_process(String nick,String title,String rec,String cont) {
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnectionMgr.getConnection();
			cstmt = con.prepareCall("{call proc_tmsg(?,?,?,?)}");
			cstmt.setString(1, nick);
			cstmt.setString(2, title);
			cstmt.setString(3, rec);
			cstmt.setString(4, cont);
			int result = cstmt.executeUpdate();
			if(result==1) {
				JOptionPane.showMessageDialog(this, "메세지가 전송되었습니다.");
			}
			else {
				JOptionPane.showMessageDialog(this, "메세지 전송 실패...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CreateMsg cm = new CreateMsg();
		cm.initDisplay();

	}

}
