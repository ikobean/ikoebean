package com.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;

public class ServerThread extends Thread {
	//서버 측에서는 현재 시간정보를 계산해서 그 정보를 클라이언트 측에 제공함.
	public String currentTime() {
		
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		return (hour < 10 ? "0"+hour:""+hour)
			  +":"+
               (min < 10 ? "0"+min:""+min)
               +":"+
               (sec < 10 ? "0"+sec:""+sec);
	}
	///////////////////////////////////end of currentTime/////////////////////////////////
	
	
	
	Socket socket = null;
	TimeServerVer2 tsv2 = null;
	
	public ServerThread(TimeServerVer2 tsv2 ) {
		this.tsv2=tsv2;
		tsv2.threadList.add(this);
				}
	/************************************************************
	 * thread는 경합을 ㅗ인해 항시 인터셉트가 발생할 수 있다.
	 * 반드시 예외처리 필수 !
	 * 
	 **************************************************************/
	@Override
	public void run() {
		boolean isOk = false;
		PrintWriter out = null;
		try {
			out = new PrintWriter(tsv2.socket.getOutputStream(),true);
			while(!isOk) {
				out.println(currentTime());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					System.out.println("인터셉트를 당한 경우...");
				}
			}//////////////////end of while
			} catch (Exception e) {
		
		}///////////////////end of try...catch
	}//////////////////////end of run
}

