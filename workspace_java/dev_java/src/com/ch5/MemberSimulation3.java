package com.ch5;

public class MemberSimulation3 {

	public static void main(String[] args) {
		member_0520 mVO = new member_0520(10);
		mVO = new member_0520();
		//파라미터에 준 상수 값들은 xxxx에 담긴다.
		mVO = new member_0520("test","123","이순신","서울시 금천구 가산동","21689");
	
		
		System.out.println(mVO.getMem_id());
		System.out.println(mVO.getMem_name());
	    System.out.println(mVO.getMem_pw());
		System.out.println(mVO.getMem_addr());
		System.out.println(mVO.getMem_zipcode());

				
		
		
		

	}

}

