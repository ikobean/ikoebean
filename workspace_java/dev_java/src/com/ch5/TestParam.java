package com.ch5;
class Param{
	
	int ival = 0 ;
}
public class TestParam {
	 public void effectParam(Param p) {
		 p=new Param();   //나는 같은 타입을 여러번 했을 때 차이점에 대해 말할 수 있다.//복사본이 생긴다.
		 p.ival = 500;
		 //inser here - sub ival=? 500	    //500
		 System.out.println(p.ival);
		 
	 }
    public static void main(String[] args) {
	   TestParam tp = new TestParam();
	   Param p = new Param(); //인스턴스화
	   
	   
	   p.ival = 100;   //여기서 초기화가 다시 된거니까! 
	   p.ival = 200;
	   tp.effectParam(p); //500
	   //insert here = main ival =?        0
	   System.out.println(p.ival);  
	   
	   
	   

	}

}

