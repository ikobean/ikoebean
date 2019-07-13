package com.network1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//클라이언트 측에서는 Runnable하지 않았다. - 단일스레드이다.
//why? - 경합,선택에 따른 지속적인 서비스
// main-> 생성자호출->  initDisplay() -> 서버접속 ->actionPerformed (말하기)
import javax.swing.table.DefaultTableModel;
public class TalkClient extends JFrame implements ActionListener{
	//속지 세장 추가하기
	JPanel 		jp_center		 = new JPanel();
	JPanel		jp_east			 = new JPanel();
	JPanel 		jp_east_south    = new JPanel();
	//메세지 내역 출력 - 비활성화 함. 이벤트처리 필요 없음
	JTextArea	jta_display 	 = new JTextArea();
	JScrollPane jsp_display 	 = new JScrollPane(jta_display
												  ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
												  ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//메세지 전송할 때 - 이벤트 처리 필요(액션퍼폼드)
	JTextField  jtf_msg 		 = new JTextField("메세지를 입력하세요.");
	
	String cols[] = {"닉네임"};
	String data[][] = new String[0][1];
	//실제 정보를 담을 객체 선언
	DefaultTableModel dtm_name 	 = new DefaultTableModel(data, cols);
	//화면을 처리해줄 객체
	JTable	  	jtb_name		 = new JTable(dtm_name);
	JScrollPane jsp_name 	 = new JScrollPane(jtb_name
			  ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			  ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JButton 	jbtn_whisper	 = new JButton("1:1대화");
	JButton 	jbtn_change	 	 = new JButton("대화명변경");
	JButton 	jbtn_blank	 	 = new JButton("blank");
	JButton 	jbtn_exit	 	 = new JButton("나가기");
	
	String		nickName = null;
	
	
	//소켓선언 - (서버 접속 시도 - 객체 손에 쥐면 oos와 ois생성 해줘야 해)
	Socket mySocket = null;
	String ip = "192.168.0.24";
	int	   port = 3001;
	//말하기를 어디서 하지? - actionPerformed() - 내 안에서 처리하기
	//듣기 어디서 하지? run()처리-다른 클래스 처리하기   (스레드에서 (듣는 것도 경합이 벌어짐))
	//클래스 사이에는 의존관계가 있다. - Socket 생성이 먼저이고, 그 소켓을 사용해서 oos 생성함.
	ObjectOutputStream oos = null;
	ObjectInputStream  ois = null;
	public TalkClient() {
		nickName = JOptionPane.showInputDialog("대화명을 입력하세요.");
		try {
			initDisplay();
			mySocket = new Socket(ip, port);
			//actionPerformed
			oos = new ObjectOutputStream(mySocket.getOutputStream());
			//스레드에서 사용 run()
			ois = new ObjectInputStream(mySocket.getInputStream());
			//서버에 내가 로그인 했음을 알림.(말하기)
			oos.writeObject(Protocol.ROOM_IN
						   +Protocol.seperator
						   +nickName);
			TalkClientThread tct = new TalkClientThread(this);
			tct.start();//run메소드 호출됨- 콜백함수
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initDisplay() {
		
		//윈도우창 닫을 때 사용자원 반납.
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					if(mySocket!=null) {
						mySocket.close();
						mySocket=null;
					}
					System.exit(0);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		jp_center.setLayout (new BorderLayout());	
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_msg);
		
		jp_east.setLayout (new BorderLayout());	
		jp_east.add("Center",jsp_name);
		
		
		jp_east_south.setLayout (new GridLayout(2,2));
		jp_east_south.add(jbtn_whisper);
		jp_east_south.add(jbtn_change);
		jp_east_south.add(jbtn_blank);
		jp_east_south.add(jbtn_exit);
		jp_east.add("South",jp_east_south);
		
		
		this.add("Center",jp_center);
		this.add("East", jp_east);
		this.setTitle(nickName+"님의 대화창");
		this.setSize(1000,600);
		this.setVisible(true);
		
	};
	public void exitChat() {
		
	}
	public void message_process(String msg) {
		
	}
	
	public static void main(String[] args) {
		TalkClient tc = new TalkClient();
	}
	//말하기인가? 아님 듣기인가?
	//말하기이다!
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}

}
