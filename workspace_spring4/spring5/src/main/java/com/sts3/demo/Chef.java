package com.sts3.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class Chef {
	
	@Autowired
	public Food food = null;
	
	String ddbbi;
	
	public Chef() {
		this.ddbbi=ddbbi;
	}
	

}
