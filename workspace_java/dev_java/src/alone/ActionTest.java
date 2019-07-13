package alone;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionTest extends JFrame implements java.awt.event.ActionListener {
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JButton btn = new JButton("클릭");
	
	
	public void test() {
			jf.setSize(400,200);
			jf.add(jp);
			jp.add(btn);
			jp.setSize(300,200);
			jf.setVisible(true);
			btn.addActionListener(this); //여기서 this는 전변 btn"??
			
			
		}
	public static void main(String[] args) {
		ActionTest at = new ActionTest();
		at.test();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 Object obj = e.getSource();
		System.out.println("눌렸다");
		if(obj==btn) {
			btn.setText("잉");
			btn.setBackground(new Color(100,200,200));
		}
		
		
		
	}

}
