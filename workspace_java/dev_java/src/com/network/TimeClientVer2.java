package com.network;

import java.net.Socket;
/*
 * TimeClientVer2는 스레드가 필요하지 않아요
 * 왜냐하면 클라이언트는 서버를 개설할 필요가 없다.
 * 서버단에서는 서버를 개설한 거 떄문에 runnable 추가를 했지만
 * 얘는 필요 없음. 
 * 1초동안 방치시켰다가 읽고 뿌려주기만 하면 됨.
 */

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeClientVer2 extends JFrame{
	public Socket client = null; //내가 필요한 소켓 정보 하나만...
	//JLabel jlb_time = new JLabel("현재시간",JLabel.CENTER);
	//AddressBook에 생성한 jlb_time에 시간정보를 출력해하니까
	//인스턴스화 하지 않고 AddressBook에서 원본 주소번지를 받아옴.
	
	public JLabel jlb_time = null;
	
public TimeClientVer2(JLabel jlb_time) {
	this.jlb_time = jlb_time;
}


public TimeClientVer2() {

}


	public void initDisplay() {
		this.add("North",jlb_time);
		this.setTitle("내 단말기");
		this.setSize(500, 400);
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {

		TimeClientVer2 tcv2 = new TimeClientVer2();
		tcv2.initDisplay();
		try {
//			tcv2.client = new Socket("192.168.0.187",3000);
			ClientThread ct = new ClientThread(tcv2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
