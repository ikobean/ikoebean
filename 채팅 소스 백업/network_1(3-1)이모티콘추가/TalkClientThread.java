package com.network1;

import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

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
				//JOptionPane.showMessageDialog(tc, "msg:"+msg);
				StringTokenizer st = null;
				int protocol = 0;
				if(msg!=null) {
					st =new StringTokenizer(msg, Protocol.seperator);
					protocol = Integer.parseInt(st.nextToken());
					//protocol에 썰린 protocol 번호가 담겨있음.
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
						//이모티콘 때문에 바꾼거
						SimpleAttributeSet sas= makeAttribute();
						//화면에 메시지 출력하는 부분
						try {
							tc.sd_display.insertString(tc.sd_display.getLength()
														,nickName+"님이 입장하였습니다.\n"
														,sas);
							
						} catch (Exception e) {
						}
					}break;
					case Protocol.MESSAGE:{
						String nickName = st.nextToken(); //자른 거 다음 꺼로 넘어가는고 토크나이저
						String message = st.nextToken();
						String imgChoice = st.nextToken();
						
						MutableAttributeSet attrl = new SimpleAttributeSet();
						if(!imgChoice.equals("default")) {//이모티콘일 때
							int i=0;
							//이모티콘 배열 객체에서 같은 이미지를 찾아서 출력해야 함.
							for(i=0; i<tc.imo.imgFiles.length;i++) {
								if(tc.imo.imgFiles[i].equals(imgChoice)) {
									StyleConstants.setIcon(attrl, new ImageIcon(tc.imo.imgPath+tc.imo.imgFiles[i]));
									
								}
								
							}
							try {
								tc.sd_display.insertString(tc.sd_display.getLength() //문자열 개수 세어줘
															,"\n"		//줄바꿈처리
															, attrl); //속성적용
							} catch (Exception e) {
								
							}
						}else if(imgChoice.equals("default")){//아닐 때
							try {
								tc.sd_display.insertString(tc.sd_display.getLength()
															,"["+nickName+"]"+" : " + message + "\n"
															, null);
							} catch (Exception e) {

							}
						}
						tc.jtp_display.setCaretPosition(tc.sd_display.getLength());
					}break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
