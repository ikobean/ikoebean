package com.ch7;

import java.util.ArrayList;

public class ArrayList2 {
/*
 * 사원 집합에서 사원번호가 7566인 사원에 대한 정보를 조회하여 ArrayList에 담고자 한다.
 * 제네릭 타입을 무엇을 해야 할까요?
 * 힌트:타입이 서로 다르다.
 */
	public static void main(String[] args) {

		//이름은 string
		//급여는 double
		//부서번호는 int
		String name = new String ("JONES");
		Double sal = new Double(3000.56);
		Integer deptno = new Integer(20);
		ArrayList<String> aList1 = new ArrayList<String>();
		ArrayList<Object> aList4 = new ArrayList<Object>();
		ArrayList<?> aList = new ArrayList<>();
		aList1.add(name);
		//aList1.add(sal);
		//aList1.add(deptno);
		aList4.add(name);
		aList4.add(sal);
		aList4.add(deptno);
		aList4.add(1, "우리 헤어져...");
		
		if(aList4.isEmpty()) {
			System.out.println("내 안에 아무도 없네......");
		}else {
			System.out.println("까꿍!");
		}
		
		
		
				
		
		for(Object obj:aList4) {
			if(obj instanceof String) { //너 혹시 스트링타입이야?
			System.out.println(obj.toString());
			
		}
			else if(obj instanceof Double) {
				System.out.println(((Double) obj).doubleValue()+10);
				System.out.println(Double.valueOf(obj.toString())+10);
			}
			else if(obj instanceof Integer) {
				System.out.println(obj.toString());
			}
	}
		String msg = aList4.remove(1).toString();
		System.out.println("msg:"+msg);
		System.out.println("===============[[after]]==================");
		for(Object obj:aList4) {
			System.out.println(obj.toString());
		}
	
	}
}
