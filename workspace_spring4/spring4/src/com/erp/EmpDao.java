package com.erp;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

import com.vo.EmpVO;


public class EmpDao {

	Logger logger = Logger.getLogger(EmpDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void empIns(EmpVO eVO) throws DataAccessException {
		logger.info("empIns 호출 성공");
		eVO = new EmpVO();
		eVO.setEmpno(9572);
		eVO.setEname("황내복");
		eVO.setDeptno(10);
		sqlSessionTemplate.insert("empIns",eVO);
		
		
	}
}
