
package Rental;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SubRental extends JDialog implements ActionListener  {
	
	public SubRental() {
		initDisplay();
		
	};

	private JLabel labelRent_no;
	private JTextField txtRent_no;
	private JLabel labelOrder_date; 
	private JTextField txtOrder_date; 
	private JLabel labelPay_met;   
	private JTextField txtPay_met;
	private JComboBox comboPayList;
	private JLabel labelPay_date;  
	private JTextField txtPay_date;  
	private JLabel labelRent_term;
	private JTextField txtRent_term;
	private JLabel labelVisit_date;
	private JTextField txtVisit_date;
	private JLabel labelDeposit;
	private JTextField txtDeposit;
	private JLabel labelFirst_install_date;
	private JTextField txtFirst_install_date;
	private JLabel labelMem_id;  
	private JTextField txtMem_id;
	private JLabel labelRent_fee;
	private JTextField txtRent_fee;
	private JLabel labelPro_code;
	private JTextField txtPro_code;
	private JLabel labelRent_fee_sum;
	private JTextField txtRent_fee_sum;
	private JLabel labelRent_quan;
	private JTextField txtRent_quan;
	
	//private JTextArea txtComment;
	private JScrollPane scrollPane;
	private JScrollPane scrollComment;
	////////////////////////입력화면 추가하기 끝
	
	Font font = new Font("돋움체",Font.PLAIN,16); //글꼴,스타일,글씨크기
	JPanel jp_center = new JPanel(); // 입력에 필요한 화면을 배치(좌표값 배치)
	JPanel jp_south = new JPanel();
	JButton jbtn_search = new JButton("조회");
	JButton jbtn_save = new JButton("저장");
	JButton jbtn_cancle = new JButton("취소");
	JScrollPane jsp_line = new JScrollPane(jp_center);
	
	String title = null;
	SubRentalManager srm = null;
	RentalVO rVO = new RentalVO();
	
public void set(RentalVO rVO, String title, SubRentalManager srm, boolean isEdit) {
	this.rVO = rVO;
	this.title = title;
	this.srm = srm;
	this.setValue();
	this.setTitle(title);
	this.setVisible(true);
	this.setEditable(isEdit);
	
}

public String getRent_no() {return txtRent_no.getText();}
public void setRent_no(String Rent_no) {txtRent_no.setText(Rent_no);}

public String getOrder_date () {return txtOrder_date .getText();}
public void setOrder_date (String Order_date ) {txtOrder_date .setText(Order_date );}

public String getPay_met() {return txtPay_met .getText();}
public void setPay_met (String Pay_met ) {txtPay_met.setText(Pay_met );}



public String getPay_date() {return txtPay_date.getText();}
public void setPay_date(String Pay_date) {txtPay_date.setText(Pay_date);}

public String getRent_term() {return txtRent_term.getText();}
public void setRent_term(String Rent_term) {txtRent_term.setText(Rent_term);}

public String getVisit_date() {return txtVisit_date.getText();}
public void setVisit_date(String Visit_date) {txtVisit_date.setText(Visit_date);}

public String getDeposit() {return txtDeposit.getText();}
public void setDeposit(String Deposit) {txtDeposit.setText(Deposit);}


public String getFirst_install_date() {return txtFirst_install_date.getText();}
public void setFirst_install_date(String First_install_date) {txtFirst_install_date.setText(First_install_date);}

public String getMem_id() {return txtMem_id.getText();}
public void setMem_id(String Mem_id) {txtMem_id.setText(Mem_id);}

public String getRent_fee () {return txtRent_fee.getText();}
public void setRent_fee (String Rent_fee ) {txtRent_fee .setText(Rent_fee );}

public String getPro_code () {return txtPro_code.getText();}
public void setPro_code (String Pro_code ) {txtPro_code.setText(Pro_code );}

public String getRent_fee_sum() {return txtRent_fee_sum.getText();}
public void setRent_fee_sum(String Rent_fee_sum) {txtRent_fee_sum.setText(Rent_fee_sum);}

public String getRent_quan () {return txtRent_quan.getText();}
public void setRent_quan (String Rent_quan ) {txtRent_quan.setText(Rent_quan );}





public void setValue() {
	if(rVO==null) { //입력
		setRent_no("");
		setOrder_date("");
		//setPaylist("0");
		setPay_date("");
		setRent_term("");
		setVisit_date("");
		setDeposit("");
		setFirst_install_date("");
		setMem_id("");
		setRent_fee("");
		setPro_code("");
		setRent_fee_sum("");
		setRent_quan("");
	  
		
	}
	else { //수정
		
		setRent_no(rVO.getRent_no());
		setOrder_date(rVO.getOrder_date());
		//setPaylist("0");
		setPay_date(rVO.getPay_date());
		setRent_term(rVO.getRent_term());
		setVisit_date(rVO.getVisit_date());
		setDeposit(rVO.getDeposit());
		setFirst_install_date(rVO.getFirst_install_date());
		setMem_id(rVO.getMem_id());
		setRent_fee(rVO.getRent_fee());
		setPro_code(rVO.getPro_code());
		setRent_fee_sum(rVO.getRent_fee_sum());
		setRent_quan(rVO.getRent_quan());
	  
	}
}




public void initDisplay() {
		   jp_center.setLayout(null);//FlowLayout
    /////////////////화면 객체 생성하기 시작//////////////////	
	
			                               
			labelRent_no         	= new JLabel("렌트번호");  
			txtRent_no				= new JTextField(20);
			labelOrder_date			= new JLabel("주문날짜");
			txtOrder_date			= new JTextField(20); 	
			labelPay_met			= new JLabel("지불방법"); 
			txtPay_met    			= new JTextField(20);
			txtPay_date				= new JTextField(20); 
			labelPay_date			= new JLabel("지불날짜");  
			txtRent_term			= new JTextField(20);
			labelRent_term			= new JLabel("렌트기간"); 
			txtRent_term			= new JTextField(20); 
			labelVisit_date			= new JLabel("방문날짜");
			txtVisit_date			= new JTextField(20); 
			labelDeposit			= new JLabel("디파짓");  
			txtDeposit				= new JTextField(20);
			labelFirst_install_date	= new JLabel("설치날짜");
			txtFirst_install_date	= new JTextField(20);
			labelMem_id				= new JLabel("아이디");  
			txtMem_id				= new JTextField(20);  
			labelRent_fee			= new JLabel("월별렌트비");  
			txtRent_fee				= new JTextField(20);
			labelPro_code			= new JLabel("제품코드");  
			txtPro_code				= new JTextField(20);
			labelRent_fee_sum		= new JLabel("총렌트비");
			txtRent_fee_sum			= new JTextField(20);
			labelRent_quan			= new JLabel("렌트수량");  
			txtRent_quan			= new JTextField(20); 
			
			
			 
			 //scrollComment = new JScrollPane(txtComment);
			 
			// String[] comboPay_met= {"일시불", "신용카드","무통장입금"};
			// comboPayList= new JComboBox(comboPay_met);
			 
			
			
			labelRent_no.setFont(font);         
			labelOrder_date.setFont(font);		
			labelPay_met.setFont(font);		
			labelPay_date.setFont(font);		
			labelRent_term.setFont(font);		
			labelVisit_date.setFont(font);		
			labelDeposit.setFont(font);		
			labelFirst_install_date.setFont(font);		
			labelMem_id.setFont(font);			
			labelRent_fee.setFont(font);		
			labelPro_code.setFont(font);		
			labelRent_fee_sum.setFont(font);	
			labelRent_quan.setFont(font);		
			      
			 
	
             
			 labelRent_no.setBounds(20,45, 100,20);  
			 txtRent_no.setBounds(120,45, 150,20);	
			 
			 labelOrder_date.setBounds(20,70, 100,20);	
			 txtOrder_date.setBounds(120,70, 150,20);	
			 
			 labelPay_met.setBounds(20,95, 100,20);		
			 txtPay_met.setBounds(120,95, 150,20);	
			 
			 labelPay_date.setBounds(20,120, 100,20);	
			 txtPay_date.setBounds(120,120, 150,20);
				
			 labelRent_term.setBounds(20,145, 100,20);	
			 txtRent_term.setBounds(120,145, 150,20);	
				
			 labelVisit_date.setBounds(20,170, 100,20);	
			 txtVisit_date.setBounds(120,170, 150,20);	
			 
			 labelDeposit.setBounds(20,195, 100,20);		
			 txtDeposit.setBounds(120,195, 150,20);	
				
			 labelFirst_install_date.setBounds(20,220, 100,20);		
			 txtFirst_install_date.setBounds(120,220, 150,20);	
				
			 labelMem_id.setBounds(20,245, 100,20);	
			 txtMem_id.setBounds(120,245, 150,20);
				
			 labelRent_fee.setBounds(20,270, 100,20);	
			 txtRent_fee.setBounds(120,270, 150,20);	
				
			 labelPro_code.setBounds(20,295, 100,20);
			 txtPro_code.setBounds(120,295, 150,20);
				
			 labelRent_fee_sum.setBounds(20,320, 100,20);
			 txtRent_fee_sum.setBounds(120,320, 150,20);
				
			 labelRent_quan.setBounds(20,345, 100,20);
			 txtRent_quan.setBounds(120,345, 150,20);
		
				
			jp_center.add(labelRent_no);
			jp_center.add(txtRent_no);
			
			jp_center.add(labelOrder_date);
			jp_center.add(txtOrder_date);
			
			jp_center.add(labelPay_met);
			jp_center.add(txtPay_met);
			
			jp_center.add(labelPay_date);
			jp_center.add(txtPay_date);
			
			jp_center.add(labelRent_term);
			jp_center.add(txtRent_term);
			
			
			jp_center.add(labelVisit_date);
			jp_center.add(txtVisit_date);
			
			jp_center.add(labelDeposit);
			jp_center.add(txtDeposit);
			
			jp_center.add(labelFirst_install_date);
			jp_center.add(txtFirst_install_date);
			
			jp_center.add(labelMem_id);
			jp_center.add(txtMem_id);
			
			jp_center.add(labelRent_fee);
			jp_center.add(txtRent_fee);
							
			jp_center.add(labelPro_code);
			jp_center.add(txtPro_code);
			
			jp_center.add(labelRent_fee_sum);
			jp_center.add(txtRent_fee_sum);
			
			jp_center.add(labelRent_quan);
			jp_center.add(txtRent_quan);
			
			
			/////////////////화면 객체 배치하기 끝//////////////////	
			jbtn_save.addActionListener(this); 
			jbtn_cancle.addActionListener(this); 
			this.setLayout(new BorderLayout());
			jp_south.add(jbtn_search);
			jp_south.add(jbtn_save);
			jp_south.add(jbtn_cancle);
			this.add("South",jp_south);
			this.add("Center",jp_center);
			
			this.setTitle(title);
			this.setSize(400, 600);
			this.setVisible(false);
	
}

			public void setEditable(boolean isEdit) {
				if(rVO==null) {
					txtRent_no.setEditable(isEdit);				
					txtOrder_date.setEditable(isEdit);				
					txtPay_date.setEditable(isEdit);				
					txtRent_term.setEditable(isEdit);				
					txtVisit_date.setEditable(isEdit);				
					txtDeposit.setEditable(isEdit);					
					txtFirst_install_date.setEditable(isEdit);		
					txtMem_id.setEditable(isEdit);					
					txtRent_fee.setEditable(isEdit);				
					txtPro_code.setEditable(isEdit);				
					txtRent_fee_sum.setEditable(isEdit);			
					txtRent_quan.setEditable(isEdit);				
					txtPay_met.setEditable(isEdit);
					//txtComment.setEditable(isEdit);
				}else {
					txtRent_no.setEditable(false);				
					txtOrder_date.setEditable(isEdit);				
					txtPay_date.setEditable(isEdit);				
					txtRent_term.setEditable(isEdit);				
					txtVisit_date.setEditable(isEdit);				
					txtDeposit.setEditable(isEdit);					
					txtFirst_install_date.setEditable(isEdit);		
					txtMem_id.setEditable(false);					
					txtRent_fee.setEditable(isEdit);				
					txtPro_code.setEditable(false);				
					txtRent_fee_sum.setEditable(isEdit);			
					txtRent_quan.setEditable(isEdit);				
					txtPay_met.setEditable(isEdit);
					//txtComment.setEditable(isEdit);
				}
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				String label = e.getActionCommand()	;
				if("저장".equals(label)) {
				if(rVO !=null) { //수정인 경우
					
					try {
						RentalVO paVO = new RentalVO();
						paVO.setCommand("update");
						paVO.setRent_no(getRent_no());                             
						paVO.setOrder_date(getOrder_date());                      
						//paVO.//setPaylist("0");         
						paVO.setPay_date(getPay_date());                          
						paVO.setRent_term(getRent_term());                        
						paVO.setVisit_date(getVisit_date());                      
						paVO.setDeposit(getDeposit());                            
						paVO.setFirst_install_date(getFirst_install_date());      
						paVO.setMem_id(getMem_id());                              
						paVO.setRent_fee(getRent_fee());                          
						paVO.setPro_code(getPro_code());                          
						paVO.setRent_fee_sum(getRent_fee_sum());                  
						paVO.setRent_quan(getRent_quan());                        
						RentalCtrl rCtrl = new RentalCtrl();
						RentalVO rVO = rCtrl.send(paVO);
						if(rVO !=null) {
							if(rVO.getStatus()==1) {
								JOptionPane.showMessageDialog(srm, "성공!!!!");
								this.dispose();
								srm.refreshData();
							} else{
								JOptionPane.showMessageDialog(srm, "실패");
								return;
							}
						}
					} catch (Exception e2) {
					}
							
				}
					else {//입력인 경우
						try {
							RentalVO paVO = new RentalVO();
							paVO.setCommand("insert");
							//다이얼로그 창으로 부터 입력된 값을 읽어서 paVO 담기
							paVO.setRent_no(getRent_no());                             
							paVO.setOrder_date(getOrder_date());                      
							//paVO.setPaylist("0");                                       
							paVO.setPay_date(getPay_date());                          
							paVO.setRent_term(getRent_term());                        
							paVO.setVisit_date(getVisit_date());                      
							paVO.setDeposit(getDeposit());                            
							paVO.setFirst_install_date(getFirst_install_date());      
							paVO.setMem_id(getMem_id());                              
							paVO.setRent_fee(getRent_fee());                          
							paVO.setPro_code(getPro_code());                          
							paVO.setRent_fee_sum(getRent_fee_sum());                  
							paVO.setRent_quan(getRent_quan());                        
							RentalCtrl rCtrl = new RentalCtrl();
							RentalVO rVO = rCtrl.send(paVO); //r: 꺼내온 값 p:사용자가 입력한 값
					
							if(rVO!=null) {
								if(rVO.getStatus()==1) {//입력성공
									JOptionPane.showMessageDialog(srm, "입력성공");
									this.dispose();
									srm.refreshData();
								} else {
									JOptionPane.showMessageDialog(srm,"입력실패");
									return;
								}
							}
						}catch (SQLException se) {
							System.out.println(se.toString());
						}
						catch (Exception e2) {
							System.out.println(e.toString());
						}
				    	}
						//dispose는 창만 닫게 해줄 뿐 메모리에 대해서까지 영향력이 없다.
					
					}else if("취소".equals(label)) {
						this.dispose();
					}
				}
			}
