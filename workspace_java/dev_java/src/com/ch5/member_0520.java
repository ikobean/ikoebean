package com.ch5;
/*
 *  DVD대여관리 시스템에서 필요한 회원테이블을 관리할 클래스 정의
 *  테이블 컬럼을 전역변수로 사용한다.
 *  단 접근제한자를 private으로 하여 외부에서 임의로 변조 못하도록 방지
 */

//insert here


public class member_0520 {
	
	public member_0520() {
		 
	}

	 public member_0520(int a) {
		 	 }
	
	
	
	 
	
	
  private String mem_id       = null; //회원아이디
  private String mem_pw       = null; //회원비번
  private String mem_name     = null; //회원명
  private String mem_addr     = null; //회원주소              //cntrl shift y -> 한 번에 소문자로 바꿔줌
  private String mem_zipcode  = null; //회원 우편 번호      //alt shift a 토글 블락 셀렉션 모드 //한 번에 삭제 가능

  //getter - 읽기, 리턴타입 있다. 
  
  
  public member_0520(String mem_id, String mem_pw, String mem_zipcode, String addr, String mem_name ) {
	          this.mem_id=mem_id;
			  this.mem_pw=mem_pw;
			  this.mem_name=mem_name;
			  this.mem_addr=mem_addr;
			  this.mem_zipcode=mem_zipcode;
	// TODO Auto-generated constructor stub
}

public String getMem_id() {
	return mem_id;
	}
  //setter - 저장/쓰기, 파라미터가 있다. 리턴타입 없다. 
  
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



