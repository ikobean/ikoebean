package com.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/*
 * Dao 에서 오라클 서버와 연계시 MyBatis를 사용할 것임.
 * MyBatis에서 제공하는 mybatis.jar를 배포한 후
 * SqlSessionFactory 와 SqlSession 두 개의 클래스 객체 주입이 필요함.
 * 업무별로 Dao 클래스가 여러개 생성되므로 공통으로 사용할 수 있는 클래스를 설계하였음.
 * 그러나 SqlSession의 경우 업무별 요청하는 DML구문이 다르므로 여기에 포함하지 않음.
 * 
 * !주의!
 * getter메소드를 통하여 객체를 주입하게 되는데 
 * 이 때 반드시 초기화 메소드를 먼저 호출해야 한다.
 * 왜냐하면 그 안에 서버에 관련된 드라이버 클래스와 서버 정보 및 계정 정보가 있기 때문.
 */
public class MyBatisCommonFactory {
	private static SqlSessionFactory sqlSessionFactory = null;
	
	public static void init() {
		try {
			String resource = "com/mybatis/MapperConfig.xml"; 
			Reader reader = Resources.getResourceAsReader(resource);
			if(sqlSessionFactory==null) {
				sqlSessionFactory = 
						new SqlSessionFactoryBuilder().build(reader,"development");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		//SqlSessionFactory 객체를 생성해야 SqlSession 객체를 생성할 수 있음.
		//SqlSessionFactory 객체를 생성하기 위해서는 DB커넥션 정보를 읽어야 함.
		//따라서 초기화에 필요한 메소드를 추가할 것.
		init();
		return sqlSessionFactory;
	}
	
}
