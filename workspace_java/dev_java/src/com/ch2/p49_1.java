package com.ch2;

public class p49_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int i = 5;
		int j = 10;
		System.out.println("i:"+i);//5
			i = j; //j를 i에 대입하라
		System.out.println("i:"+1);//10	}
		System.out.println(i+j);//20	}
		//int+int=int
		//int+String=String
		System.out.println("10"); //10은 따옴표 안에 있어서 문자로 인식
		//int-int=int
		//int/int=int
		//int*int=int
		System.out.println(""+i+j);//1010-""나열}
		System.out.println(""+(i+j));//20	}
		//int x = 3.14; //문법에러
		int p =(int)3.14; //강제 형전환 
		System.out.println("p:"+p);	

	}
}
