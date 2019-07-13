package com.network2;

import java.util.List;
import java.util.Vector;

public class RoomSimulation {

	public static void main(String[] args) {
		List<Room> roomList = new Vector<>();
		//room클래스에 파라미터 2개인 생성자가 있음.
		Room room = new Room("자바52기",27);
		roomList.add(room);
		
		room = new Room("자바51기",3);
		String n1 = "내복이";
		String n2 = "러키";
		String n3 = "후쿠";
		room.nameList.add(n1);
		room.nameList.add(n2);
		room.nameList.add(n3);
		
		roomList.add(room);
		room = new Room("자바50기",15);
		roomList.add(room);
		
		
		
		for(int m=0; m<roomList.size();m++) {
			Room rm = roomList.get(m);
			if("자바51기".equals(rm.title)) {
				System.out.println(rm.current);
			}
		}
		//
		
		for(int m=0; m<roomList.size();m++) {
			Room rm = roomList.get(m);
			if("자바51기".equals(rm.title)) {
				for(String name:rm.nameList) { //for(받아주는애(타입) 변수명: 전체집합) 전체집합에서 한번씩 꺼내옴
				System.out.println(name);
				}			
			}
		}
		
		for(int i=0; i<roomList.size();i++) { //룸리스트사이즈 =3 
			Room rm = roomList.get(i); //룸리스트.인덱스 . 세번돌려서 i에는 0 1 2가 들어가고.
						//rm에는 주소번지. roomlist의
			System.out.println(rm);
			if("자바50기".equals(rm.title)) {
				System.out.println(rm.current);
			}
				//insert hear
				for(int j=0; j<rm.nameList.size();j++) {
					System.out.println(rm.nameList.get(j));
				/*향상된 for문
				 * for(String devil:rm.nameList) { System.out.println(devil); }
				 */
						
				}
			
		}
	}
}
