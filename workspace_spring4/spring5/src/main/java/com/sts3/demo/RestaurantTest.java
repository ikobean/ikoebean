package com.sts3.demo;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class RestaurantTest {
	Logger logger = Logger.getLogger(RestaurantTest.class);
	@Autowired
	public Restaurant restaurant=null;
	
	@Test
	public void testExists() {
		assertNotNull("testExists 호출 성공");
		logger.info(restaurant);//주소번지
		logger.info("---------------------------------------");//주소번지
		logger.info(restaurant.chef);//주소번지
		logger.info(restaurant.chef.food.pig);
		logger.info(restaurant.chef.food.ddbbi);
		logger.info(restaurant.chef.food.want);
	}
}

