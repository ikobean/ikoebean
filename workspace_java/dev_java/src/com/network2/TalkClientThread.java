package com.network2;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

//thread 인스턴스화 - chatlist add
public class TalkClientThread extends Thread {
	
	TalkClientVer2 tc2 = null;
	
	public TalkClientThread(TalkClientVer2 tc2) {
		//TalkClientThread에서 TalkClient 원본을 참조하기 위해서 선언
		//생성자에서 초기화를 함.
		
 		this.tc2=tc2;  
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
				msg=(String)tc2.ois.readObject();
				//JOptionPane.showMessageDialog(tc2, "msg:"+msg);
				StringTokenizer st = null;
				int protocol = 0;
				if(msg!=null) {
					st =new StringTokenizer(msg, Protocol.seperator);//msg를 |로 썰겠다.!!
					protocol = Integer.parseInt(st.nextToken());
					//protocol에 썰린 protocol 번호가 담겨있음.
				}
				switch(protocol){
					case Protocol.WAIT:{
						//System.out.println("ㅎㅇ");
						//JOptionPane.showMessageDialog(tc2, "WAIT");
						String nickName=st.nextToken();
						String state=st.nextToken();
						Vector<String> v_nick = new Vector<>();
						v_nick.add(nickName);
						v_nick.add(state);
						tc2.wr.dtm_wait.addRow(v_nick);
						//테이블 스크롤바를 자동 위치 변경
						tc2.wr.jsp_wait.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
							@Override
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar)e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});
					}break;
					case Protocol.ROOM_CREATE:{
						String roomTitle = st.nextToken();
						String currentNum = st.nextToken();
						Vector<String> v_room = new Vector<>();
						v_room.add(roomTitle);
						v_room.add(currentNum);
						tc2.wr.dtm_room.addRow(v_room);
						tc2.wr.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
							@Override
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar)e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});
					}break;
					case Protocol.ROOM_LIST:{
						String roomTitle = st.nextToken();
						String currentNum = st.nextToken();
						Vector<String> v_room = new Vector<>();
						v_room.add(roomTitle);
						v_room.add(currentNum);
						tc2.wr.dtm_room.addRow(v_room);
						tc2.wr.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
							@Override
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar)e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});
					}break;
					case Protocol.ROOM_IN:{
					//정보 가져오기
						String roomTitle=st.nextToken();
						String current = st.nextToken();
						String nickName = st.nextToken();
						
					//단톡 인원 정보 갱신처리 -단톡명을 비교하여 갱신처리
						JOptionPane.showMessageDialog(tc2, "인원수갱신");
						for(int i=0; i<tc2.wr.jtb_room.getRowCount();i++) {
							if(roomTitle.equals(tc2.wr.dtm_room.getValueAt(i, 0))) {
								//1)인원수, 2)로우의 값, 3)두번 째 컬럼-인원수
								//DefaultTableModel이 실제 값을 가질 수 있는 클래스
								//JTable은 화면만 제공할 뿐
								//JScrollPane 속지이고 스크롤바만 제공
								tc2.wr.dtm_room.setValueAt(current, i, 1);
								break;
							}
						}
					//대기실 위치 - 닉네임을 비교하여 갱신처리
						JOptionPane.showMessageDialog(tc2, "대기실 위치 갱신");
						for(int i =0; i<tc2.wr.jtb_wait.getRowCount();i++) {
							//JOptionPane.showMessageDialog(tc2, "nickName:"+nickName+","+(String));
							//내 대화명과 dtm_wait(왼쪽)에 있는 데이터 중에서 첫번째 (대화명)과 같은지 비교함
							//변수 i는 로우값이고 0은 컬럼정보니까 대화명 
							//"무사".equals("무사")
							if(nickName.equals((String)tc2.wr.dtm_wait.getValueAt(i, 0))) {
								//i번째 로우의 두번째 컬럼(위치)-대기==>roomTitle[자바52기]로 변경
								tc2.wr.dtm_wait.setValueAt(roomTitle, i, 1);
							}
						}
					//messageroom추가
						//단톡명을 누른 사람만 화면 이동처리 - MessageRoom
						//tc2.nickName - 내대화명
						//nickName - 서버에서 전송된 대화명
						//이 둘을 비교해서 같니?
						if(tc2.nickName.equals(nickName)) {
							//WaitRoom화면에서 MessageRoom화면으로 이동처리
							tc2.tp.setSelectedIndex(1); //0이면 wait room
							//MessageRoom화면의 오른쪽 테이블에 내 대화명을 추가
							for(int x=0; x<tc2.wr.jtb_wait.getRowCount();x++) {
								if(roomTitle.equals(tc2.wr.dtm_wait.getValueAt(x, 1))) {
									//내 정보는 WaitRoom에 dtm_wait 에서 이름을 가져와서 배열에 담기
									String imsi[]= {(String)tc2.wr.dtm_wait.getValueAt(x, 0)};
									tc2.mr.dtm_name.addRow(imsi);
								}
							}
						}
					}break;
					//
					case Protocol.ROOM_INLIST:{
						String roomTitle= st.nextToken();
						String currentName= st.nextToken();
						String nickName = st.nextToken();
						Vector<String> v_room = new Vector<>();
						v_room.add(nickName);
						tc2.mr.dtm_name.addRow(v_room);
					}break;
					case Protocol.MESSAGE:{
						String nickName = st.nextToken(); //자른 거 다음 꺼로 넘어가는고 토크나이저
						String message = st.nextToken();
						String imgChoice ="";
						while(st.hasMoreTokens()) {
							imgChoice = st.nextToken();
						}
						MutableAttributeSet attrl = new SimpleAttributeSet();
						if(!imgChoice.equals("default")) {//이모티콘일 때
							int i=0;
							//이모티콘 배열 객체에서 같은 이미지를 찾아서 출력해야 함.
							for(i=0; i<tc2.mr.imo.imgFiles.length;i++) {
								if(tc2.mr.imo.imgFiles[i].equals(imgChoice)) {
									StyleConstants.setIcon(attrl, new ImageIcon(tc2.mr.imo.imgPath+tc2.mr.imo.imgFiles[i]));
								}
							}
							try {
								tc2.mr.sd_display.insertString(tc2.mr.sd_display.getLength() //문자열 개수 세어줘
															,"\n"		//줄바꿈처리
															, attrl); //속성적용
							} catch (Exception e) {
							}
						}else if(imgChoice.equals("default")){//텍스트일 때
							try {
								tc2.mr.sd_display.insertString(tc2.mr.sd_display.getLength()
															,"["+nickName+"]"+" : " + message + "\n"
															, null);
							} catch (Exception e) {
							}
						}
						tc2.mr.jtp_display.setCaretPosition(tc2.mr.sd_display.getLength());
					}break;
					case Protocol.WHISPER:{
						String fromName = st.nextToken();
						String toName = st.nextToken();
						String message = st.nextToken();
						try {
							tc2.mr.sd_display.insertString(tc2.mr.sd_display.getLength()
														,fromName+"님이"+toName+"님에게"+message+"\n"
														,null);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}break;
					case Protocol.CHANGE:{
						//대화내용 잘라서 받기
						//테이블 대화명 변경하기
						//변경된 대화명 메시지 출력
						//채팅창 타이틀도 변경처리
						String nickName = st.nextToken();
						String afterName = st.nextToken();
						String msg1 = st.nextToken();
						for(int i =0; i<tc2.mr.dtm_name.getRowCount();i++) {
							//기존 대화명 가져오기
							String currentName =(String)tc2.mr.dtm_name.getValueAt(i, 0);
							if(currentName.equals(nickName)) {
								tc2.mr.dtm_name.setValueAt(afterName, i, 0);
								break;
							}
							try {
								//첫번째 파라미터는 이모티콘 때문에 위치를 얻음.
								//두번째 파라미터는 출력할 메시지
								//세번째 파라미터는 스타일 적용하기 - 글꼴, 글자크기, 글자색......
								tc2.mr.sd_display.insertString(tc2.mr.sd_display.getLength()
										,msg1+"\n"
										,null);
							} catch (Exception e) {
								// TODO: handle exception
							}
							System.out.println("여기실행중");
							tc2.mr.jtp_display.setCaretPosition(tc2.mr.sd_display.getLength()); //자동으로 스크롤바 옮겨주는거
							if(nickName.equals(tc2.nickName)) {
								tc2.setTitle(afterName+"님의 대화창");
								tc2.nickName = afterName; //전역변수 활용능력, 초기화
							}
						}
					}break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


