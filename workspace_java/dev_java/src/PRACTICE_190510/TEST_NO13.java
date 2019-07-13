package PRACTICE_190510;

public class TEST_NO13 {

	int methodA(int i) {
	  		 i = 5;
	      return i;
	 	}

	public static void main(String[] args) {
		int x = 7;
		
		TEST_NO13 vt1 = new TEST_NO13();
		 vt1.methodA(3);
		 System.out.println(vt1.methodA(3));
		 
	 System.out.println("변수 x는" + x + "입니다.");
	

	}

}
