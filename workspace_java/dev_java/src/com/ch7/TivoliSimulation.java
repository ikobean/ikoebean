package com.ch7;



class Tivoli{
	String carName=null; //전역변수
	
	Tivoli(){} //디폴트생성자
	
	Tivoli(String carName){ //파라미터가 있는 생성자
	 this.carName = carName;
	 }
}
public class TivoliSimulation {
	
  Tivoli methodA() {
	  return new Tivoli();
    }
  
    void methodB(Tivoli herCar) {
    	herCar.carName = "2020년형 티볼리";
    }
    
    
	public static void main(String[] args) {
		TivoliSimulation ts = new TivoliSimulation();
		Tivoli myCar = ts.methodA();
	    myCar.carName = "2019년형 티볼리";
	    System.out.println(myCar.carName);
	    

	}
	
	

}
