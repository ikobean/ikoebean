package com.mvc2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.ZipCodeVO;

public class ZipCodeDao {
	Logger logger = Logger.getLogger(ZipCodeDao.class);
	/*****************************************************************
	 * 
	 * @param dong 사용자로부터 동 정보는 입력받아서 처리함.
	 * @return 조회 결과가 n건인 경우도 있을 수 있으니까... List<ZipCodeVO>로 함.
	 *****************************************************************/
	
	/*우편번호 조회 업무는 회원관리 업무영역에서만 사용된다고 한다.
	  따라서 MemberController로 연결하면 됨.
	 URL 가지고 업무영역과 상세업무 이름을 가져와서 분기하므로
	 member/zipcodeList.kos?work=member와 같이 요청하면
	 member/zipcodeList.kos?work=member&dong=가산동
	 
	 기존 클래스를 그대로 재사용 가능함.
	*/
	SqlSessionFactory sqlSessionFactory = null;
	
	public ZipCodeDao() {
		sqlSessionFactory= 
				MyBatisCommonFactory.getSqlSessionFactory(); 
	}
	
	public  List<ZipCodeVO> zipcodeList(ZipCodeVO zVO) {
		//테스트시 Exception 발생하면 화면을 볼 수 없으므로 초기화 진행함.
		List<ZipCodeVO> zipList = null;
		try {
			SqlSession sqlSession
				= sqlSessionFactory.openSession();
			zipList = sqlSession.selectList("zipcodeList",zVO); //xml의 id 가져와야함!
			sqlSession.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return zipList;
	}
}
