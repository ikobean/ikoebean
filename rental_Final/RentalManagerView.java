package rental;
/****************************************************************************
 * 
 * 학습목표
 * 나는 인스턴스화를 할 때 적절한 생성자를 사용할 수 있다. - 파라미터와 타입 맞추기
 * 나는 인스턴스 변수를 활용하여 메소드를 호출할 수 있다.
 * 나는 메소드 호출시 파라미터 혹은 리턴타입을 활용할 수 있다.
 * 
 ***************************************************************************/

/***************************************************************************
 * 
 * 오라클 서버에 자바언어를 활용하여 접속하기
 * SELECT문 요청
 * 사전필요 - SELECT문 작성하고 StringBuilder클래스에 저장
 * 1단계 - 물리적으로 떨어져 있는 오라클 서버에 연결통로 확보 - 오라클 드라이버 클래스도 스캔) --제조사 정보를 얻으려고
 * 2단계 - 쿼리문을 오라클 서버에 전달해 줄 클래스가 필요함. preparedStatement -얘가 필요하다는 건 뭐야? 인스턴스화를 해야지! 그래야 메소드 호출이 가능하니깐~
 *       만일 where절이 있을 경우파라미터로 사용자가 입력한 값을 넘김.
 * 3단계 - 오라클서버에게 처리 요청
 *     - 1)select인 경우 - 커서를 조작해야 한다. 커서 이동할 때 next()호출 - 인스턴스화 - 하려면 클래스이름이 있어야함.
 *         이 일을 하는 애가 ResultSet 오라클에 살고있는 커서를 조작하는데 사용하라고 제공되는 인터페이스. 클래스.
 *         ResultSet rs = pstmt.executeQuery():R
 *     - 2)insert | update | delete - 커서가 필요없음.
 *          int result = pstmt.executeUpdate():int
 *          
 ***************************************************************************/
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

