package com.network2;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		String msg = "200|명석|경애|오늘 스터디할거야?";
		StringTokenizer st = new StringTokenizer(msg, "|");
		int protocol = 0;
		String tmp = st.nextToken();
		String me = st.nextToken();//명석
		String you = st.nextToken();//경애
		String msg1 = st.nextToken();//msg
		if(tmp!=null) {
			protocol=Integer.parseInt(tmp);
		}
		System.out.println(tmp+","+me+","+you+","+msg1);
		/*
		 * switch() { case 110: case 200: case 300: }
		 */
	}

	
}