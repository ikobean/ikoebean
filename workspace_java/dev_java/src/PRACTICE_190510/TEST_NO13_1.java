package PRACTICE_190510;

public class TEST_NO13_1 {

  void methodA(int x) {
	 x = x+5;
	 	 System.out.println("변수 x는" + x +" 입니다.");
 }	
	

	public static void main(String[] args) {
		TEST_NO13_1 vt1 = new TEST_NO13_1();
		int i = 5;
		vt1.methodA(i);
				
		 
	}

}
