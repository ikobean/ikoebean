package com.design;

public class MallardDuck extends Duck {
	
	public MallardDuck() {
		flybehavior = new FlyWithWings();
		quackBehavior = new Quack();
		
	}
	
	
	@Override
	public void display() {
			System.out.println("나는 청둥오뤼쓰");
			
	}

}
