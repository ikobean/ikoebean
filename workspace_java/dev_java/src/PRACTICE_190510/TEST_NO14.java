package PRACTICE_190510;

public class TEST_NO14 {
 int i = 10;
 
 void methodA(double i ) {
	 i = 3.14d;
	 System.out.println("변수 i는 " + i + "입니다.");
	 
 }
	public static void main(String[] args) {
	double d = 3.14;
	TEST_NO14 co = new TEST_NO14();
	co.methodA(d);

	}

}
