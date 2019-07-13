package com.ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class DeptJoinEmp_1 {
	
	 List<Map<String,Object>> list = null;
	 Map<String,Object> rMap = null;
	 
	 public void listPrint() {
		 unitTestVer2();
		 //Iterator는 자료구조(컬렉션 프레임 워크)안에 있는 정보의
		 //유무를 체크해주는 메소드를 지원함.
		 Iterator<Map<String,Object>> it = list.iterator();
		 while(it.hasNext()) {
			 Map<String,Object> pMap = it.next();
		 }
		 
	 }
	
	public void unitTestVer2() {
		//정보는 아래 코드에서 입양하기
		//Map에는 여러개 행을 담을 수가 없대요.
		//그럼 어떡하지????????????
		//List에 제네릭 형태로 담아서 써보자.
		//<>다이아몬드 연산자
		list = 	new ArrayList<>();
		rMap = new HashMap<String,Object>();
		rMap.put("empno", 7934);
		rMap.put("ename", "MILLER");
		rMap.put("dname", "ACCOUNTING");
		list.add(rMap);
		
		rMap = 
				new HashMap<String,Object>();
		rMap.put("empno", 7782);
		rMap.put("ename", "CLARK");
		rMap.put("dname", "ACCOUNTING");
		list.add(rMap);
		
		rMap = 
				new HashMap<String,Object>();
		rMap.put("empno", 7839);
		rMap.put("ename", "KING");
		rMap.put("dname", "ACCOUNTING");
		list.add(rMap);
		
	}
	
	public static void main(String[] args) {
	}

}
