package com.ch5;
/*
 *  이중에서 500명만 로그인을 한다고 가정하더라도 이 500명의 정보를 따로 관리해야 함.
 * 그러기 위해서는 같은 테이블에서 읽어온 정보이지만 자바단에서 식별이 가능해야 하므로
 * 타입은 같지만 객체 생성을 500번 했을 경우 서로 다른 객체로 인식되어 각각 다른 아이디를 기억하고 있음.
 */
/*
 * 변수의 장애 - 같은 타입 1개만 담을 수 있음
 * VO 패턴 설계 - 서로 다른 타입 n개를 담을 수 있다.
 * 인스턴스화를 통해서 전역변수 초기화 가능.
 */
public class MemberSimulation2 {

	public static void main(String[] args) {
          member_0520 memVO1 = new member_0520();
          memVO1.setMem_id("haha");
          
          member_0520 memVO2 = new member_0520();
          memVO2.setMem_id("apple");
          
          member_0520 memVO3 = new member_0520();
          memVO3.setMem_id("nono");
          //insert here -
            
          System.out.println(memVO1.getMem_id());
          System.out.println(memVO2.getMem_id());
          System.out.println(memVO3.getMem_id());
    
          member_0520 memVO = new member_0520();
          memVO.setMem_id("haha");          
          System.out.println(memVO.getMem_id());
          
          memVO.setMem_id("apple");          
          System.out.println(memVO.getMem_id());
          
          memVO.setMem_id("nono");          
          System.out.println(memVO.getMem_id());
          
          //같은 타입을 여러번 했을 때 차이점에 대해 말할 수 있다.
            
          
	} 

}


