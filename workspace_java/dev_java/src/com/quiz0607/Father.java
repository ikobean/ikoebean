package com.quiz0607;

public class Father {
	public void methodA() {
		System.out.println("Father methodA 호출 성공");
		}
	 public static void main(String args[]) {
		 Father fa1 = new Father();
		 Father fa2 = new Son();
		 Son so2 = new Son();
		 //fa1.methodA();
		 //fa2.methodA();
		 //so2.methodA();
		 //so2 = (Son)fa1; // = so2 = new Father();와 같은 뜻 //so2 = new Father();
		 //so2 = (Son)fa1; //so2 = new Father();
		 so2 = (Son)fa2; //= so2 = new Son();과 같은뜻.
		 so2.methodB();
		 //fa1.methodB(); 아들한테만 있는건 아빠걸루 안돼~~~
		 //fa2.methodB(); //왜안돼? Son 안에 있는거지만 methodB는 father한테 상속받은 메소드가 아니라서 에러
		 
		 //부모타입으로 선언한 변수로 호출할 수 있는 메소드는 부모에도 있고 자녀에도 있는거
		 //부모한테 없고 자녀한테만 있는거 이건 에러
		 
	 }
}
	class Son extends Father{
		@Override
		public void methodA() {
			System.out.println("Son methodA 호출 성공");
		}
		public void methodA(int a) {
			System.out.println("Son methodA 호출 성공");
		} //이거슨 오버로딩
		public void methodB() {
			System.out.println("Son methodB 호출 성공");
		}
	}

