package com.network1;

import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.text.SimpleAttributeSet;

//thread 인스턴스화 - chatlist add
public class TalkClientThread extends Thread {
	TalkClient tc = null;
	public TalkClientThread(TalkClient tc) {
		//TalkClientThread에서 TalkClient 원본을 참조하기 위해서 선언
		//생성자에서 초기화를 함.
 		this.tc=tc;  
	}
	//아이콘처리
	public SimpleAttributeSet makeAttribute() {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		return sas;
	}
	public void run(){
		String msg = null;
		boolean isStop = false;
		while(!isStop) {
			try {
				msg=(String)tc.ois.readObject();
				JOptionPane.showMessageDialog(tc, "msg:"+msg);
				StringTokenizer st = null;
				int protocol = 0;
				if(msg!=null) {
					st =new StringTokenizer(msg, Protocol.seperator);
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol){
					case Protocol.ROOM_IN:{
/*
 * 닉네임을 읽어서 Vector에 담기 -> dtm_name 추가 addRow(v)
 * 화면(jta_display) xxx님이 입장하였습니다.
 */						
						String nickName = st.nextToken();
						Vector<String> v_name = new Vector<>();
						v_name.add(nickName);
						//마지막으로 dtm클래스에 이름 추가하기
						tc.dtm_name.addRow(v_name);
						//화면에 메시지 출력하는 부분
						tc.jta_display.append(nickName+"님이 입장하였습니다.\n");
						tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
					}break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}