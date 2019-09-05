package com.sts3.sample;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
@Autowired
public SqlSessionTemplate sqlSessionTemplate = null;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<Map<String, Object>> memList(Map<String, Object> pMap) {
		logger.info("memberList 호출 성공");
		
		List<Map<String, Object>> memList=null;
		memList=sqlSessionTemplate.selectList("memList", pMap);
		
		return memList;
	}

}
