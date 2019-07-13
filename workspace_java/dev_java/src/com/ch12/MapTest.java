package com.ch12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest {
	/*
	 * deptMap은 지변이다.
	 * 지역변수를 다른 메소드에서 사용하려면 어떡하지?
	 * 1)파라미터
	 * 2)리턴타입
	 */

	public void setMap() {
		List<Map<String,Object>> deptList = new ArrayList<>(); //0
		Map<String,Object> deptMap = new HashMap<>();
		Map<String,Object> empMap = new HashMap<>();
		mapPrint(deptMap);
		
		deptMap.put("deptno",10);
		deptMap.put("dname","ACCOUNTING");
		deptMap.put("loc","NewYork");
		deptList.add(deptMap);

		deptMap = new HashMap<>();
		deptMap.put("deptno",20);
		deptMap.put("dname","RESEARCH");
		deptMap.put("loc","DALLAS");
		deptList.add(deptMap);
		
		deptMap = new HashMap<>();
		deptMap.put("deptno",30);
		deptMap.put("dname","SALES");
		deptMap.put("loc","CHICAGO");
		deptList.add(deptMap);
		
		deptMap = new HashMap<>();
		deptMap.put("deptno",40);
		deptMap.put("dname","OPERATION");
		deptMap.put("loc","BOSTON");
		deptList.add(deptMap);
		
		mapPrint(deptList);
		
	}
	private void mapPrint(List<Map<String, Object>> deptList) {
	// List -> Map -> map.get(key)
		for(int i=0; i<deptList.size(); i++) {
			//System.out.println(deptList.get(i)); //Map에 대한 주소번지
			Map<String,Object> rMap = deptList.get(i);
			Object keys[] = rMap.keySet().toArray();
			for(int j=0; j<keys.length;j++) {
				System.out.print(rMap.get(keys[j]));
				if(j==keys.length) {
					break;
				}
				System.out.print(" ");
			}
			System.out.println(); //줄바꿈처리
		}
		
		
	}
	public void mapPrint(Map<String,Object> deptMap) {
		System.out.println(deptMap.get("deptno"));
		//get은 자바에서 제공하는 메소드
		//System.out.println(deptMap.get("deptno");
		//Set은 집합을 담을 수 있는 클래스이다.
		//Map에 담긴 key 하나를 집합으로 생각하여 Set안에 keyset 메소드를 제공함
		Set<String> set = deptMap.keySet();
		//Set안에서 키값을 꺼내야 하는데 3개이므로 (또는 n개가 될 수도 있음)
		//toArray 메소드를 호출하면 Object배열에 담아줌.
		Object keys[] = set.toArray();
		for(int i=0; i<keys.length;i++) {
			System.out.println(keys[i]);
			
		}
		
		
		Collection<Object> val = deptMap.values();
		Object vals[] = set.toArray();
		for(int j=0; j<vals.length; j++) {
			System.out.println(vals[j]);
		}
		/*
		 * 정리하기
		 * list도 꺼낼 때는 get메소드를 호출하지만 파라미터가 int이고
		 * map은 파라미터가 Object이다.
		 * list에 담을 때는 add, map에 담을 때는 put
		 * list에서 꺼낼 때는 get(int), - map에서 꺼낼 때는 get(Object)
		 */
		
		
	}
	public static void main(String[] args) {
		MapTest mt = new MapTest(); //초기화 먼저 사용이 나중
		mt.setMap();
		//mt.mapPrint(null);
		//도전 - 만일 키 종류가 100가지 라면 어떡하지?
		
		//도전2 - 여러개의 행을 담으려면 어떡하지?
		
		
	}

}
