package alone;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;

public class ServerThread extends Thread {
	
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
	Socket socket = null;
	TimeServer ts = null;
	
	public ServerThread(TimeServer ts) {
		this.ts = ts;
		ts.sThreadlist.add(this);
	}
	
	@Override
	public void run() {
		boolean isOk = false;
		PrintWriter out = null;
		try {
			out = new PrintWriter(ts.socket.getOutputStream(),true);
			while(!isOk) {
				out.println(currentTime());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
