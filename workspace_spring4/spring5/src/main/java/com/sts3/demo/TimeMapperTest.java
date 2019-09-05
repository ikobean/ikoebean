package com.sts3.demo;

import static org.junit.Assert.fail;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TimeMapperTest {
	Logger logger = Logger.getLogger(TimeMapperTest.class);
	@Autowired
	private TimeMapper timeMapper = null;	
	@Test
	public void timeGetTime() {
		logger.info("시간==============ㅋ===========>"+timeMapper.getTime());
		logger.info("시간==============ㅋ===========>"+timeMapper.getClass().getName());
	}
}

