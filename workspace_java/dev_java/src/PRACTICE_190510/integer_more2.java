package PRACTICE_190510;

public class integer_more2 {

	public static void main(String[] args) {
	 String s = new String("hello"); //String 원래 클래스급 돌연변이입니다.
	 String s2 = new String("hello"); 
	 if(s.contentEquals(s2)) { //값을 비교하는 것
		 System.out.println("s가 가진 문자열 hello 와 s2가 가진 문자열 hello가 같니?");
		 //equals 메소드 . 자주나오는 메소드!		 
	 }
	 if (s==s2) {
	     System.out.println("s==s2가 같니 라고 묻는 건 문자열을 비교하는 게 아니고 주소번지가 같은지?");
	}
	 else {
		 System.out.println("s의 주소번지의 값과 s2의 주소번지 값이 다르다.");
		 
	 }
	}}
