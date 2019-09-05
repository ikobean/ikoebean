package com.sts3.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
 * @Component    ==> web을 지원하지 않음.
 * 	 android, java 는 지원. 
 * @Controller   ==> web 지원
 *
 */

@Component
public class Restaurant {
	@Autowired
	public Chef chef = null;
	
}

