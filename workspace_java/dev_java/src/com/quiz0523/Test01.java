package com.quiz0523;

import java.util.Random;

public class Test01 {

	int a[] = new int [10]; //배열. 방 10개를 만들겠다!
	
	public void orderBy() {
		int tmp=0;  //비어있는 변수를 하나 만듦
		
		
		for(int i =0; i<a.length;i++) { //i=0초기화, 방의 길이만큼 반복, i++하면서)
			for(int j=i+1;j<a.length;j++) { //똑같은 방끼리 비교해보겠다. 같은 방에 있는 애들은 값이 같으니까 비교 안함!
				if(a[i]> a[j]) { //만약에 i==5 , j==2 //
			    	tmp = a[i];  // tmp==5   i==5  //
				   a[i]=a[j];    //  i==2 j==2     //
				   a[j]=tmp;    // j==i+1==5 tmp==5     //
				   }/////end of if
			}///////////end of inner for
		}////////////end of outter for
	}//////////////
	

	public void arrayInit() {
	Random r = new Random();
	for(int i =0; i<a.length;i++) {
		a[i]=r.nextInt(21);
		
	}
	}
	public void arrayPrint() {
		for(int i =0; i<a.length;i++) {
			System.out.println(a[i]);
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
	 Test01 t1 = new Test01(); //인스턴스화
	 t1.arrayInit(); //arrayinit을 부름
	 
	 System.out.println("==============[[before]]============");
	 t1.arrayPrint();
	 t1.orderBy();
	 System.out.println("==============[[after]]============");
	 t1.arrayPrint();
	 
	 
	 

	 
	 
	}

}

