package com.login;

import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class LoginDao {
	Logger logger = Logger.getLogger(LoginDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}



	public String login(Map<String, Object> pMap) {
		String mem_name = sqlSessionTemplate.selectOne("login",pMap);
		return mem_name;
	}
}
