package com.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.MemberVO;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	
	public MemberDao() {
		//객체주입
		sqlSessionFactory= 
		MyBatisCommonFactory.getSqlSessionFactory(); //공통코드 static이라서 인스턴스화 없이 메소드 호출 가능.
	}
	public String currentTime() {
		/*
		 * DML 호출 뿐 아니라 커밋과 롤백도 처리할 수 있음.
		 * 
		 * select할 때
		 * sqlSession.selectList()==>List로 반환
		 * sqlSession.selectOne() ==>여기서 One은 Object임
		 * sqlSession.selectMap() ==>Map으로 반환
		 * 
		 * insert할 때 -> 리턴 타입은 Object임.
		 * sqlSession.insert("아이디",파라미터);
		 * 
		 * update할 때 -> 리턴 타입은 int임.
		 * sqlSession.update("아이디",파라미터);
		 * 
		 * delete할 때 -> 리턴 타입은 int임.
		 * sqlSession.delete("아이디", 파라미터);
		 * 
		 * 과제
		 * MemberDao를 단위 테스트 할 수 있는 클래스를 선언하고
		 * currentTime 메소드를 호출하여 현재 시간 정보 (오라클 서버가 제공)를
		 * 출력하는 문장을 작성해 보시오.
		 * 
		 */
		String time = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			time = sqlSession.selectOne("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;	
		
	}
	/*
	 * 입력 수정 삭제 시 주의사항
	 * 자바에서 jdbc api를 활용할 때는 con.setAutocommit(true)가 디폴트임 
	 * 따라서 별도로 끄지 않으면 커밋이 되었으나
	 * mybatis에서는 false가 디폴트 이므로 반드시 커밋 처리 할 것
	 * 관찰하기
	 * 요청 파라미터의 이름과 메소드 이름 그리고 myBatis 의 아이디는 무조건 통일하여 사용할 것
	 */
	public int memberInsert(Map<String, Object> pMap) {

		logger.info("DAO memberInsert 호출 성공");
		/*
		 * logger.info("pMap.get(mem_id)"+pMap.get("mem_id"));
		 * logger.info("pMap.get(mem_name)"+pMap.get("mem_name"));
		 * logger.info("pMap.get(mem_addr)"+pMap.get("mem_addr"));
		 * logger.info("pMap.get(mem_zipcode)"+pMap.get("mem_zipcode"));
		 * logger.info("pMap.get(mem_pw)"+pMap.get("mem_pw"));
		 */
		int result = 0;
		try {
			SqlSession sqlSession 
				= sqlSessionFactory.openSession();
			result = sqlSession.update("memberInsert",pMap);
			sqlSession.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	public int memberDelete(Map<String, Object> pMap) {
		int result = 0;
		logger.info("DAO memberDelete 호출 성공");
		try {
			SqlSession sqlSession 
				= sqlSessionFactory.openSession();
			result = sqlSession.delete("memberDelete",pMap);
			sqlSession.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}
	public List<Map<String, Object>> memberList() {
		/*
		 * 웹페이지는 exception이 발생하면 화면을 확인할 수가 없다.
		 * 따라서 에러 상황을 파악하는데 화면이 필요할 때는 초기화를 반드시 해줌
		 */
		//List<Map<String, Object>> memList = null;
		List<Map<String, Object>> memList = new ArrayList<>();
		try {
			SqlSession sqlSession 
				= sqlSessionFactory.openSession();
			memList = sqlSession.selectList("memberList");
			sqlSession.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memList;		
	}
	public String isId(MemberVO pmVO) {
		String mem_name = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			mem_name = sqlSession.selectOne("isId",pmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem_name;
	}

	public String login(MemberVO pmVO){
		String mem_name = null;
		logger.info(pmVO.getMem_id());
		logger.info(pmVO.getMem_pw());
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			mem_name = sqlSession.selectOne("login",pmVO);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem_name;		
	}
	
	public MemberVO proc_login(MemberVO pmVO) {
		/*
		 * 저장 프로시저의 특이사항은 파라미터로 넘긴 주소번지의 OUT 속성의 값이 담긴다는 사실이다.
		 */
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectOne("proc_login",pmVO);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pmVO;			
	}

}
