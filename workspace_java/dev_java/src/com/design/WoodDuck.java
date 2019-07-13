package com.design;

public class WoodDuck extends Duck {
	
	public WoodDuck() {
		quackBehavior = new Mute();
		flybehavior = new FlyNoWay();
	}
	@Override
	public void display() {
		
	}

}
