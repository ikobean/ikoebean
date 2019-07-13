package com.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TimeServerVer2 extends JFrame implements Runnable{
	//동시에 여러 사람 받아줘야 함
	ServerSocket sSocket = null;
	//한 번에 한 사람 정보만 갖고있음. 그래서 여러개 소켓이 필요함.
	Socket socket = null; //클라이언트 정보를 갖고 있는 정보
	
	List<ServerThread> threadList = null;
	ServerThread sThread = null;//클라이언트가 들어왔을 때 생성해줘야 하니까 null
	
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);
	
	public void initDisplay() {
		this.setSize(500,300);
		this.setVisible(true);
		this.setTitle("서버측 로그 출력화면");
		this.add("Center",jsp_log);
	}
	
	/*********************************************************************************
	 * end of initdisplay
	 ***********************************************************************************/
	public static void main(String[] args) {
		TimeServerVer2 tsv2 = new TimeServerVer2();
		tsv2.initDisplay();
		Thread th = new Thread(tsv2);
		th.start();//run 호출된다.
	}
	/*********************************************************************************
	 * end of main
	 ***********************************************************************************/
	@Override
	public void run() {
		//접속한 클라이언트의 정보를 담을 Vector 추가 (멀티스레드 안전)
		threadList = new Vector<ServerThread>();
		
		try {
			sSocket = new ServerSocket(3000);
			
			while(true) {//무한루프에 빠져 있다.
				// \n은 개행처리를 나타내는 특수문자임.
			    jta_log.append("접속을 기다립니다....\n");
				socket = sSocket.accept();
				
				System.out.println
				("접속한 클라이언트측 정보 출력하기==>"+socket.getInetAddress());
				
				jta_log.append(socket+"에 연결되었습니다."+"\n");
				
				sThread = new ServerThread(this);
				sThread.start();
											
			}/////////////////////////end of outer while
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			
			try {
				socket.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//////////////////////end of try... catch
	}	///////////////////////end of run
}//////////////////////////////end of TimeServerVer2
