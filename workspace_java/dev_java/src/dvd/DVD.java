package dvd;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DVD extends JFrame implements ActionListener {
	//선언부
	JPanel jp_north= new JPanel();
	JPanel jp_center = new JPanel();
	JButton jbtn_member= new JButton("회원관리");
	JButton jbtn_dvd= new JButton("DVD목록");
	
	
	String cols[] = {"ID", "이름","HP"};
	String data[][] = new String[3][3];
	
	DefaultTableModel dtm_member = new DefaultTableModel(data,cols);
	//생성자의 파라미터에 DefaultTableModel 주소번지를 넘겨서 화면과 테이블을 동기화
	JTable 			jt_member = new JTable(dtm_member);
	JTableHeader    jth_member = jt_member.getTableHeader();
	JScrollPane     jsp_member = new JScrollPane(jt_member);
	
	//생성자
	public DVD() {
	
		
	}
	
	//화면처리하겠다
	private void initDisplay() {
		//이 코드가 없으면 이벤트 감지는 안일어남.
		
		jp_center.setAlignmentX(CENTER_ALIGNMENT);
		jt_member.setAlignmentX(CENTER_ALIGNMENT);
		jbtn_member.addActionListener(this);
		jbtn_dvd.addActionListener(this);
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT)); //디폴트는 중앙정렬
		jp_north.add(jbtn_member);
		jp_north.add(jbtn_dvd);
		jp_center.setLayout(new BorderLayout());
		jp_center.add(jsp_member);
		this.add("North", jp_north);
		this.add("Center", jp_center);
		this.setSize(700,500);
		this.setVisible(true);
		
		
	}
	//메인메소드
	public static void main(String[] args) {
		DVD dvd = new DVD();
		dvd.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_dvd) {
			//JFrame아래 컨테이너가 존재한다.
			//갱신처리를 위해서는 remove() 사용해야 한다.
			//그래서 컨테이너 생성함!
			Container cont = this.getContentPane(); //컨테이너 객체 생성
			if(jp_center!=null) {
				//remove()호출할 때 파라미터로 기존 속지(jp_center)를 제거한다.
				cont.remove(jp_center);
			}
			//새로 들어와햐 될 속지를 인스턴스화
			JPanel jp_dvdM = new DVDManager();
			//중앙에 배치.
			this.add("Center",jp_dvdM);
			cont.revalidate();
		}
		
	}
	

}
