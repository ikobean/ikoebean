package com.ch2;

public class VariableTest1 {
	 /*
	  * non-static 타입의 변수는 static영역에서 사용불가
	  * 해결방법이 있다. -인스턴스화를 하면 가능함.
	  * 전역변수는 초기화를 생략할 수도 있다. 이유? 생성자가 대신해주니까...
	  */
     int i=100;//전역변수이다. 다른 메소드에서도 사용이 가능하다.
     //int i, i = 100; 이렇게 못씀. 한 번에 써야함. 전역변수라서
     
     void methodA() { //static을 지웠음. 그래야 오류 안남
    	//지역변수는 반드시 초기화를 해야됨. 안하면 컴파일 에러
    	 int i; //지역변수
    	 i=10; //100|10
     	 System.out.println(i); 
     }
     
     
     void methodA(String cat) { //메소드의 파라미터 자리에도 지역변수를 선언할 수 있다.
    	 cat = "고양이";  	 
    	 System.out.println(cat); //메소드 이름은 같지만 파라미터로 구분함.
    	 //여기에 있는 i는 전역변수 i야! 왜냐면 초기화를 안했으니까!
     }
     /*
     void methodA(String id, string pw) { //메소드의 파라미터 자리에도 지역변수를 선언할 수 있다.
    	 System.out.println(i); //
    	     }*/
	public static void main(String[] args) {
      VariableTest1 vt = new VariableTest1(); //메모리에 영역을 만든거
      vt.methodA("Abc"); //나는 메소드를 만든거고. 메소드를 호출한 거임/ 내가 int타입을
      //썼으니까 아무 숫자나 넣어도 90이 출력됨
      vt.methodA();//메소드 호출하기
       
      System.out.println(vt); //@abcd1234주소번지 16진법
      System.out.println(vt.i);
      /* vt=리모콘 같은 거
       그래서 i를 부를 수 있음   */
      

	}

}
