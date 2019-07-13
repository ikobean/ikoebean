package com.network;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
/*
 * 지연이 벌어지는 상황을 직접 연출해보기
 * 
 */
public class ServerTest extends JFrame {
	
	ServerSocket sSocket = null;
	Socket socket=  null;
	
	public void initDisplay() {
		this.setSize(500,300);
		this.setVisible(true);
	}
	//동시에 여러사람이 접속할 수도 있으니까
	//이 메소드를 run 메소드로 바꿔서 처리하려면 timeserverver2도 스레드로 처리해야함~
	public void serverInit() {
		try {
			sSocket = new ServerSocket(5000);
			System.out.println("접속을 기다리는 중!");
			while(true) {
				socket = sSocket.accept();
				System.out.println("클라이언트가 접속했다!"+socket);
		}} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		ServerTest st = new ServerTest();
		//서버측에서 클라이언트가 접속해 올 때 까지 대기상태에 빠지게 됨.
		//따라서 화면이 열리지 않음.
		//두 번째 문제는 여러 사용자가 동시에 또는 시간차를 두고
		//서버에 접속을 시도하게 됨에 따라 경합상태에 빠지게 됨. -불안정한 상태
		st.serverInit();
		st.initDisplay();

	}

}
