package com.vo;

import java.io.Serializable;

public class MemberVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4137373418319886949L;
	String  mem_id      ="" ;
	String  mem_pw      ="" ;
	String  mem_name    ="" ;
	String  mem_addr    ="" ;
	String  mem_zipcode ="" ;
	
	
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

}
