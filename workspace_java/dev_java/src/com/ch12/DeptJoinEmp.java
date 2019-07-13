package com.ch12;

import java.util.List;

import com.vo.DeptVO;
import com.vo.EmpVO;
/*
 * 리턴타입이 참조형인 경우
 * 
 */

public class DeptJoinEmp {
	public void unitTest() {
		List<DeptVO> deptList = null;
		List<EmpVO> empList = null;
		DeptVO dvo = new DeptVO();
		dvo.setDNAME("ACCOUNTING");
		EmpVO evo = new EmpVO();
		evo.setEname("CLARK");
		evo.setEmpno(7782);
		dvo.setEmpVO(evo);
		//사원번호
		System.out.println(dvo.getEmpVO().getEmpno());
		//사원이름
		System.out.println(dvo.getEmpVO().getEname());
		//부서명
		System.out.println(dvo.getDNAME());
		
		dvo = new DeptVO();
		dvo.setDNAME("ACCOUNTING");
		evo = new EmpVO();
		evo.setEname("KING");
		evo.setEmpno(7934);
		
		
		dvo = new DeptVO();
		dvo.setDNAME("ACCOUNTING");
		evo = new EmpVO();
		evo.setEname("MILLER");
		evo.setEmpno(7934);
		
		
	}
	public static void main(String[] args) {
		DeptJoinEmp dje = new DeptJoinEmp();
		dje.unitTest();
	}

	
}
