package com.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;


public class MemberDao {
	
	Logger logger = Logger.getLogger(MemberDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;

		public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
		
		public List<Map<String,Object>>  memberList() {
			//String result = sqlSessionTemplate.selectOne("curruntTime");
			List<Map<String,Object>> memList = null;
			memList =	sqlSessionTemplate.selectList("memberList");
			logger.info(memList);
			return memList;
		}

		
}
