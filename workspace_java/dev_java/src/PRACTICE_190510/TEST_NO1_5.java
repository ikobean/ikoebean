package PRACTICE_190510;

public class TEST_NO1_5 {
	
	   static int i; //합법
	    int j; //non-static 타입은 static 영역에서 사용이 불가함.
	    
	public static void main(String[] args) {
		TEST_NO1_5 t3 = new TEST_NO1_5();
		System.out.println(t3.j);
		System.out.println(i);
		System.out.println(TEST_NO1_5.i);
		
		//1		
		String s = "this is a string";
		//String sing = ''; //싱글 불법
		char c = 'A'; //a는 문자 형 ab는 문자열
		String a = null;
		String a1 = "null"; //그냥 문자열 null 
		String s2 = (String) "abc";
		//캐릭터 타입은 하나밖에 안된다.
		String s3 = "This is a very\nlong string";
		System.out.println(s);
		System.out.println(a1);
		System.out.println(s2);
		System.out.println(s3);

		
		
        //2
		float f = 1f;
		float d = '1';
		
		float ff = 1F;
		long l = 5l;
		l=6L;
		float f2 = '1'; //캐릭터타입은 문자형,숫자형 다 담을 수 있음. 합법
		float f3 = (float)1.0d;
		
		
		//3
		boolean b = true;
		//boolean b = 0; 숫자랑 호환 안됨
		//boolean b = (boolean)0; 캐스팅 연산자 써도 안돼
		boolean b123 = ( 3 >= 0);
		System.out.println(b123);
		boolean b2 = Boolean.TRUE;
		System.out.println(b2);
		
		
		//4
		
		//1byte = 8bit = 2^7-1 = 128-1 
		//1bit => 4가지 표현 가능
		byte bb = 127; //ex)12700은 안담겨 커서
		System.out.println("bb:"+bb);
		
		
		byte q = 127;
		byte w = 126;
		//byte e = q - w;
		//System.out.println("q =" +q-w);
		//5
		//Integer a = new integer();
		System.out.println(w-q);
		String ab = "HELLO" + 9 + 1;
		System.out.println(ab);
		
		String bC = 1 + 9 +"HELLO";
		System.out.println(bC);
		
		//왜??????
		//+= //두항의 값을 더해 왼쪽 항에 대입합니다.
		
	//	boolean a = false;
		boolean bl = false;
		//boolean c = ((a = true) | (b = true));
		System.out.println(a + "," + b + "," + c);
		
		

		
		
	
		
	
		


	}

}
