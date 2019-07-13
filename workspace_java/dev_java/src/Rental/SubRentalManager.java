package Rental;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import javax.swing.table.JTableHeader;

public class SubRentalManager extends JFrame implements ActionListener, MouseListener {
	
	SubRental subrental = new SubRental();
	static SubRentalManager srm = null;
	
    //선언부 - 선언부에서 메소드 호출 불가
	////////////메뉴바 추가하기/////////////////////////////
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
	
	////////////////////메뉴바 추가하기 끝/////////////////////
	////////////////////검색기 추가 시작/////////////////////
	String searchLabel[] = {"전체","렌트번호","주문날짜","지불방법","지불날짜","렌트기간","방문날짜","디파짓","설치날짜","아이디","월별렌트비","제품코드","총렌트비","렌트수량"};
	JComboBox jcb_search = new JComboBox(searchLabel);
	JTextField jtf_keyword = new JTextField("검색할 키워드를 입력하세요!",50);
	
	////////////////////검색기 추가 끝////////////////////////

	             
	//이 속지에 조회,입력,수정,삭제 버튼 추가하기 - FlowLayout
	JPanel jp_north = new JPanel(); //GirdLayout을 써서 두 개 영역 쪼갬
	JPanel jp_north_second = new JPanel(); //검색기 추가
	JPanel jp_north_first = new JPanel();  //기존 버튼 4개 이관
	
