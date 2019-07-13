package com.chat_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

public class GetMemListThread extends Thread {
	ClientMain cm = null;
	public GetMemListThread(ClientMain cm) {
		this.cm = cm;
	}

	@Override
	public void run() {
		boolean stop = false;
		PrintWriter out = null;
		BufferedReader in = null;
		String memInfo = null;
		try {
			out = new PrintWriter(cm.socket.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(cm.socket.getInputStream()));
			while(!stop) {
				Vector memList = new Vector();
				while((memInfo=in.readLine())!=null) {
					memList.add(memInfo);
					cm.dtm_mem.setRowCount(0);
					cm.dtm_mem.addRow(memList);
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
