package alone;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TimeServer extends JFrame implements Runnable{

	ServerSocket sSocket = null;
	Socket socket = null;
	
	List<ServerThread> sThreadlist = null;
	ServerThread sThread = null;
	
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);
	
	public void initDisplay() {
		this.setSize(500,300);
		this.setVisible(true);
		this.setTitle("서버측 로그 출력화면");
		this.add("Center",jsp_log);
	}
	
	@Override
	public void run() {
		sThreadlist = new Vector<ServerThread>();
		try {
			sSocket = new ServerSocket(3000);
			while(true) {
				jta_log.append("접속을 기다립니다!");
				socket = sSocket.accept();
				System.out.println("접속한 클라이언트 정보"+socket.getInetAddress());
			
				jta_log.append(socket+"에 연결되었습니다.");
				
				sThread = new ServerThread(this);
				sThread.start();
			}
			
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		
	}
}