	JButton jbtn_sel = new JButton("검색");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	JButton jbtn_all = new JButton("전체조회");
	////////////////메뉴바 추가하기/////////////////////////
    JFrame jf_rental = new JFrame();
	//생성자-생성자는 절대로 리턴타입을 가질 수 없다.
    //테이블 헤더에 들어갈 이름들 담기
    String cols [] = {"렌트번호","주문날짜","지불방법","지불날짜","렌트기간","방문날짜","디파짓","설치날짜","아이디","월별렌트비","제품코드","총렌트비","렌트수량"};
    //오라클 서버에서 조회한 결과를 담을 2차배열 선언
    String data[][] = new String[5][13]; //행과 열의 갯수
    //실제 데이터를 담을 수 있는 클래스 생성하기
    DefaultTableModel dtm_rent = new DefaultTableModel(data,cols);
	//실제 테이블을 그려줄 클래스 생성(화면만, 폼만, 양식만,...실제 데이터를 가질 수 있는 클래스가 아님)
    JTable jt_rent = new JTable(dtm_rent);
    //바닥속지-> JTable-> DefualtTableModel->cols,data 이용
    JScrollPane jsp_rent = new JScrollPane(jt_rent,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    		                              ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JTableHeader jth_rent = jt_rent.getTableHeader(); //API

        
    
   
    public SubRentalManager() {
		 //디폴트생성자
	}
    //새로고침 처리 메소드 구현
    public void refreshData() { 			
 		System.out.println("새로고침처리");
 		//이미 테이블에 있던 데이터는 삭제한다.
 		while(dtm_rent.getRowCount()>0) {
 			dtm_rent.removeRow(0);
 		}
 		RentalCtrl rCtrl = new RentalCtrl();
 		
 		// controller 연결
 		List<RentalVO> rentalList = rCtrl.send("select");
 		
 		System.out.println("전체조회 처리 시작");
 		
 		if((rentalList==null)||(rentalList.size()==0)){
 			JOptionPane.showMessageDialog(this, "데이터가 없습니다.");
 		}else {
 			for(int i=0; i<rentalList.size(); i++) {
 				RentalVO rVO = rentalList.get(i);
 				//Vector를 생성한 이유는 DB에서 꺼낸 값을 행단위로 dtm_address에 
 				//추가할 수 있는 addRow(Vector|(or)Object[])라는 메소드에 파라미터로 넣기 위함이다.
 				Vector<String> rowData = new Vector<String>();
 				rowData.add(0, rVO.getRent_no());
 				rowData.add(1, rVO.getOrder_date());
 				rowData.add(2, rVO.getPay_met ());
 				rowData.add(3, rVO.getPay_date());
 				rowData.add(4, rVO.getRent_term ());
 				rowData.add(5, rVO.getVisit_date ());
 				rowData.add(6, rVO.getDeposit());
 				rowData.add(7, rVO.getFirst_install_date());
 				rowData.add(8, rVO.getMem_id());
 				rowData.add(9, rVO.getRent_fee ());
 				rowData.add(10, rVO.getPro_code());
 				rowData.add(11, rVO.getRent_fee_sum());
 				rowData.add(12, rVO.getRent_quan());
 				dtm_rent.addRow(rowData);
 			}
 	   }
    }

	//화면처리구현
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
		
		jbtn_sel.addActionListener(this); //콜백메소드
		jbtn_ins.addActionListener(this); //콜백메소드
		jbtn_upd.addActionListener(this); //콜백메소드
		jbtn_del.addActionListener(this); //콜백메소드
		jbtn_all.addActionListener(this);
			
		jtf_keyword.addMouseListener(this); //마우스 클릭하면 검색해주세요 사라지게
		jtf_keyword.addActionListener(this);
		
		jp_north.setLayout(new GridLayout(2,1));
		jp_north_second.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north_second.add(jcb_search);
		jp_north_second.add(jtf_keyword);
		jp_north_second.add(jbtn_sel);

		jp_north_first.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north_first.add(jbtn_all);
		jp_north_first.add(jbtn_ins);
		jp_north_first.add(jbtn_upd);
		jp_north_first.add(jbtn_del);
		
		jt_rent.setSelectionMode(0);
		//테이블 헤더 위치 변경 금지하기
		jt_rent.getTableHeader().setReorderingAllowed(false);
		//테이블 컬럼 폭 지정하기
		//jt_rent.getColumnModel().getColumn(0).setPreferredWidth(70);
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
		
		jmb_rental.add(jbtn_member);
		jmb_rental.add(jbtn_rent);
		jmb_rental.add(jbtn_prod);
		jmb_rental.add(jbtn_money);
		
		
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
		
		jbtn_all.setBackground(new Color(200,191,231));
		jbtn_all.setForeground(new Color(255,255,255));
		
		
		//////////////////////////////////////////////////////////////////
		jf_rental.setJMenuBar(jmb_rental);
		jp_north.add(jp_north_second);
		jp_north.add(jp_north_first);
		jf_rental.add("North", jp_north);
		jf_rental.add("Center",jsp_rent);
		jf_rental.setSize(1200, 550);
		jf_rental.setVisible(true);
		refreshData();

		//조회
		jbtn_all.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				allActionPerformed(e);
			}
		});
		//입력
		jbtn_ins.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						insertActionPerformed(e);				
					}
			}); 
		//수정
		jbtn_upd.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		//삭제
		jbtn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);}
			}); 
		//검색
		jbtn_sel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchActionPerformed(e);}	});		
		}
	
		protected void clickActionPerformed(MouseEvent arg0) {
		 	jtf_keyword.setText(null);
	}
	
	protected void detailActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		int index = jt_rent.getSelectedRow();
		//로그를 출력할 때 - 주의사항
		//main을 가진 클래스는 sysout
		//main 클래스가 없을 때는 JOptionPane.showMessageDialog(this, "데이터가 없습니다.");
		//System.out.println("index : "+index);
		if(index<0) {
			JOptionPane.showMessageDialog(this, "조회할 데이터를 한 건만 선택하세요.","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}else {
			try {
				//선택한 후에 상세조회 화면이 열리면 기존에 선택한 로우는 clear 처리
				jt_rent.clearSelection();
		
				RentalVO paVO = new RentalVO();
				String mem_id = (String)dtm_rent.getValueAt(index, 0);
				paVO.setMem_id(mem_id);
				paVO.setCommand("detail");
				
				RentalCtrl rCtrl = new RentalCtrl();
				RentalVO rVO = rCtrl.send(paVO); //위에서 담은 detail을 if문에서 비교. 그래서 detail 이랑 같으면 modlogic 실행해줘
				
				subrental= null;
				subrental = new SubRental();
				//문제제기- 어!! 화면그리는 메소드가 사라졌네?
				subrental.set(rVO, label,srm,false);
			} catch (Exception e2) {
			} 
	   }
	}
	

	//입력
	protected void insertActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();//버튼의 라벨을 읽어올 수 있음.
		subrental = null;
		subrental = new SubRental();
		subrental.set(null,label,srm,true);
	}
	//수정
	protected void updateActionPerformed(ActionEvent e) {
		 String label = e.getActionCommand();//버튼의 라벨을 읽어올 수 있음.
		 int index = jt_rent.getSelectedRow();
		 if(index<0) {
			 JOptionPane.showMessageDialog(this,"조회할 데이터를 한 건만 선택해 주십시오.", "Error",JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		 else {
			 try {
				 jt_rent.clearSelection();
				 RentalVO paVO = new RentalVO(); //VO에서 파라미터로 받아오겠다
				 String mem_id = (String)dtm_rent.getValueAt(index, 0); //mem_id에 테이블에서 선택한 멤버 아이디를 받아옴
				 
				 paVO.setMem_id(mem_id);//VO의 SetMem_id에 담음
				 paVO.setCommand("detail"); //VO의 커맨드를 detail로 바꿈
				 
				 RentalCtrl rCtrl = new RentalCtrl();
				 RentalVO rVO = rCtrl.send(paVO); //rVO에 담긴거- paVO에 담긴 detail 때문에 비교 가능
				 
				 subrental = null; //물어보기
				 subrental = new SubRental() ;
				 subrental.set(rVO, label,srm,true);
			} catch (Exception e2) {
				System.out.println(e.toString());
			}
		}				
	}
	protected void deleteActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();//버튼의 라벨을 읽어올 수 있음.
		int index = jt_rent.getSelectedRow();
		if(index<0) {
			JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요.");
			return;
		}
		else {
			try {
				RentalVO paVO = new RentalVO();
				RentalVO rVO = null;
				String u_id=null;
				
				for(int i=0; i<dtm_rent.getRowCount();i++) {
					if(jt_rent.isRowSelected(i)) {
						u_id = (String)dtm_rent.getValueAt(i, 8);
						RentalCtrl rCtrl = new RentalCtrl();
						
						paVO.setCommand("delete");
						paVO.setMem_id(u_id); 					 
						rVO = rCtrl.send(paVO);
					}
				}
				if(rVO.getStatus()==1) {
					refreshData();
				}
				else {
					JOptionPane.showMessageDialog(this, "삭제가 안되었습니다.");
					//deleteActionPerformed 탈출
					return;
				} 
			} catch (Exception e2){
					e2.printStackTrace();		
			}
		}			
	}
	
	
	protected void allActionPerformed(ActionEvent e) {
		refreshData();
	}
	
	//메인메소드
	public static void main(String[] args) {
		  if(srm==null) {
			   srm = new SubRentalManager();
		  }
		  srm.initDisplay();
	} 
	
	


	public void enteractionPerformed(ActionEvent ae) {
		String keyword = jtf_keyword.getText();
		String comboboxlabel = (String)jcb_search.getSelectedItem();
		if("검색할 키워드를 입력하세요.".equals(jtf_keyword.getText())) {
			JOptionPane.showMessageDialog(this, "새로 입력하세요.");
			return;
		}else {
			try {
				RentalVO paVO = new RentalVO();
				paVO.setCombobox(comboboxlabel);
				paVO.setKeyword(keyword);
				RentalCtrl rCtrl = new RentalCtrl();
				List<RentalVO> rentalList = rCtrl.send("search",paVO);
				while(dtm_rent.getRowCount()>0) {
					dtm_rent.removeRow(0);
				}
				for(int i=0;i<rentalList.size();i++) {
					RentalVO rVO = rentalList.get(i);
					Vector rowData = new Vector();
					rowData.add(0, rVO.getRent_no());
	 				rowData.add(1, rVO.getOrder_date());
	 				rowData.add(2, rVO.getPay_met ());
	 				rowData.add(3, rVO.getPay_date());
	 				rowData.add(4, rVO.getRent_term ());
	 				rowData.add(5, rVO.getVisit_date ());
	 				rowData.add(6, rVO.getDeposit());
	 				rowData.add(7, rVO.getFirst_install_date());
	 				rowData.add(8, rVO.getMem_id());
	 				rowData.add(9, rVO.getRent_fee ());
	 				rowData.add(10, rVO.getPro_code());
	 				rowData.add(11, rVO.getRent_fee_sum());
	 				rowData.add(12, rVO.getRent_quan());
	 				dtm_rent.addRow(rowData);
				}
			} catch (Exception e2) {
				System.out.println(e2.toString());
			}
		}
	}		

	
	/////////////검색
	protected void searchActionPerformed(ActionEvent e) {
		String label = e.getActionCommand(); 
		String keyword = jtf_keyword.getText();
		String comboboxlabel = (String)jcb_search.getSelectedItem();
		if("검색".equals(label)) {
			if("검색할 키워드를 입력하세요.".equals(jtf_keyword.getText())) {
				JOptionPane.showMessageDialog(this, "새로 입력하세요.");
				return;
			}else {
				try {
					RentalVO paVO = new RentalVO(); //인스턴스화
					paVO.setCombobox(comboboxlabel); //콤보박스라벨을 콤보박스에
					paVO.setKeyword(keyword);
					RentalCtrl rCtrl = new RentalCtrl(); 
					List<RentalVO> rentalList = rCtrl.send("search",paVO);
					while(dtm_rent.getRowCount()>0) {
						dtm_rent.removeRow(0);
					}
					for(int i=0;i<rentalList.size();i++) {
						RentalVO rVO = rentalList.get(i);
						Vector rowData = new Vector();
						rowData.add(0, rVO.getRent_no());
		 				rowData.add(1, rVO.getOrder_date());
		 				rowData.add(2, rVO.getPay_met ());
		 				rowData.add(3, rVO.getPay_date());
		 				rowData.add(4, rVO.getRent_term ());
		 				rowData.add(5, rVO.getVisit_date ());
		 				rowData.add(6, rVO.getDeposit());
		 				rowData.add(7, rVO.getFirst_install_date());
		 				rowData.add(8, rVO.getMem_id());
		 				rowData.add(9, rVO.getRent_fee ());
		 				rowData.add(10, rVO.getPro_code());
		 				rowData.add(11, rVO.getRent_fee_sum());
		 				rowData.add(12, rVO.getRent_quan());
		 				dtm_rent.addRow(rowData);
					}
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
			}
		}
	}
	   
	
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
		//System.out.println("마우스 포인터:"+me.getPoint()); 이벤트처리 되는지 확인
		jtf_keyword.setText("");
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	




			
}





