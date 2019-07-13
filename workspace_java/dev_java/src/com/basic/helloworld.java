package com.basic;
//나는 클래스 입니다.
//클래스 이름은 Helloworld입니다.
public class helloworld {
	//Ctrl+S 저장 된 후 즉시 컴파일 해줌 (eclipse)
	//한글에서 코딩을 하면 안된다! 왜? 컴파일을 안해주기 때문에
	public static void main(String[] args) {
		// 여기는 메인메소드 입니다.
	    //명사형을 쓸 수 있다.
		//변수 선언하기 (공간을 만들어 주는 작업)
		//변수 이름은 직관적으로 이름을 저장할 때는 쌍따옴표
		//대입연산자가 있다.=
		//같다 1==1 기호 두 번 써야 함
		//같다 1==1 참(true)
		
		int sal = 800;
		//sal = 300;
		//오른쪽에 있는 걸 왼쪽에 담아주세요 (=)
		//변수를 선언했고 대입연산자를 사용해서 그 변수에 800(값)을 저장했어요
		//정수를 담을 때 타입은 반드시 int를 사용한다.
		//변수 sal안에 담겨있는 800숫자 출력해 보기(화면)
		//System - 너 pc를 가리킴
		//out - 명사형인데 출력을 내보낼 때 사용하는 명사형
		//println() - 메소드야 메소드는 뭐야?동사 -화면에 출력을 할 수 있다.
		//sys +ctrl space - sys out- 엔터 - 500입력 - 오른쪽마우스 클릭- run as
		System.out.println(sal);//800
		System.out.println(sal+10);//810
		System.out.println(sal+100);//900
		sal = sal+30;
		System.out.println(sal+200);//1000
		System.out.println(sal+300);//1100
		System.out.println(sal+300);//1100
		System.out.println(sal*300);//1100
        //아래 코드는 변수를 사용하지 않았다.
		System.out.println(500);//500은 상수이다.
		System.out.println(sal*3-3);
		//int : 타입 이름, 자바에서는 여러가지 타입을 제공함
		//오라클에 저장된 정보가 여러가지임
		//SELECT ename, sal FROM emp
		//ename==컬럼명
		//변수 선언 할 때 : 타입(int)쓰고 변수쓰고 변수 
		//name="SMITH"
	    //=는 대입연산자
				//뒤에 ()가 있으면 method {}가 있으면 클래스
		//저장하면 컴파일이 된다. 실행할 때는 run as

	}
}

