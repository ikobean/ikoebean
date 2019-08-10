package com.mvc2;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.vo.SwDesignVO;


public class Test2Controller implements Controller {
	Logger logger = Logger.getLogger(Test2Controller.class);
	String requestName = null;
	String crud		   = null;
	String path		   = null;
	TestLogic testLogic = null;
	
	public Test2Controller(String requestName, String crud) {
		
		this.requestName = requestName;
		this.crud		 = crud;
		testLogic = new TestLogic();
		
	}
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공");
		if("select".equals(crud)) {
			path = "forward:a.jsp";
		}
		else if("update".equals(crud)) {
			path = "redirect:b.jsp";
		} 
		else if("swDesignExam".equals(crud)) {
			logger.info("소프트웨어 설계 controller 호출 성공");
			Map<String,Object> pMap = new HashMap<>();
			List<Map<String,Object>> designList = testLogic.swDesignExam(pMap);
			List list =null;
			if(designList!=null) {
				list=(List)designList.get(0).get("key");
			}
			Iterator<Map<String,Object>> iter = list.iterator();
			while(iter.hasNext()) {
				SwDesignVO swDVO = (SwDesignVO)iter.next();
				logger.info(swDVO.getQuestion());
			}
			req.setAttribute("designList", list);
			path ="forward:jsonSwDesign.jsp";
		}
			
		else if("isOk".equals(crud)) {
			String msg = null;
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			msg=testLogic.isOk(pMap);
			req.setAttribute("msg", msg); 
			path = "forward:isOkResult.jsp";
		}
		else if("examReceipt".equals(crud)) {
			int result=0;
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			result = testLogic.examReceipt(pMap);
			if(result==1) {
				path = "forward:examReceiptSuccess.jsp";
				
			}else {
				path = "forward:examReceiptFail.jsp";
			}
		}
		/******************************************
		 * 수험과목 목록을 가져오기 구현
		 ******************************************/
		else if("subjectList".equals(crud)) {
			List<Map<String,Object>> subList= null;
			subList = testLogic.subjectList();
			//이 부분이 빠지게 되면 NullPointerException을 얻어맞을 수 있다.
			req.setAttribute("subList", subList);
			testLogic.subjectList();
			path="forward:jsonSubjectList.jsp";
		}
		else {
			path = "redirect:a.jsp";
		}
		return path; //이런 방법이 좋다!
		//forward:index.jsp";  주소창은 안바뀌지만 index.jsp로 이동
		//"redirect:index.jsp"; 주소창이 바뀌면서 index.jsp로 이동
		
	}

}