package com.network2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;

import com.network2.Protocol;

public class MessageRoom extends JPanel implements ActionListener, MouseListener{
	//선언부
	TalkClientVer2 tc2 = null;
	
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
	
	ImoticonMessage imo = new ImoticonMessage(this);
	//생성자
	public MessageRoom() {
		
	}
	public MessageRoom(TalkClientVer2 tc2) {
		this.tc2 = tc2;
		initDisplay();
		
	}
	//화면처리부
	public void initDisplay() {
		jbtn_icon.addActionListener(this);
		jbtn_whisper.addActionListener(this);
		jbtn_change.addActionListener(this);
		jtf_msg.addActionListener(this);
		jtf_msg.addMouseListener(this);
		
		this.setLayout(new GridLayout(1,2));
		
		
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
		this.setSize(1000,600);
		this.setVisible(true);
		
		
	}
	
	//메세지보내기
		public void message_process(String msg, String imgChoice) {//메세지 말아야지~ 200|닉네임|메세지
			//이모티콘 메세지를 전송
			if(msg==null || msg.length()==0) {//이모티콘을 보낼거니?
				msg = "이모티콘";
				try {
					tc2.oos.writeObject(Protocol.MESSAGE		//200
						+Protocol.seperator+tc2.nickName	//닉네임
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
					tc2.oos.writeObject(Protocol.MESSAGE		//200
							+Protocol.seperator+tc2.nickName	//닉네임
							+Protocol.seperator+msg			//주말에뭐해?
							+Protocol.seperator+"default"	//주말에뭐해?
							);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	//단위테스트 때문에 추가함 - TalkClientVer2에 붙일 것임.
	public static void main(String[] args) {
	
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		String imgChoice = jtf_msg.getText();
		
		if(obj==jtf_msg) {
			//다자간 대화하기
			message_process(msg,imgChoice);
			//jtf_msg.setText("");
			
		}else if(obj==jbtn_icon) {
			imo.setVisible(true);
			
		}
		
	}/////////////////////////end of actionPerformed///////////////////////
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		if(obj==jtf_msg) {
			jtf_msg.setText("");
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


