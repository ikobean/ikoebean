package com.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
		TimeClientVer2 tcv2 = null;
		
		public ClientThread(TimeClientVer2 tcv2) {
			this.tcv2=tcv2;
		}
		
		@Override //메소드 이름이 같으면서 상속관계가 있을 때만
				//overloading은 상속관계 상관 x
		public void run() {
			//서버쪽에 이야기하고 싶을 때 사용할 객체
			PrintWriter out = null;
			//서버측에서 말한 것을 들을 때 사용할 객체
			BufferedReader in = null;
			//서버측에서 들은 내용을 담을 변수 선언
			String timeInfo = null;
			try {
				tcv2.client = new Socket("192.168.0.187",3000);
				//사용자가 설치한 (혹은 가진 단말기) 어플에서 말해야 하니까
				//소켓객체를 활용하여 객체 생성을 해야함.
				out = new PrintWriter(					
						tcv2.client.getOutputStream(),true);
				//위와 동일한 이유로 듣기 필요한 객체를 생성하였음.
				in = new BufferedReader(
						new InputStreamReader(
								tcv2.client.getInputStream()));
				//한 번만 듣는 것이 아니라 1초간격으로 지속적으로 들어야함.
				//따라서 반복문 처리하였음.
				while(true) {
					while((timeInfo=in.readLine())!=null) {
						//timeInfo에는 17:40:35 시간 정보가 담겨있으므로
						//그 정보를 북쪽에 JLabel에 출력하는 메소드 호출함.
						tcv2.jlb_time.setText(timeInfo);
						//한 번 출력을 하면 1초동안 지연시켰다가 다시 setText 호출함
						Thread.sleep(1000);
						//아직 반복문이 끝나지 않았으므로 다시 위로 올라가서
						//다시 시간정보를 while문 안에서 읽고 timeInfo변수에 다시 시간정보를 담음
					}
				}
				
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
					out.close();
					tcv2.client.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

}
