package com.network1_alone;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import com.network1.Protocol_;

public class TalkClient extends JFrame {
	Login login=null;
	String		nickName = null;
	
	JTabbedPane tp = new JTabbedPane();
	Wait 	wr = new Wait(this); //여기서 oos,ois 생성할 것이므로 원본 주소번지 필요함~
	Message mr = new Message(this);
	
	//소켓선언 - (서버 접속 시도 - 객체 손에 쥐면 oos와 ois생성 해줘야 해)
	Socket mySocket = null;
	String ip = "192.168.0.187";
	int	   port = 5001;
	
	ObjectOutputStream oos = null;
	ObjectInputStream  ois = null;
	
	
	public TalkClient(Login login) {
		this.login = login;
		nickName=login.nickName;
		initDisplay();
		connect_process();
	}


	public void initDisplay() {
		this.getContentPane().setLayout(null);
		tp.addTab("대기실", wr);
		tp.addTab("단톡방", mr);
		tp.setBounds(5, 4, 627, 530);
		this.getContentPane().add(tp,null);
		this.setSize(655,585);
		this.setVisible(true);
		
		//윈도우창 닫을 때 사용자원 반납.
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					System.exit(0);
				} catch (Exception e) {
				}
			}
		});
		
		
		
	}
	
	public void exit_process() {
	
		try {
			oos.writeObject(prtcl.EXIT
					+prtcl.seperator+this.nickName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	
	public void connect_process() {
		this.setTitle(nickName+"님의 채팅방");
		try {
			mySocket=new Socket(ip,port);
			oos = new ObjectOutputStream(mySocket.getOutputStream());
			ois = new ObjectInputStream(mySocket.getInputStream());
			oos.writeObject(prtcl.WAIT
						   +prtcl.seperator+nickName
						   +prtcl.seperator+"대기"	
					);
			TalkClientThread tct = new TalkClientThread(this);
			tct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	


}


