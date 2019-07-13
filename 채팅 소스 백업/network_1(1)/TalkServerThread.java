package com.network1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
	TalkServer ts = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois =        null;
	String nickName = null; //사용자의 닉네임 담김
	
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
				st = new StringTokenizer(msg,Protocol.seperator);
			}
			st.nextToken(); //100
			nickName = st.nextToken(); //닉네임담기
			//나 이전에 들어와 있는 친구들에게 메시지 전송하기
			for (TalkServerThread tst : ts.chatList) {
				String currentName = tst.nickName;
				this.send(Protocol.ROOM_IN+Protocol.seperator+currentName);
			}
			//입장한 내 스레드 추가하기
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
	public void send(String msg) { //반복문은 없다.
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//run메소드 안에서는 무엇을 구현해야 하는걸까?
	public void run() {
		
	}
}

