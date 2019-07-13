package com.network1_alone;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//main -> initDisplay -> run ->대기
public class TalkServer extends JFrame implements Runnable {
	//동시에 여러 접속자에 대한 소켓 정보를 안정적으로 수집하기 위해.
	ServerSocket server = null;
	Socket mySocket=null;
	//서버소켓에 접속해 온 소켓 정보를 일반 소켓이 받음.
	Socket client = null;
	
	//사용자가 접속을 해오면 접속해 온 사용자를 스레드로 관리함.
	TalkServerThread tst = null;
	List<TalkServerThread> chatList = null;
	
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);
	
	
	public TalkServer() {
		
		
	}
	public void initDisplay() {
		add("Center",jsp_log);
		setTitle("서버로그");
		setSize(500,400);
		setVisible(true);
		
		//윈도우창 닫을 때 사용자원 반납.
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					if(mySocket !=null) {
						mySocket.close();
						mySocket=null;
					}
					System.exit(0);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
	}
	@Override
	public void run() {
		//Vector 안에 있는 스레드는 누구에 대한 정보를 갖고 있나요?
		//서버에 입장한 사용자에 대한 정보를 가짐         클라이언트 정보
		
		//이 스레드는 언제 생성하면 될까요?
		//서버에 임장이 결정되면 즉시! 		//접속했을 때, 클라이언트가 왔을때.
		
		//이 스레드는 언제 chatList에 담으면 될까요?
		//서버에 사용자에 대한 대화명이 접수되면 그 때 추가하면 됨 		//손님 왔을 때.
		
		//스레드의 인스턴스 변수를 활용하여 서버측에 어떤 변수를 접근해야 할까요?
		// 일반 소켓과 TalkServer의 주소번지 		
		
		
		//서버에서 듣기는 어디서 이루어지면 될까요?
		// run()안에서 
		
		//서버에서 말하기는 언제 처리하면 될까요?
		// run()안에서 듣기가 완료되면 즉시 내보내야 함.
		
		chatList = new Vector<TalkServerThread>();
		boolean isStop = false;
		try {
			//서버에서 포트를 결정하고 서버를 열어줌.
			server = new ServerSocket(3001);
			while(!isStop) {
				//사용자 측에서 서버에 ip와 port번호를 가지고 인스턴스화를 하면
				//서버소켓은 사용자에 대한 정보를 가지게 됨.
				//그 정보를 일반소켓에게 넘겨서 oos와 ois를 생성하고 사용하게 됨.
				//나 서버 들어왔어!
				client = server.accept();
				//클라이언트측 정보 출력하기
				jta_log.append(client.toString()+"\n");
				tst = new TalkServerThread(this); //객체주입
				//이렇게 함으로써 토크 서버 스레드에서 토크 서버에 있는 애들을 쓸 수 있음.
				//원래 있던 객체에 대한 주소를 알고있어야 함.
				//사용자의 정보를 관리할 스레드 기동하기
				tst.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public static void main(String[] args) {
		TalkServer ts = new TalkServer();
		ts.initDisplay();
		new Thread(ts).start(); //내 안에 있는 run 메소드 호출
	}

}

