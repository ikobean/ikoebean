package Rental;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class MainView implements ActionListener {
	
	public  MainView() {
	
	}
	public static void main(String []args) {
		MainView mv = new MainView();
		mv.initDisplay();
	}
	
	JFrame jf_rental = new JFrame();
	
	//JPanel jp_north = new JPanel(); 
	JPanel jp_center = null; 
	
	JPanel jp_north_second = new JPanel();
	JPanel jp_north_first = new JPanel();  
	JMenuBar jmb_rental = new JMenuBar();
	
	JMenu    jm_file = new JMenu("파일");
	
	JMenuItem jmi_save = new JMenuItem("저장");
	JMenuItem jmi_search = new JMenuItem("검색");
	JMenuItem jmi_print = new JMenuItem("인쇄"); 
	JMenuItem jmi_backup = new JMenuItem("백업");
	JMenuItem jmi_exit = new JMenuItem("나가기");
	
	JButton   jbtn_member = new JButton("회원관리");
	JButton   jbtn_rent   = new JButton("대여관리");
	JButton   jbtn_prod = new JButton("상품관리");
	JButton   jbtn_money = new JButton("매출관리");
	
	
	
	public void initDisplay() {
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowActivated(WindowEvent e) {
			}
			@Override
			public void windowClosed(WindowEvent e) {
			}
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("11");
				System.exit(0);
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowOpened(WindowEvent e) {
			}
		});
		

			
		
		//jp_north.setLayout(new GridLayout(2,1));
		jp_north_second.setLayout(new FlowLayout(FlowLayout.LEFT));

		
		
		jf_rental.setTitle("RENTAL 관리 시스템 Ver2.0");
		
		jm_file.add(jmi_save);
		jm_file.add(jmi_search);
		jm_file.add(jmi_print);
		jm_file.add(jmi_backup);
		jm_file.add(jmi_exit);
		jmb_rental.add(jm_file);
		
		jmb_rental.add(jbtn_member);
		jmb_rental.add(jbtn_rent);
		jmb_rental.add(jbtn_prod);
		jmb_rental.add(jbtn_money);
		
		jmb_rental.setBackground(new Color(255,255,255,255));
		
		
		jbtn_member .setBackground(new Color(200,191,231));
		jbtn_member .setForeground(new Color(255,255,255));
		
		jbtn_rent.setBackground(new Color(100,200,200));
		jbtn_rent.setForeground(new Color(255,255,255));
		
		jbtn_prod.setBackground(new Color(200,191,231));
		jbtn_prod.setForeground(new Color(255,255,255));
		
		jbtn_money.setBackground(new Color(100,200,200));
		jbtn_money.setForeground(new Color(255,255,255));
		
		
		jm_file.setBackground(new Color(200,191,231));
		jm_file.setForeground(new Color(255,255,255));
		
		
		//////////////////////////////////////////////////////////////////
		jf_rental.setJMenuBar(jmb_rental);
		//jp_north.add(jp_north_second);
		//jp_north.add(jp_north_first);
		//jf_rental.add("North", jp_north);
		jf_rental.setSize(1200, 550);
		jf_rental.setVisible(true);
	}
	
	/****************************************************************************
	 * 멤버 
	 ****************************************************************************/
	Container cont = null;/////////리스너 

	protected void rentClickPerformed(MouseEvent e) {
		Object obj = e.getSource();
		cont= this.getContentPane();
		if(jp_center!=null) {
			cont.remove(jp_center);
			jp_center=null;
		}
		 //jp_center = new SubRentalManager();
		cont.revalidate();
		
	}

	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}
	private void addWindowListener(WindowListener windowListener) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
