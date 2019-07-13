package com.network2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import com.network2.Protocol;

public class TalkServerThread extends Thread {
	TalkServer ts = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois =        null;
	String nickName = null; //사용자의 닉네임 담김
	String g_title = null; //대기이거나 톡방명
	int g_current = 0;		//톡방에 참여자 수 
	
	public TalkServerThread(TalkServer ts) {
		
		this.ts=ts;
		try {
			oos = new ObjectOutputStream(ts.client.getOutputStream());
			ois = new ObjectInputStream(ts.client.getInputStream()); //클라이언트가 말한 소켓정보가 들어있음.
			String msg = (String)ois.readObject(); //
			ts.jta_log.append(msg+"\n");
			//자동으로 스크롤바 이동시켜주기
			ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
			StringTokenizer st = null;
			if(msg!=null) {
				st = new StringTokenizer(msg,Protocol.seperator);
			}
			if(st.hasMoreTokens()) {
				st.nextToken();//100
				nickName=st.nextToken(); //닉네임담기
				g_title =st.nextToken(); //톡방명
				
			}
			//나 이전에 들어와 있는 친구들에게 메시지 전송하기
			//처음에는 실행이 안되고 밑에서 add가 쳐져서 2명이 되면 for문이 돌기 시작함.
			//. (나 이전에 있던 사람들 목록 뜨는거)
			for (TalkServerThread tst : ts.globalList) {
				//System.out.println("냐");
				JOptionPane.showMessageDialog(ts, "globalList전송");
				String currentName = tst.nickName;
				String currentState = tst.g_title;
				this.send(Protocol.WAIT
						+Protocol.seperator+currentName //110|이름
						+Protocol.seperator+currentState); //110|이름
				//여기서 this는 나를 제외한 이미 들어와있던 사람들임. 왜냐면 아직 내가 리스트에 추가가 되지 않았기 때문에!
			}
			//////////////////////톡방목록 처리////////////////////////////
			/*
			 * 기존에 입장한 친구들은 단톡명을 받게 되지만 추가로 입장한 친구는 단톡명 정보를 받지 못하고 있다.
			 * 이 경우를 고려하여 ROOM_LIST를 추가함.
			 * 
			 */
			for(int i=0; i<ts.roomList.size();i++) {
				Room room = ts.roomList.get(i);
				String title = room.title;
				g_title = title;
				int current = 0;
				if(room.userList!=null && room.userList.size()!=0) {
					current = room.userList.size();
				}
				g_current = current;
				this.send(Protocol.ROOM_LIST
						+Protocol.seperator+g_title
						+Protocol.seperator+g_current
						);
			}
			//////////////////////톡방목록 처리////////////////////////////
			//입장한 내 스레드 추가하기
			//(내닉네임) 
			ts.globalList.add(this);
			//현재 서버에 접속해 있는 모든 사람들에게 메시지 전송하기
			this.broadCasting(msg); //클라이언트에 방송 내보내는 코드 //누구 들어왔는지 알려주는거
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void broadCasting(String msg) {
		//동기화 처리 추가하기 - 절대 인터셉트 당하지 않음
		synchronized (this) {
			for(TalkServerThread tst: ts.globalList) {
				tst.send(msg);
			}
		}
	}
	
	//서버에 접속한 사용자 중에서 톡방에 참여한 사용자들에게 메시지를 전송 처리함.
	public void roomCasting(String msg) { //200|누가|누구에게|오늘스터디할까?
		for(int i=0; i<ts.roomList.size();i++) {
			Room room = ts.roomList.get(i);
			if(g_title.equals(room.title)) {
				for(int j=0; j<room.userList.size();j++) {
					TalkServerThread tst = room.userList.get(j);
					try {
						tst.send(msg);
					} catch (Exception e) {
						room.userList.remove(j--); //원래 상태로 되돌리기
					}
				}/////////////////////////////end of inner for
				break;
			}
		}/////////////////////////////////////end of outter for
	}/////////////////////////////////////////end of broadCasting
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
					case Protocol.ROOM_CREATE:{
						String roomTitle=st.nextToken();
						String currentNum=st.nextToken();
						Room room = new Room(roomTitle, Integer.parseInt(currentNum));
						ts.roomList.add(room);
						this.broadCasting(Protocol.ROOM_CREATE
										 +Protocol.seperator+roomTitle
										 +Protocol.seperator+currentNum
										 );
					}
					case Protocol.MESSAGE:{
						String nickName = st.nextToken();
						String message = st.nextToken();
						String imgChoice="";
						while(st.hasMoreTokens()) {
							imgChoice = st.nextToken();
						}
					/*
					 * //내꺼 확인용 JOptionPane.showMessageDialog(ts,Protocol.MESSAGE+
					 * Protocol.seperator+nickName + Protocol.seperator+message+
					 * Protocol.seperator+imgChoice);
					 */
						//말하기
						this.broadCasting(Protocol.MESSAGE
										+Protocol.seperator+nickName
										+Protocol.seperator+message
										+Protocol.seperator+imgChoice
										);
					}break;
					
					case Protocol.WHISPER:{
						String nickName = st.nextToken(); //나한테 보내는 사람
						String otherName = st.nextToken(); //내가 할려는 사람이고//받아야되는사람 
						String whispermsg = st.nextToken(); //==쌤꺼 msg1
						for(TalkServerThread tst:ts.globalList) {
							//이름 두번 보내야 돼.==send()호출 두번해야돼. 
							if(otherName.equals(tst.nickName)) {//상대에게 보내는 것.
								tst.send(Protocol.WHISPER
										+Protocol.seperator+nickName
										+Protocol.seperator+otherName
										+Protocol.seperator+whispermsg);
										break;
							}
						}
						//내가 한 말을 내게 보내는 것.
						this.send(Protocol.WHISPER
								+Protocol.seperator+nickName
								+Protocol.seperator+otherName
								+Protocol.seperator+whispermsg);
						}break;
					 case Protocol.CHANGE:{
						 String nickName = st.nextToken();
						 String afterName = st.nextToken();
						 String msg1 = st.nextToken();
						 this.nickName = afterName;//초기화
						 broadCasting(Protocol.CHANGE
									+Protocol.seperator+nickName
									+Protocol.seperator+afterName
									+Protocol.seperator+msg1);
					 }break;
					 case Protocol.ROOM_OUT:{
						 String nickName = "";
					 }break run_start;
				}//////////end of switch
				}//////////end of while
		} catch (Exception e) {
			e.printStackTrace();
		}/////////////end of try...catch
	}/////////////////end of run
}////////////////////end of class


