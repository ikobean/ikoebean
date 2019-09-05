package com.erp;


import org.apache.log4j.Logger;

import com.vo.EmpVO;

public class EmpLogic {
	Logger logger = Logger.getLogger(EmpLogic.class);
	//@Autowired
	public EmpDao empDao=null;
	public DeptDao deptDao=null;
	
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public void doEmp(EmpVO eVO) {
		logger.info("logic-empIns 호출성공 ");
		try {
			deptDao.deptUpd(null);
			empDao.empIns(null);
		} catch (Exception e) {
			throw e;
		}
		
	}
}
