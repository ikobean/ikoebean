package PRACTICE_190510;

public class TESTNO05 {
    static int i; //합법
  
	public static void main(String[] args) { //왼쪽 더블클릭해서 구슬모양
		
	
		Integer a = new Integer(10);
		Integer b = new Integer(10); 
		Integer c = a; 
		int d =10;
		double e = 10.0;
		//증명//
		if(a==c) {
			System.out.println("참");
			}
		if(10==10.00001) {
			System.out.println("참");
		}
		if(b==d) {
			System.out.println("참");
		}
		else {
			System.out.println("거짓");
		}
				 int dd = 10;
		 double ee = 10.0;
		 
		 Integer qwer = new Integer(10);//int타입에 대한 Wrapper클래스이다.
		 System.out.println(qwer);
		 int ii;
		 i=qwer; //오토박싱
		 
		 i=a.intValue(); //원래는 이렇게 해줘야됨.  //왼쪽 마우스 우클릭해서 북마크 
		                                    //오른쪽 마우스 클릭하고 debug F6 
		                          //창 없어졌을 경우 찾는 방법 WINDOS-SHOWVIEW-VARIABLES
		 
		 }
		

	}


