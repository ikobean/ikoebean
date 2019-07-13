package com.ch7;

public class ParameterTypeA {
	void methodA(int jumsu[]){
		//insert here
		
		
		
		for(int i=0; i<jumsu.length;i++) {
			System.out.println(jumsu[i]);   //인덱스 사용 가능
			
		}
		for(int i:jumsu){ //매열의 인덱스를 사용할 수 없다.-구구단, 야구숫자게임
			System.out.println(i);			//인덱스 사용 불가
	   }
	}
	void methodB (String names[]){
		
		for(int i=0; i<names.length;i++) {
			System.out.println(names[i]);   //인덱스 사용 가능
			
		}
		for(String name:names){ //매열의 인덱스를 사용할 수 없다.-구구단, 야구숫자게임
			System.out.println(name);			//인덱스 사용 불가
	   }
	}
	
	void methodZ(int jumsu[], String names[]) {
		
		for(int i=0;i<jumsu.length;i++) {
			//System.out.println(jumsu[i]+":"+names[i]);
			System.out.println("names["+i+"]="+names[i]);
			
		}
			
	}	
	

	public static void main(String[] args) {
    
      //insert here - 배열선언 및 초기화 처리
		int jumsu[]=null;
		jumsu=new int[3];
		jumsu[0] = 70;
		jumsu[1] = 85;
		jumsu[2] = 100;
		
		ParameterTypeA pta = new ParameterTypeA();
		pta.methodA(jumsu);
		
		//이름
		String names[] = new String[3]; 		//null 선언만 한 것.
		String names2[] = new String[] {"정지우","유승기","정재현"}; //생성과 초기화 한 번에 		
		String names3[] = {"정지우","유승기","정재현"}; //초기화 		
		
		
		
		pta.methodB(names3);
		pta.methodZ(jumsu, names2);
		
	}
	
	

}
