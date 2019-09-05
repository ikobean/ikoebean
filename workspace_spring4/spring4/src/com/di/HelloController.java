package com.di;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {
	Logger logger = Logger.getLogger(HelloController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		logger.info("handleRequestInternal 호출 성공");
		/*
		 * ModelAndView는 scope는 request 임
		 * ModelAndView는 forward 처리임. (주소창 안바뀐다!)
		 * 꺼낼 때는 어떻게 꺼내지?
		 * 어디에 담기는 거지? request
		 * 꺼낼때는 ==> getAttribute()
		 */
		ModelAndView mav = new ModelAndView();
		//WEB-INF/view/로 들어가게 됨! 
		//==> page를 찾는 접두어 : WEB-INF/view/  
		//==> 접미어 : .jsp
		//완결편==> /WEB-INF/view/?.jsp
		mav.setViewName("di/helloResult");
		List<String> nameList = new ArrayList<>();
		nameList.add("내복이");
		
		//이게 request, forward하는 코드임!
		//==setAttribute
		mav.addObject("nameList", nameList);
		//arg0.getAttribute("nameList");
		/*
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com\\di\\listBean.xml");
		insaList insa =(insaList)context.getBean("insa");
		mav.addObject("ok", insa.ListBean);
		logger.info(insa.ListBean);
		*/
		return mav;
	}
}
