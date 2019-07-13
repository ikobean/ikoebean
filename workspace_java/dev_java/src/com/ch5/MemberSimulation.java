package com.ch5;

public class MemberSimulation {

	public static void main(String[] args) {
	 member_0520 memVO = new member_0520();
	 /*
	  * MemberVO에는 여러 변수가 선언되어 있음.
	  * 그러나 선언만 되어 있음. 초기화는 안되어 있음.
	  * 즉 어떤 정보도 가지고 있지 않은 상태임.
	  * 어떤 정보를 초기화 해주어야 값을 꺼낼 수 있음.
	  */
      String mem_id = memVO.getMem_id(); //메소드 호출.
	  System.out.println(mem_id);      //null 초기화 전이라서
      //insert here - 멤버변수 mem_id에 값을 담아보세요
      
	  memVO.setMem_id("test");   //test --member_0520에서 호출 , 초기화됨
	                             //test를 setmem_id에 넣고 그 담에 getmem_id를 출력하면 테스트가 나온다!

	  System.out.println("after 아이디 :" + memVO.getMem_id()); // null - 13번 꺼가 호출된 것.
	                                //mem_id 변수에 값을 담을 수 있는 setter 메소드가 호출되기 전이므로 null이 들어있는 상태이므로 null을 출력하는 것임.
	  System.out.println("after 아이디 :" + mem_id);            // null 13번 꺼가 호출된 것
	   
	  
	  
    //  System.out.println("after 아이디 :" + memVO.mem_id); //오류나는 이유 - get/mem 설정이 안돼있음
	      //24번에서는 변수이름은 동일한 mem_id이지만 member_0520에 선언된 전역변수이다.
	      //그런데 접근제한자가 private이 왔으므로 변수 호출이 불가함.- 문법 에러 발생됨.
	} 
	

}






