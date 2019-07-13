package Rental;

public class RentalVO {

	private String rent_no              = null; 
	private String order_date           = null;
	private String pay_met              = null; 
	private String pay_date             = null; 
	private String rent_term            = null; 
	private String visit_date           = null; 
	private String deposit              = null; 
	private String first_install_date   = null; 
	private String mem_id               = null; 
	private String rent_fee         	    =  null; 
	private String pro_code         	    =  null; 
	private String rent_fee_sum         = null; 
	private String rent_quan            = null;
	private String combobox    =null;
	private String keyword    =null;
		
	//테이블에는 없지만 업무에 대한 구분을 위한 변수 선언
	private String command = null;  // 전체조회: select, 상세조회: detail, insert, update, delete 
	
	private int    status = -1; //1,0은 써야하는 값이니까 없는 값인 -1로 초기화
		
	public String getRent_no() {
		return rent_no;
	}
	public void setRent_no(String rent_no) {
		this.rent_no = rent_no;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getPay_met() {
		return pay_met;
	}
	public void setPay_met(String pay_met) {
		this.pay_met = pay_met;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public String getRent_term() {
		return rent_term;
	}
	public void setRent_term(String rent_term) {
		this.rent_term = rent_term;
	}
	public String getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getFirst_install_date() {
		return first_install_date;
	}
	public void setFirst_install_date(String first_install_date) {
		this.first_install_date = first_install_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getRent_fee() {
		return rent_fee;
	}
	public void setRent_fee(String rent_fee) {
		this.rent_fee = rent_fee;
	}
	public String getPro_code() {
		return pro_code;
	}
	public void setPro_code(String pro_code) {
		this.pro_code = pro_code;
	}
	public String getRent_fee_sum() {
		return rent_fee_sum;
	}
	public void setRent_fee_sum(String rent_fee_sum) {
		this.rent_fee_sum = rent_fee_sum;
	}
	public String getRent_quan() {
		return rent_quan;
	}
	public void setRent_quan(String rent_quan) {
		this.rent_quan = rent_quan;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCombobox() {
		return combobox;
	}
	public void setCombobox(String combobox) {
		this.combobox = combobox;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	} 
	
	
}
