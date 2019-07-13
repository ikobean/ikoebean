package com.chat_1;

import java.awt.BorderLayout;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientMain extends JFrame {
	Socket socket = null;
	String cols_room[] = {"채팅방"};
	String cols_mem[] = {"접속자"};
	String data_room[][] = new String[0][];
	String data_mem[][] = new String[0][];
	
	
	JButton jbtn_room = new JButton("채팅방 생성");
	DefaultTableModel dtm_room = new DefaultTableModel(data_room,cols_room);
	DefaultTableModel dtm_mem = new DefaultTableModel(data_mem,cols_mem);
	JTable jt_room = new JTable(dtm_room);
	JTable jt_mem = new JTable(dtm_mem);
	JScrollPane jsp_room = new JScrollPane(jt_room);
	JScrollPane jsp_mem = new JScrollPane(jt_mem);
	JPanel jp_mem = new JPanel();
	
	public void initDisplay() {
		jp_mem.setLayout(new BorderLayout());
		jp_mem.add("Center",jsp_mem);
		jp_mem.add("South",jbtn_room);
		this.add("West",jsp_room);
		this.add("Center",jp_mem);
		this.setSize(700, 500);
		this.setTitle("대기방");
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		ClientMain cm = new ClientMain();
		cm.initDisplay();
		try {
			cm.socket = new Socket("192.168.0.189",7244);
			GetMemListThread getMemThread = new GetMemListThread(cm);
			getMemThread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
