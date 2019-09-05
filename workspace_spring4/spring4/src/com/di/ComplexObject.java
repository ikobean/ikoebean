package com.di;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ComplexObject implements Controller {

	 Map<String, Object> someMap = null;
	
		public void setSomeMap(Map<String, Object> someMap) {
		this.someMap = someMap;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("di/mapList");

		mav.addObject("someMap",someMap);
		return mav;
	}

}
