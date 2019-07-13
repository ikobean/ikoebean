package com.quiz0607;

import java.util.Arrays;

public class Quiz06 {
	
	String str[] = {"1", "2","3"};

	Object [] myObjects = {
			new Integer(12),
			new String("foo"),
			new Integer(5),
			new Boolean(true)
	};
	
	public void methodA() {
	//Arrays : 클래스  (api?)
	//sort : my objects들이 비교할 수 있는 타입이 아니라서 에러가 발생한다~
	//아래 코드가 없으면 다 나옴! 트라이 캐치 구문에 넣으면 정상적으로 !
		try {
			Arrays.sort(myObjects); //정렬시 형변환 오류 발생
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.toString());
		}
	for (int i=0; i<myObjects.length;i++) {
		System.out.println(myObjects[i].toString());
		System.out.println("    ");
		}
	}
	
	public static void main(String[] args) {
		Quiz06 q6 = new Quiz06();
		q6.methodA();
		
		
	}
	

	
}


