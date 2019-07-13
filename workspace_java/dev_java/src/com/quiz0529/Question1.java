package com.quiz0529;

import javax.swing.JButton;

public class Question1 {

	public static void main(String[] args) {
		int x1, y1, z1;
		int []a,b,c;
		int a1[],b1,c1;
		//b=10;
		//c=20; 안됨
		b=new int[10];
		c=new int[20];
		//[]괄호가 앞에 있으면 그것만 배열이고 뒤의 변수는 아님.
		//---배열기호가 앞에 있으면 뒤에 선언된 변수도 모두 배열
		b1=10;
		c1=20;
		//[]괄호가 뒤에 있으면 뒤에 것도 싹 다 배열
		
		int []x = {1,2,3,4,5};
		int y[] = x;
		System.out.println(y[2]);
		
		JButton jbtn_save = new JButton("저장");
		JButton jbtn_imsi = null;
		jbtn_imsi = jbtn_save;
		System.out.println(jbtn_imsi.getText()); //저장출력
	
	}

}
