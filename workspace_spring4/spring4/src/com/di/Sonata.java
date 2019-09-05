package com.di;

public class Sonata {
	String carColor = null;
	int speed = 0;
	int wheelNum = 0;
	int price = 0;
	
	public Sonata() {
		
		
	}
	public Sonata(String carColor, int speed) {
		 carColor = carColor;
		this.speed	  = speed;
	}
	public Sonata(String carColor, int speed,int wheelNum) {
		this.carColor 	  = carColor;
		this.speed	 	  = speed;
		this.wheelNum	  = wheelNum;
	}
	
	public Sonata(String carColor, int speed,int wheelNum,int price) {
		this.carColor 	  = carColor;
		this.speed	 	  = speed;
		this.wheelNum	  = wheelNum;
		this.price		  = price;
	}
	
	public String toString() {
		return "그녀의 자동차는"+this.carColor
				+"이고, 현재 속도는"+this.speed
				+"바퀴수는  "+this.wheelNum
			    +"가격은 "+this.price;
				
	}
}
