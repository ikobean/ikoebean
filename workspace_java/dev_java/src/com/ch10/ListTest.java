package com.ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListTest {
	public static void methodA(List<String> list) {
		list.add("바나나");
		for(String fru:list) {
			System.out.println(fru);
		}
		
		
	}
	public static void methodA(ArrayList<String> list) {
		
	}
	public static void methodA(Vector<String> list) {
		
	}
	public static void main(String[] args) {
		//싱글스레드에서 안전. 대신 읽고 쓰기 속도는 벡터보다 빨라
		ArrayList<String> deptList = new ArrayList<String>();
		
		//멀티스레드에서 안전. 대신 읽고 쓰기가 어레이리스트보다 느리다.
		Vector<String> v_deptList = new Vector<String>();
		
		/*
		 * 	List 인터페이스의 구현체 클래스는 ArrayList, Vector, LinkedList... 
		 															*/
		
		
		
		List<String> a_list = new ArrayList<String>();   			//권장코딩방법
		a_list.add("사과");
		a_list.add("딸기");
		a_list.add("수박");
		
		
		ListTest.methodA(a_list);
		//ListTest.methodB(a_list);
		//ListTest.methodC(a_list);

		
		List<String> v_list = new Vector<String>();   				//권장코딩방법
		v_list.add("오렌지");
		v_list.add("망고쓰");
		v_list.add("파인애플");
		
		ListTest.methodA(v_list);
		
		//list = v_deptList;
		
	}
	
	

}


