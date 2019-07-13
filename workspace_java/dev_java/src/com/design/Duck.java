package com.design;

public abstract class Duck {
	int leg;
	FlyBehavior flybehavior = null;
	QuackBehavior quackBehavior = null; //클래스보다 상위이다. 여러개 사물을 포용할 수 있어야 하니까.
		
	public Duck() {
		
	}
	public void prefly() {
		flybehavior.fly();
	}
	
	public void preQuack() {
		quackBehavior.quack();
	}
	
	public abstract void display(); //추상메소드. 모든 오리의 생김이 달라달라달라
	public void swimming() {
		System.out.println("오리는 물에 둥둥");
		
		
		
	}
}


