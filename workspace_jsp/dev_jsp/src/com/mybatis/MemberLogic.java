package com.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.ZipCodeVO;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao mDao = new MemberDao();
	ZipCodeDao zDao = new ZipCodeDao();
	
	public int memberInsert(Map<String, Object> pMap) {
		logger.info("memberInsert 호출 성공");
		int result = 0;
		result = mDao.memberInsert(pMap);
		return result;
	}
	public List<Map<String, Object>> memberList() {
		logger.info("memberList 호출 성공");
		List<Map<String, Object>> memList = null;
		memList = mDao.memberList();
		return memList;
	}
	
	public int memberDelete(Map<String, Object> pMap){
		logger.info("logic 회원 삭제 호출 ");
		int result = 0;
		result = mDao.memberDelete(pMap);
		return result;
	}
	public List<ZipCodeVO> zipcodeList(ZipCodeVO zVO) {
		logger.info("logic 우편번호 호출 ");
		List<ZipCodeVO> zipList = null;
		zipList = zDao.zipcodeList(zVO);
		return zipList;
	}

}
