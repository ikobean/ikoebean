package com.erp;

import org.apache.log4j.Logger;

public class DeptLogic {
	
public DeptDao deptDao=null;
Logger logger = Logger.getLogger(DeptLogic.class);

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	public int deptIns() {
		
		logger.info("deptIns");
		return 0;
	}
}
