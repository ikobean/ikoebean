package com.design;

public class DuckSimulation {

	public static void main(String[] args) {

		Duck myDuck = new MallardDuck();
		myDuck.prefly();
		myDuck.preQuack();
		
		Duck myDuck2 = new RubberDuck();
		myDuck2.prefly();
		myDuck2.preQuack();
		
		Duck myDuck3 = new WoodDuck();
		myDuck3.prefly();
		myDuck3.preQuack();
		
	}

}

