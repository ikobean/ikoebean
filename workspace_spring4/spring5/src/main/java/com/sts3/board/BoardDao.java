package com.sts3.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.BoardMasterVO;

@Service
public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	@Autowired
	private SqlSessionTemplate SqlSessionTemplate = null;
	
	
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공"+SqlSessionTemplate);
		List<Map<String,Object>> boardList=null;
		boardList=SqlSessionTemplate.selectList("boardList",pMap);
		return boardList;
	}

	public int boardAdd(Map<String, Object> pMap) {
		int result=0;
		logger.info("boardAdd 호출 성공"+SqlSessionTemplate);
		result=SqlSessionTemplate.update("boardMAdd",pMap);
		return result;
	}
	public int boardSAdd(Map<String, Object> pMap) {
		logger.info("boardSAdd 호출 성공");
		int result=0;
		try {
			result = SqlSessionTemplate.update("boardSAdd", pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}

	public int getBmno() {
		int bm_no=0;
		bm_no=SqlSessionTemplate.selectOne("getBmno");
		return bm_no;
	}
	public int getBmgroup() {
		logger.info("getBmgroup 호출 성공");
		int bm_group=0;
		bm_group = SqlSessionTemplate.selectOne("getBmgroup");
		return bm_group;
	}
	public int bmStepUpdate(Map<String, Object> pMap) {
		int result=0;
		result = SqlSessionTemplate.update("bmStepUpdate",pMap);
		return result;
		
	}

	public int getTotal(BoardMasterVO bmVO) {
		logger.info("getTotal 호출 성공");
		int total=0;
		try {
			total = SqlSessionTemplate.selectOne("getTotal",bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public int boardSDel(Map<String, Object> pMap) {
		logger.info("boardSDel 호출 성공");
		int result=0;
		try {
			result = SqlSessionTemplate.delete("boardSDel",pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}
	public int boardMDel(Map<String, Object> pMap) {
		logger.info("boardMDel 호출 성공");
		int result=0;
		try {
			result = SqlSessionTemplate.delete("boardMDel",pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}

	public int boardUpd(BoardMasterVO bmVO) {
		int result=0;
		logger.info("boardUpd 호출 성공"+SqlSessionTemplate);
		result=SqlSessionTemplate.update("boardMAdd",bmVO);
		return result;
	}
	
	public int hitCount(int bm_no) {
		logger.info("hitCount 호출 성공");
		int result=0;
		try {
			bm_no = SqlSessionTemplate.update("hitCount",bm_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delAll(String msg) {
		int result=0;
		//String msg="";
		try {
			result=SqlSessionTemplate.selectOne("delAll", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void boardSDELALL(String[] emnoArr) {
		logger.info("boardSDELALL 호출 성공");
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<emnoArr.length;i++) {
			list.add(Integer.parseInt(emnoArr[i]));
		}
		SqlSessionTemplate.delete("boardSDELALL",list);
	}

	public void boardMDELALL(String[] emnoArr) {
		logger.info("boardMDELALL 호출 성공");
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<emnoArr.length;i++) {
			list.add(Integer.parseInt(emnoArr[i]));
		}
		SqlSessionTemplate.delete("boardMDELALL",list);
	}
		
}