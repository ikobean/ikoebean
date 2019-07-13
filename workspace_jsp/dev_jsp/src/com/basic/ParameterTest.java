package com.basic;
import java.util.HashMap;
import java.util.Map;
class Param {
	int ival=0;
	
}



public class ParameterTest {
	/*
	 * 리턴타입이 void 이다. 내가 설계한 메소드가 아닐 때
	 * public void doGet();//override
	 * 1)해결방법 첫번째 - 전변 사용하기
	 * - 전제조건 ==> 반드시 인스턴스화를 해야 함.
	 * 그런데 서블릿은 내가 인스턴스화를 직접하는가?login.nhn
	 * 그럼 누가 인스턴스화를 한거지? - Tomcat -> 객체주입법 -> 인스턴스화
	 * 
	 * 2) 서블릿은 개발자가 직접 인스턴스화하지 않음. ==> 불가함.
	 * 3) 해결방법 두번째 - 파라미터를 이용함. 
	 */
	public void methodA(Map<String, Object> target) {
		target.put("account", 5000); //NullPointerException이 일어난다.
		System.out.println(target);
	}
	
	public void methodB(int i) {
		System.out.println(i);
	}
	
	public void methodC(Param p) {
		int i = p.ival; //여기서는 NULL 일어나지 않음. 왜냐하면 호출할 때 인스턴스화를 했으니까.
	}
	
	public static void main(String[] args) {
		ParameterTest ptest = new ParameterTest();
		ptest.methodB(10); //10
		Param p = new Param();
		p.ival=500;
	
		p=null;
		ptest.methodC(p); 
		
		//아래 코드에 대해 설명해 보세요.
		Map<String,Object> target = null;
		//ptest.methodA(target);
		//완결편
		//methodA에서 충전된 5000원을 여기에서 사용하고 싶다. 어떡하지?
		target = new HashMap<>();
		ptest.methodA(target);
		System.out.println(target.get("account"));
		
	}

}
