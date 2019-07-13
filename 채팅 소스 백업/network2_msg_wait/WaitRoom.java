package com.network2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class WaitRoom extends JPanel{
	//선언부
	TalkClientVer2 tc2 = null;//절대로 인스턴스화 하지 않는다.
	JPanel jp_first= new JPanel();
	JPanel jp_second= new JPanel();
	JPanel jp_second_south= new JPanel();
	//첫번쨰 테이블 추가 -대기목록
	String cols1[] = {"대화명","위치"}; //테이블에 들어갈 헤더 정보
	String data1[][] = new String[0][2]; //데이터 영역
	//양식은 못가지고 데이터는 가질 수 있음.
	DefaultTableModel dtm_wait = new DefaultTableModel(data1, cols1);
	//데이터를 가질 수 없음. 클릭은 화면에서 일어나므로 여기서 처리
	JTable			  jtb_wait = new JTable(dtm_wait);//양식, 폼 제공함
	JScrollPane	  	  jsp_wait = new JScrollPane(jtb_wait
					, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	//두번째 테이블 추가 -현재 참여 목록
	String cols2[] = {"단톡명","현재원"};
	String data2[][] = new String[0][2];
	DefaultTableModel dtm_room = new DefaultTableModel(data2, cols2);
	//데이터를 가질 수 없음. 클릭은 화면에서 일어나므로 여기서 처리
	JTable			  jtb_room = new JTable(dtm_room);//양식, 폼 제공함
	JScrollPane	  	  jsp_room = new JScrollPane(jtb_room
					, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JButton jbtn_create = new JButton("단톡생성");
	JButton jbtn_in 	= new JButton("입장");
	JButton jbtn_blank  = new JButton("blank");
	JButton jbtn_exit 	= new JButton("종료");
	JTableHeader jth_wait = jtb_wait.getTableHeader();
	JTableHeader jth_room = jtb_wait.getTableHeader();
	//대화명 정보 담기
	String nickName= null;
	//단톡명 담기
	String roomTitles = null;
	//현재원 담기
	int currentNum =0;
	//두번째 테이블 추가 -현재 참여 목록
	
	//생성자
	public WaitRoom() {
		
	}
	
	//tc2에서 소켓과 oos, ois를 소유하고 있다.
	//그 원본을 나도 접근해야 한다.
	public WaitRoom(TalkClientVer2 tc2) {
		this.tc2 = tc2;
		initDisplay();
	}
	//화면처리부
	public void initDisplay() {
		//JFrame은 디폴트가 borderlayout 이나 필요에 따라 다른 레이아웃으로 설정가능함.
		this.setLayout(new GridLayout(1,2));
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",jsp_wait);
		
		this.add(jp_first);
		jp_second.setLayout(new BorderLayout());
		jp_second.add("Center",jsp_room);
		jp_second_south.setLayout(new GridLayout(2,2));
		
		jp_second_south.add(jbtn_create);
		jp_second_south.add(jbtn_in);
		jp_second_south.add(jbtn_blank);
		jp_second_south.add(jbtn_exit);
		
		jp_second.add("South",jp_second_south);
		
		this.add(jp_second);
		this.setLocation(250,300);
		//this.pack();
		this.setVisible(true);
		
	}
	//단위테스트 때문에 추가함 - TalkClientVer2에 붙일 것임.
	public static void main(String[] args) {
		new WaitRoom(null);
	
	}

}

