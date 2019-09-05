package com.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class MemberVO implements Serializable {
	
	/**
	 * 전역변수를 private으로 하는 것을 권장함.
	 * 이유가 뭘까?
	 * 인스턴스화 하기
	 * 네이버 1초당 2000명 입장
	 * 그 중에서 200명 회원가입 진행한다.
	 */
	private static final long serialVersionUID = 4137373418319886949L;
	private String  mem_id      ="" ;
	private String  mem_pw      ="" ;
	private String  mem_name    ="" ;
	private String  mem_email    ="" ;
	private String  mem_addr    ="" ;
	private String  mem_zipcode ="" ;

	private ArrayList<TakeExaminationVO> key = null;
	
	/*
	 * VO는 보통 테이블 컬럼을 담는 것이 일반적이지나 개발자가 필요한 정보도 추가로 담을 수 있다.
	 * r_status 는 proc_login 프로시저에서 사용되는 out 속성으로
	 * -1 / 아이디 를 담는 변수로 활용됨.
	 */
	public String r_status		="" ;
	public String msg			="";
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_zipcode() {
		return mem_zipcode;
	}
	public void setMem_zipcode(String mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}
	public String getR_status() {
		return r_status;
	}
	public void setR_status(String r_status) {
		this.r_status = r_status;
	}
	public ArrayList<TakeExaminationVO> getKey() {
		return key;
	}
	public void setKey(ArrayList<TakeExaminationVO> key) {
		this.key = key;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}


}
