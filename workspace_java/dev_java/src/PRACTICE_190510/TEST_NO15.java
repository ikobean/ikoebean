package PRACTICE_190510;

public class TEST_NO15 {
    int a1, a2, a3=0;
    
    void initial() {
    	a1 = 7;
    	a2 = 14;
    	a3 = 21;	
    	
    }
    
    void methodA() {
    	int account;
    	//insert here
    	account = a1+a2+a3;
    	System.out.println("a1+a2+a3=" + account +"입니다.");
    	
    
    	
    	
    }
	public static void main(String[] args) {
		TEST_NO15 vl1 = new TEST_NO15();
		vl1.initial();
		vl1.methodA();
		
	}

}


