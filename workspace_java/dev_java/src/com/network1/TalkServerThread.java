package com.network1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import com.network2.Protocol;

public class TalkServerThread extends Thread {
	TalkServer ts = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois =        null;
	String nickName = "0"; //사용자의 닉네임 담김

	
	public TalkServerThread(TalkServer ts) {
		this.ts=ts;
		try {
			oos = new ObjectOutputStream(ts.client.getOutputStream());
			ois = new ObjectInputStream(ts.client.getInputStream());
			String msg = (String)ois.readObject();
			ts.jta_log.append(msg+"\n");
			//자동으로 스크롤바 이동시켜주기
			ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
			StringTokenizer st = null;
			if(msg!=null) {
				st = new StringTokenizer(msg,Protocol_.seperator);
			}
			st.nextToken(); //100
			nickName = st.nextToken(); //닉네임담기
			//나 이전에 들어와 있는 친구들에게 메시지 전송하기
			//처음에는 실행이 안되고 밑에서 add가 쳐져서 2명이 되면 for문이 돌기 시작함.
			//. (나 이전에 있던 사람들 목록 뜨는거)
			for (TalkServerThread tst : ts.chatList) {
				String currentName = tst.nickName;
				this.send(Protocol_.ROOM_IN+Protocol_.seperator+currentName);
			}
			//입장한 내 스레드 추가하기
			//(내닉네임) 입장했습니다
			ts.chatList.add(this);
			//현재 서버에 접속해 있는 모든 사람들에게 메시지 전송하기
			this.broadCasting(msg); //클라이언트에 방송 내보내는 코드 //누구 들어왔는지 알려주는거
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//서버에 접속한 모든 사용자들에게 메시지를 전송 처리함.
	public void broadCasting(String msg) { //200|누가|누구에게|오늘스터디할까?
		for(TalkServerThread tst:ts.chatList) {
			tst.send(msg);//this.send(msg), tst.send(msg) 차이?
		}
	}
	//1:1대화를 하기 위해서 이렇게 메소드를 분리해놓음. 설계시 문제
	public void send(String msg) { //반복문은 없다.
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//run메소드 안에서는 무엇을 구현해야 하는걸까?
	public void run() {
	
		boolean isStop = false;
		try {
			run_start://break run_start;
			while(!isStop) {
				String msg = (String)ois.readObject();
				
				ts.jta_log.append(msg+"\n"); //200|나신입|주말에 뭐해?//서버 다이얼로그에 뜨는거네
				//ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
				
				int protocol = 0;
				StringTokenizer st = null;
				if(msg!=null) {
					st = new StringTokenizer(msg,"|"); //파이프연산자로 구분하겠다
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
					case Protocol_.MESSAGE:{
						String nickName = st.nextToken();
						String message = st.nextToken();
						String imgChoice=st.nextToken();
						String fontColor = st.nextToken();
					/*
					 * //내꺼 확인용
					 * 
					 * JOptionPane.showMessageDialog(ts,Protocol_.MESSAGE
					 * +Protocol_.seperator+nickName +Protocol_.seperator+message
					 * +Protocol_.seperator+imgChoice +Protocol_.seperator+fontColor);
					 */
					/*
					 * * JOptionPane.showMessageDialog(ts,Protocol_.MESSAGE+
					 * Protocol_.seperator+nickName + Protocol_.seperator+message+
					 * Protocol_.seperator+imgChoice);
					 */
						//말하기
						this.broadCasting(Protocol_.MESSAGE
										+Protocol_.seperator+nickName
										+Protocol_.seperator+message
										+Protocol_.seperator+imgChoice
										+Protocol_.seperator+fontColor
										);
					}break;
					
					case Protocol_.WHISPER:{
						String nickName = st.nextToken(); //나한테 보내는 사람
						String otherName = st.nextToken(); //내가 할려는 사람이고//받아야되는사람 
						String whispermsg = st.nextToken(); //==쌤꺼 msg1
						for(TalkServerThread tst:ts.chatList) {
							//이름 두번 보내야 돼.==send()호출 두번해야돼. 
							if(otherName.equals(tst.nickName)) {//상대에게 보내는 것.
								tst.send(Protocol_.WHISPER
										+Protocol_.seperator+nickName
										+Protocol_.seperator+otherName
										+Protocol_.seperator+whispermsg);
										break;
							}
						}
						//내가 한 말을 내게 보내는 것.
						this.send(Protocol_.WHISPER
								+Protocol_.seperator+nickName
								+Protocol_.seperator+otherName
								+Protocol_.seperator+whispermsg);
						}break;
					 case Protocol_.CHANGE:{
						 String nickName = st.nextToken();
						 String afterName = st.nextToken();
						 String msg1 = st.nextToken();
						 this.nickName = afterName;//초기화
						 broadCasting(Protocol_.CHANGE
									+Protocol_.seperator+nickName
									+Protocol_.seperator+afterName
									+Protocol_.seperator+msg1);
					 }break;
					 case Protocol_.ROOM_OUT:{//500|나신입
						 String nickName = st.nextToken();
						 String msg1 =nickName+"님이 퇴장하였습니다.";
						 this.broadCasting(Protocol_.ROOM_OUT
								 		  +Protocol_.seperator+nickName
								 		  +Protocol_.seperator+msg1
								 		  );
					 }break run_start;
				}//////////end of switch
			}//////////end of while
		System.out.println("여기");
		} catch (Exception e) {
			e.printStackTrace();
		}/////////////end of try...catch
	}/////////////////end of run
}////////////////////end of class


