package alone;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import oracle.net.aso.d;

public class BtnChange extends JFrame implements ActionListener {
	String title;
	JButton jbtn = new JButton("내복이");  //이 괄호를 비우니까 아무것도 안뜨지~
	
	public BtnChange() {
		initDisplay();
	}
	public BtnChange(String title) {
		this.title=title;
		initDisplay();
	}

	
	
	public void initDisplay() {
		BtnChange_Event pEvent = new BtnChange_Event(this);
		
		jbtn.addActionListener(pEvent);
		this.add("North",jbtn);
		this.setTitle(title);
		this.setSize(600, 400);
		this.setVisible(true);
		jbtn.setBackground(new Color(100,200,100));
		jbtn.setForeground(new Color(255,255,200));
		
		
	}
	

      public static void main(String[] args) {
    	  BtnChange i = new BtnChange ();
    	  BtnChange i2 = new BtnChange ("집사의 실습");
	
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}