package com.network2;

import javax.swing.JPanel;

public class WaitRoom extends JPanel {
	//선언부
	TalkClientVer2 tc2 = null;//절대로 인스턴스화 하지 않는다.
	//생성자
	public WaitRoom() {
		
	}
	public WaitRoom(TalkClientVer2 tc2) {
		this.tc2 = tc2;
	}
	//화면처리부
	public void initDisplay() {
		
	}
	//단위테스트 때문에 추가함 - TalkClientVer2에 붙일 것임.
	public static void main(String[] args) {

	}

}

