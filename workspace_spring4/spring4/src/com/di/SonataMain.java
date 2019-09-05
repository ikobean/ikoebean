package com.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class SonataMain {
	
	public static void main(String[] args) {
		
	
	Resource resource = new FileSystemResource("D:\\workspace_jsp\\spring4\\src\\com\\di\\sonataBean.xml");
	BeanFactory factory = new XmlBeanFactory(resource);
	
	//객체생성
	Sonata sonata = (Sonata)factory.getBean("myCar");
	//객체소멸
	sonata = null; //candidate 상태로 전환되는 코드.
	
	ApplicationContext context = 
			new ClassPathXmlApplicationContext("com\\di\\sonataBean.xml");

	Sonata myCar   = (Sonata)context.getBean("myCar");
	Sonata herCar  = (Sonata)context.getBean("herCar");
	Sonata himCar  = (Sonata)context.getBean("himCar");
	Sonata herCar2 = (Sonata)context.getBean("herCar2");
	
	System.out.println(myCar.carColor);
	System.out.println(myCar.speed);
	System.out.println(myCar.wheelNum);
	
//	System.out.println(myCar.toString());
//	System.out.println(herCar.toString());
//	System.out.println(herCar2.toString());
//	System.out.println(himCar.toString());
//	
	System.out.println(myCar);
	System.out.println(herCar);
	System.out.println(himCar);
	System.out.println(herCar2);
	
	}
}
