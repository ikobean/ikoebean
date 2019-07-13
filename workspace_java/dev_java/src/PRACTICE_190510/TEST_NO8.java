package PRACTICE_190510;

public class TEST_NO8 {

	private static int j = 0; //private 다른 클래스에선 쓸 수 없어요. 나만 쓸 수 있어!
	 
	 public static boolean methodB(int k) { //메소드 정의중
	 j = j + k; // j += k;
	  return true;
	 }
	
	 public static void methodA(int i) {//파라미터 자리에 i-지역변수
	 boolean b; //변수 선언 - 지역변수 : 초기화 반드시 해줘야해
	 System.out.println(i); //ok 메소드의 변수랑 메소드 안의 변수와 차이가 있음.
	 //b=false;
	// System.out.println(b); //error b는 넘어오는 값이 아님 그래서 안돼. b는 파라미터가 아니야
	 	 
	 b = i < 10 | methodB(4); 
	 b = i < 10 || methodB(8); 
	 }
	
	 public static void main(String args[]) {
	//자바는 같은 이름의 메소드를 여러개 선언할 수 있다.
		 //파라미터 갯수가 다르니까
		 
		 methodA(5);
		 
		 methodA(0);

	 System.out.println(j);
	 }
	 
	 
	 
	 


	}



