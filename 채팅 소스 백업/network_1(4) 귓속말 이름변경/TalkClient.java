package com.network1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTextField;
import javax.swing.JTextPane;
//클라이언트 측에서는 Runnable하지 않았다. - 단일스레드이다.
//why? - 경합,선택에 따른 지속적인 서비스
// main-> 생성자호출->  initDisplay() -> 서버접속 ->actionPerformed (말하기)
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
public class TalkClient extends JFrame implements ActionListener, MouseListener{
	//속지 세장 추가하기
	JPanel 		jp_first		 = new JPanel();
	JPanel		jp_second			 = new JPanel();
	JPanel 		jp_second_south    = new JPanel();
	//메세지 내역 출력 - 비활성화 함. 이벤트처리 필요 없음
	//JTextArea	jta_display 	 = new JTextArea();
	
	//메세지 전송할 때 - 이벤트 처리 필요(액션퍼폼드)
	JTextField  jtf_msg 		 = new JTextField("메세지를 입력하세요.");
	
	/*
	 * JtextPane에 스타일을 적용하기 위해서는 스타일을 지원하는 클래스를 추가로 맵핑해야 함.
	 * 왜냐하면 문자도 그리는 개념으로 이해해야 하므로 글꼴을 변경하거나 글크기를 변경하는 부분도 반영하려면 필요함
	 * 
	 */
	DefaultStyledDocument sd_display = new DefaultStyledDocument(new StyleContext());
	JTextPane jtp_display 		 = new JTextPane(sd_display);
	JScrollPane jsp_display 	 = new JScrollPane(jtp_display
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
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
	JButton 	jbtn_icon	 	 = new JButton("이모티콘");
	JButton 	jbtn_exit	 	 = new JButton("나가기");
	
	String		nickName = null;
	
	
	//소켓선언 - (서버 접속 시도 - 객체 손에 쥐면 oos와 ois생성 해줘야 해)
	Socket mySocket = null;
	String ip = "192.168.0.187";
	int	   port = 3001;
	//말하기를 어디서 하지? - actionPerformed() - 내 안에서 처리하기
	//듣기 어디서 하지? run()처리-다른 클래스 처리하기   (스레드에서 (듣는 것도 경합이 벌어짐))
	//클래스 사이에는 의존관계가 있다. - Socket 생성이 먼저이고, 그 소켓을 사용해서 oos 생성함.
	ObjectOutputStream oos = null;
	ObjectInputStream  ois = null;
	//이모티콘 객체 생성 추가
	ImoticonMessage imo = new ImoticonMessage(this);
	
	
	
	public TalkClient() {
		nickName = JOptionPane.showInputDialog("대화명을 입력하세요.");
		initDisplay();
		try {
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
		jbtn_icon.addActionListener(this);
		jbtn_whisper.addActionListener(this);
		jbtn_change.addActionListener(this);
		
		this.setLayout(new GridLayout(1,2));
		
		jtf_msg.addActionListener(this);
		jtf_msg.addMouseListener(this);
		
		//윈도우창 닫을 때 사용자원 반납.
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					System.exit(0);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		
		jp_first.setLayout (new BorderLayout());	
		jp_first.add("Center",jsp_display);
		jp_first.add("South",jtf_msg);
		
		jp_second.setLayout (new BorderLayout());	
		jp_second.add("Center",jsp_name);
		
		
		jp_second_south.setLayout (new GridLayout(2,2));
		jp_second_south.add(jbtn_whisper);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_icon);
		jp_second_south.add(jbtn_exit);
		jp_second.add("South",jp_second_south);
		
		
		this.add("Center",jp_first);
		this.add("East", jp_second);
		this.setTitle(nickName+"님의 대화창");
		this.setSize(1000,600);
		this.setVisible(true);
		
	};
	public void exitChat() {
		
	}
	//대화명 변경하기 구현
	public void change_process() {
		//변경할 대화명 받기
		String afterName = JOptionPane.showInputDialog("변경할 대화명을 입력하세요");
		//입력안하거나 한글자인 경우는 안된다!
		if(afterName==null || afterName.length()<2) {
			return;
		}
		try {
			//300|현재대화명|변경대화명|haha가 apple 변경되었다.
			oos.writeObject(Protocol.CHANGE		//300
					+Protocol.seperator+nickName	//닉네임
					+Protocol.seperator+afterName	//바뀐이름
					+Protocol.seperator+nickName+"님의 대화명이"+afterName+"으로 변경되었습니다."//선택한 이모티콘 정보 넘김
					);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//메세지보내기
	public void message_process(String msg, String imgChoice) {//메세지 말아야지~ 200|닉네임|메세지
		//이모티콘 메세지를 전송
		if(msg==null || msg.length()==0) {//이모티콘을 보낼거니?
			msg = "이모티콘";
			try {
				oos.writeObject(Protocol.MESSAGE		//200
					+Protocol.seperator+nickName	//닉네임
					+Protocol.seperator+msg			//이모티콘
					+Protocol.seperator+imo.imgChoice//선택한 이모티콘 정보 넘김
					);	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//텍스트 메세지 전송
		else {
			imo.imgChoice="default"; //이거 안하면 텍스트 써도 이미지로 감
			try {
				oos.writeObject(Protocol.MESSAGE		//200
						+Protocol.seperator+nickName	//닉네임
						+Protocol.seperator+msg			//주말에뭐해?
						+Protocol.seperator+"default"	//주말에뭐해?
						);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		TalkClient tc = new TalkClient();
		
	}
	//말하기인가? 아님 듣기인가?
	//말하기이다!
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		String imgChoice = jtf_msg.getText();
		if(obj==jtf_msg) {
			//다자간 대화하기
			message_process(msg,imgChoice);
			jtf_msg.setText("");
		}else if(obj==jbtn_icon) {
			imo.setVisible(true);
		}else if(obj==jbtn_whisper) {
			//1:1대화하기
			whisper_process();
		}else if(obj==jbtn_change) {
			//대화명 변경
			change_process();
		}
	}
	private void whisper_process() {
		//상대를 선택
		int row = jtb_name.getSelectedRow();
		if(row==-1) { //-1 은 end of file의 의미임. 끝까지 찾았는데 없었다.
			JOptionPane.showMessageDialog(this, "상대를 선택해야지~");
			return; //메소드 탈출
		}else {
			//첫번째 파라미터는 선택한 로우의 값이고 두번째는 가져올 컬럼의 index값임.
			//나를 선택했을 경우?
			String name = (String)dtm_name.getValueAt(row, 0);
			if(nickName.equals(name)) {
				JOptionPane.showMessageDialog(this, "나 말고....");
				return;
			}
			//대화내용을 받기
			String msg = JOptionPane.showInputDialog(name+"님에게 보낼 메시지를 입력하세요.");
			try {
				//210|누가|누구에게|뭐라고......
				oos.writeObject(Protocol.WHISPER
								+Protocol.seperator+nickName
								+Protocol.seperator+name
								+Protocol.seperator+msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		jtf_msg.setText("");
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