//생성자는 메소드 오버로딩 규칙에 따른다.
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RentalManagerView implements ActionListener, MouseListener, KeyListener {
 	public void refreshData() {
 		System.out.println("새로고침처리");
 }
	
    //선언부 - 선언부에서 메소드 호출 불가
	////////////메뉴바 추가하기/////////////////////////////
	JMenuBar jmb_rental = new JMenuBar();
	
	JMenu    jm_file = new JMenu("파일");
	JMenu    jm_member = new JMenu("회원관리");
	JMenu    jm_rent   = new JMenu("대여관리");
	JMenu    jm_prod = new JMenu("상품관리");
	JMenu    jm_money = new JMenu("매출관리");
	
	
	JMenuItem jmi_save = new JMenuItem("저장");
	JMenuItem jmi_search = new JMenuItem("검색");
	JMenuItem jmi_print = new JMenuItem("인쇄"); 
	JMenuItem jmi_backup = new JMenuItem("백업");
	JMenuItem jmi_exit = new JMenuItem("나가기");
	
	
	JMenuItem jmi_ins = new JMenuItem("회원등록");
	JMenuItem jmi_upd = new JMenuItem("회원정보수정");
	JMenuItem jmi_del = new JMenuItem("회원탈퇴");
	
	
	JMenuItem jmi_rent_ins = new JMenuItem("대여등록");
	JMenuItem jmi_rent_upd = new JMenuItem("대여수정");
	JMenuItem jmi_rent_del = new JMenuItem("대여끝");
	
	
	JMenuItem jmi_prod_ins = new JMenuItem("상품등록");
	JMenuItem jmi_prod_upd = new JMenuItem("상품수정");
	JMenuItem jmi_prod_del = new JMenuItem("상품버려");
		
	
	JMenuItem jmi_money_day = new JMenuItem("일별매출");
	JMenuItem jmi_money_mon = new JMenuItem("월별매출");
	JMenuItem jmi_money_year = new JMenuItem("연별매출");
	////////////////////메뉴바 추가하기 끝/////////////////////
	////////////////////검색기 추가 시작/////////////////////
	String searchLabel[] = {"이름","회원아이디","대여번호"};
	JComboBox jcb_search = new JComboBox(searchLabel);
	JTextField jtf_keyword = new JTextField("검색할 키워드를 입력하세요!",50);
	
	////////////////////검색기 추가 끝////////////////////////

	             
	//이 속지에 조회,입력,수정,삭제 버튼 추가하기 - FlowLayout
	JPanel jp_north = new JPanel(); //GirdLayout을 써서 두 개 영역 쪼갬
	JPanel jp_north_second = new JPanel(); //검색기 추가
	JPanel jp_north_first = new JPanel();  //기존 버튼 4개 이관
	
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	////////////////메뉴바 추가하기/////////////////////////
    JFrame jf_rental = new JFrame();
	//생성자-생성자는 절대로 리턴타입을 가질 수 없다.
    //테이블 헤더에 들어갈 이름들 담기
    String cols [] = {"회원ID","이름","전화번호","대여번호","주문일자","모델번호","제품군"};
    //오라클 서버에서 조회한 결과를 담을 2차배열 선언
    String data[][] = new String[5][7]; //행과 열의 갯수
    //실제 데이터를 담을 수 있는 클래스 생성하기
    DefaultTableModel dtm_rent = new DefaultTableModel(data,cols);
	//실제 테이블을 그려줄 클래스 생성(화면만, 폼만, 양식만,...실제 데이터를 가질 수 있는 클래스가 아님)
    JTable jt_rent = new JTable(dtm_rent);
    //바닥속지-> JTable-> DefualtTableModel->cols,data 이용
    JScrollPane jsp_rent = new JScrollPane(jt_rent,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    		                              ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   
    public RentalManagerView() {
		 //디폴트생성자
	}
   
    //DVD목록 조회 구현
    public void getprodList(String keyword) {
    	System.out.println("사용자가 입력한 키워드:"+ keyword);
    	StringBuilder sql = new StringBuilder();
    	  sql.append("SELECT M.MEM_ID , M.NAME         ");
    	  sql.append("   , M.PHO_NO  ,R.RENT_NO        ");
    	  sql.append("   ,R.ORDER_DATE, P.MODEL_NO     ");
    	  sql.append("   , P.CATEGORY                  ");
    	  sql.append("FROM PRODUCT P, MEMBER M,RENT R  ");
    	  sql.append("WHERE M.MEM_ID=R.MEM_ID          ");
    	  sql.append("AND R.PRO_CODE=P.PRO_CODE        ");
    	  try {
    		  Class.forName(RentalOracleServer._DRIVER);
    		  Connection con = DriverManager.getConnection(RentalOracleServer._URL
    				                                       ,RentalOracleServer._USER
    				                                       ,RentalOracleServer._PW);
    		  
    	  PreparedStatement pstmt = con.prepareStatement(sql.toString());
    			  ResultSet rs = pstmt.executeQuery();
    			  List<HashMap<String,Object>> list=
    					  new ArrayList<HashMap<String,Object>>();
    			  HashMap<String,Object> ramp = null;
    			  while(rs.next()) {
    				  ramp = new HashMap<String,Object>();
    				  ramp.put("mem_id",rs.getString("mem_id"));
    				  ramp.put("name",rs.getString("name"));
    				  ramp.put("pho_no",rs.getString("pho_no"));
    				  ramp.put("rent_no",rs.getString("rent_no"));
    				  ramp.put("order_date",rs.getString("order_date"));
    				  ramp.put("model_no",rs.getString("model_no"));
    				  ramp.put("category",rs.getString("category"));
    				  list.add(ramp);
    			  }
    			  Iterator<HashMap<String,Object>> iter = list.iterator();
    			  Object obj[] = null;
    			  while(iter.hasNext()) {
    				  HashMap data = iter.next();
    				  obj = data.keySet()	.toArray();
    				  Vector oneRow = new Vector();
    				  oneRow.add(data.get(obj[3]));
    				  oneRow.add(data.get(obj[4]));
    				  oneRow.add(data.get(obj[2]));
    				  oneRow.add(data.get(obj[1]));
    				  oneRow.add(data.get(obj[0]));
    				  oneRow.add(data.get(obj[6]));
    				  oneRow.add(data.get(obj[5]));
    				  dtm_rent.addRow(oneRow);
    			  }
    	  } 
    	  
    	  catch(Exception e) {
    		  // TODO : handle exception
    		  System.out.println(e.toString());
    	  }
    }
    
	//화면처리구현
	public void initDisplay() {
		jbtn_sel.addActionListener(this); //콜백메소드
		jtf_keyword.addMouseListener(this); //마우스 클릭하면 검색해주세요 사라지게
		jtf_keyword.addActionListener(this);
		jp_north.setLayout(new GridLayout(2,1));
		jp_north_second.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north_second.add(jcb_search);
		jp_north_second.add(jtf_keyword);

		jp_north_first.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north_first.add(jbtn_sel);
		jp_north_first.add(jbtn_ins);
		jp_north_first.add(jbtn_upd);
		jp_north_first.add(jbtn_del);
		jt_rent.setSelectionMode(0);
		//테이블 헤더 위치 변경 금지하기
		jt_rent.getTableHeader().setReorderingAllowed(false);
		//테이블 컬럼 폭 지정하기
		jt_rent.getColumnModel().getColumn(0).setPreferredWidth(70);
		jt_rent.getColumnModel().getColumn(1).setPreferredWidth(120);
		//테이블 헤더 배경색 변경
		jt_rent.getTableHeader().setBackground(new Color (130,160,160));
		jt_rent.getTableHeader().setForeground(Color.white);
		
		jf_rental.setTitle("RENTAL 관리 시스템 Ver1.0");
		
		jm_file.add(jmi_save);
		jm_file.add(jmi_search);
		jm_file.add(jmi_print);
		jm_file.add(jmi_backup);
		jm_file.add(jmi_exit);
		jmb_rental.add(jm_file);
		
		
		jm_member.add(jmi_ins);
		jm_member.add(jmi_upd);
		jm_member.add(jmi_del);
		jmb_rental.add(jm_member);
		
		jm_rent.add(jmi_rent_ins);
		jm_rent.add(jmi_rent_upd);
		jm_rent.add(jmi_rent_del);
		jmb_rental.add(jm_rent);
		
		jm_prod.add(jmi_prod_ins);
		jm_prod.add(jmi_prod_upd);
		jm_prod.add(jmi_prod_del);
		jmb_rental.add(jm_prod);
		
		jm_money.add(jmi_money_day);
		jm_money.add(jmi_money_mon);
		jm_money.add(jmi_money_year);
		jmb_rental.add(jm_money);
				
		
		/*버튼에 색깔 넣기
		jbtn_new.setBackground(new Color(100,200,200));
		jbtn_new.setForeground(new Color(255,255,200));
		*///
		jbtn_sel.setBackground(new Color(200,191,231));
		jbtn_sel.setForeground(new Color(255,255,255));
		
		jbtn_ins.setBackground(new Color(100,200,200));
		jbtn_ins.setForeground(new Color(255,255,255));
		
		jbtn_upd.setBackground(new Color(200,191,231));
		jbtn_upd.setForeground(new Color(255,255,255));
		
		jbtn_del.setBackground(new Color(100,200,200));
		jbtn_del.setForeground(new Color(255,255,255));
		
		//////////////////////////////////////////////////////////////////
		jf_rental.setJMenuBar(jmb_rental);
		jp_north.add(jp_north_second);
		jp_north.add(jp_north_first);
		jf_rental.add("North", jp_north);
		jf_rental.add("Center",jsp_rent);
		jf_rental.setSize(700, 550);
		jf_rental.setVisible(true);
	}
	
	//메인메소드
	public static void main(String[] args) {
		RentalManagerView rental = new RentalManagerView();
		rental.initDisplay();
	
	} 
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//너 조회버튼 눌렀니? 버튼의 주소번지를 비교. 값이기 때문에  @abc1234 ==
		String keyword = jtf_keyword.getText();
		if(e.getSource()==jbtn_sel) {
			if("검색할 키워드 입력하세요".contentEquals(jtf_keyword.getText()));
			{JOptionPane.showMessageDialog(jf_rental, "검색할 키워드를 입력하세요.");
			return;
			}
			//getprodList(keyword);
		}
	else if(e.getSource() == jtf_keyword) {
		getprodList(keyword);
		
	
		}
		
	
	
	
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		//System.out.println("마우스 포인터:"+me.getPoint()); 이벤트처리 되는지 확인
		jtf_keyword.setText("");

		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println(e.getKeyChar());
		Object obj = e.getSource();
		System.out.println("obj"+obj);
		if(e.getKeyChar()==KeyEvent.VK_DELETE) {
			System.out.println("delete 버튼 이벤트");
			
		}
		
	}
			
}




