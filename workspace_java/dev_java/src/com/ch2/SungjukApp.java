package com.ch2;
/* 메소드의 리턴 타입이 필요한 경우 - void 쓰면 안 됨. 
 * 왜냐하면 유지되지 않으니까.
 * 왜냐하면 stack 영역에 사는 변수라서 자동으로 소멸되니까
 * 필요없을 때 - 그 메소드의 실행 결과가 다른 메소드에 사용될 필요가 없으면 void
 * 
 */

    public class SungjukApp {
    double total() {
    return 85;   // 변수 이름만 와야할 때,없어도 될 때,있어야할 때가 다 다름
                 //void 리턴 값이 필요 없음   
    	
    }}

    public class SungjukApp {
        void total(){

        }
        }
        //return 85;   // 변수 이름만 와야할 때,없어도 될 때,있어야할 때가 다 다름
           //void 리턴 값이 필요 없음
  
      public static void main(String[] args) {
		SungjukApp sjApp = new SungjukApp();
		double hap = sjApp.total();		
		System.out.println(sjApp.total());
		
	 {
	         // 변수 이름만 와야할 때,없어도 될 때,있어야할 때가 다 다름
	                     //void 리턴 값이 필요 없음   
	        	
	        }
	    	
	
