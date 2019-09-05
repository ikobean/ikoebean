package com.di;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class insaSimul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com\\di\\listBean.xml");
		//인스턴스화 하는 순간 
		//insaList 클래스의 ListBean 전역변수에 이미 담겨 있음!
		
		insaList insa =(insaList)context.getBean("insa");
		System.out.println(insa.ListBean); //[Hi!!, Have a GREAT LUNCH!, Annnnnnd have a nice day :), XOXO]
		
		List<String> insaList = insa.ListBean;
		for(String hello:insaList) {
			System.out.println(hello);
		}
		
		
		
	}

}
