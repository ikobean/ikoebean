package com.ch14;

public class Exception_3 {
	/*
	 * 메소드 뒤에 throws를 붙이면 예외처리를 나를 호출한 곳에서 
	 * 처리 받아라... 의미
	 */
	void methodA(String imsi){
		
		System.out.println("methodA 호출");
		int x = Integer.parseInt(imsi);
		throw new NumberFormatException();
	}
	
	/*
	 * try...catch블록은 예외상황이 발생했을 경우에만 효과가 있다.
	 * 예외상황이 없다면 있으나 마나한 코드
	 * 
	 */
	public static void main(String[] args) {
		Exception_3 exc3 = new Exception_3();
		/*
		 * 멀티블럭으로 처리할 경우 하위 클래스에서 상위 클래스 순으로 작성함
		 * 만일 같은 이름의 exception이 존재하지 않으면 더 넓은 범위(상위클래스)가 잡는다.
		 */
			try {
				exc3 = new Exception_3();
				exc3.methodA("123");
				
			}catch(ArithmeticException ae) {
				System.out.println("Exception"+ae.toString());
				ae.printStackTrace();
			}
			catch(NumberFormatException ne) {
				System.out.println("Exception:" +ne.toString());
				
			} catch (Exception e) {
				System.out.println("Exception:" +e.toString());
		
		
	}
	
}
}
