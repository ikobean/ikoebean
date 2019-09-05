package com.erp;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.DeptVO;

public class DeptDao {

	Logger logger = Logger.getLogger(DeptDao.class);
	
	public SqlSessionTemplate sqlSessionTemplate = null;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


	public void deptUpd(DeptVO dVO) {
		logger.info("DeptDao 호출 성공");
		dVO = new DeptVO();
		dVO.setDeptno(10);
		dVO.setDname("JAVA52");
		dVO.setLoc("SEOUL");
		sqlSessionTemplate.update("deptUpd", dVO);
	}

}