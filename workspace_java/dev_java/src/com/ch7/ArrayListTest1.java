package com.ch7;

import java.util.ArrayList;

public class ArrayListTest1 {
	//맥북 3대를 담을 참조변수가 필요하다.
	///ArrayList를 초기화해줄 메소드 생성
	public ArrayList<OneBillion> setArrayList() {//담기
		ArrayList money = new ArrayList();
		ArrayList<OneBillion> money2 = new ArrayList<OneBillion>();
		
		OneBillion mymoney = new OneBillion("It is mine");
		OneBillion lotto = new OneBillion("I earned");
		OneBillion rich = new OneBillion("That is why i am a");
		
		//System.out.println(mymoney.name);
		
		
		boolean ismymoney = money2.add(mymoney);
		if(ismymoney) System.out.println("담기성공");
		else System.out.println("담기실패");
		
		boolean islotto = money2.add(lotto);
		if(islotto) System.out.println("담기성공");
		else System.out.println("담기실패");
		
		boolean isrich = money2.add(rich);
		if(isrich) System.out.println("담기성공");
		else System.out.println("담기실패");
		return money2;
	}
	public static void main(String[] args) {
		ArrayListTest1 a1 = new ArrayListTest1();
		//메소드의 리턴 타입으로 주소번지를 받아온다.
		ArrayList<OneBillion> money = a1.setArrayList();
		//개선된 for문을 사용하여 반복처리
		for(OneBillion obj:money) {
			//ArrayList 안에 담긴 타입이 money 이므로 타입을 맞춘다.
			OneBillion ob = (OneBillion)obj;
			//System.out.println(obj);
			//주소번지를 활용하여 전역변수를 출력한다.
			System.out.println(ob.name);
		}
		System.out.println("===============================================");
		for(int i=0;i<money.size();i++) {
			//OneBillion ob = (OneBillion)money.get(i);
			OneBillion ob2 = money.get(i);
			String name = ob2.name;
			System.out.println(name);
			
		}
		
		
	}

	
}
