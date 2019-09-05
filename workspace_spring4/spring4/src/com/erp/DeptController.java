package com.erp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class DeptController extends MultiActionController {
	Logger logger = Logger.getLogger(DeptController.class);
	

	public DeptLogic deptLogic = null;
	
	public void setDeptLogic(DeptLogic deptLogic) {
		this.deptLogic = deptLogic;
	}
	
	public void deptIns(HttpServletRequest req, HttpServletResponse res) {
		logger.info("controller deptIns 호출 성공");	
		
		
	}
}
