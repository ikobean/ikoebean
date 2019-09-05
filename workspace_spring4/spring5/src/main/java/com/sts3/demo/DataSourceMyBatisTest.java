package com.sts3.demo;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceMyBatisTest {
	Logger logger = Logger.getLogger(DataSourceTest.class);
	@Autowired
	public DataSource dataSource=null;
	@Autowired
	public SqlSessionFactory sqlSessionFactory = null;
	@Test
	public void testMyBatis() {
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Connection con = dataSource.getConnection();
			logger.info("콘콘콘콘콘콘콘콘콘콘콘콘콘콘콘콘콘콘 ====> "+con);
			logger.info("에스큐엘세션에스큐엘세션에스큐엘세션 ====> "+sqlSession);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}

