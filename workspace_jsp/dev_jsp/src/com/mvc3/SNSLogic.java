package com.mvc3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.SNSMessageSet;
import com.vo.SNSMessageVO;

public class SNSLogic {
	Logger logger = Logger.getLogger(SNSLogic.class);
	SNSDao snsDao = null;
	SNSMessageVO smVO = null;
	
	public SNSLogic() {
		snsDao = new SNSDao();
	}
	public List<SNSMessageSet> smsgList() {
		logger.info("smsgList호출");
		SNSMessageVO smVO = new SNSMessageVO();
		List<SNSMessageSet> smsgList = null;
		smsgList = snsDao.smsgList();
		
		//좋아요 카운트하기
		if(smsgList.size()==1 && "favcnt".equals(smVO.getGubun())) {
			int favcnt = smVO.getFavcnt();
			snsDao.getFavcnt(favcnt);
		}
		logger.info("smsgList : "+smsgList);
		return smsgList;
	}
	public int write(Map<String, Object> pMap) {
		int result=0;
		int mno=0;
		int favcnt=0;
		logger.info("Logic Write() 호출");
		
		SNSMessageVO smVO = new SNSMessageVO();
		mno=snsDao.getMno();
		logger.info("mno=========>"+mno);
		
		smVO.setMno(mno);
		smVO.setMem_id(pMap.get("mem_id").toString());
		smVO.setMem_pw(pMap.get("mem_pw").toString());
		smVO.setMsg(pMap.get("msg").toString());
		
		result=snsDao.write(smVO);
		return result;
	}
	public int snsDel(Map<String, Object> pMap) {
		int result=0;
		int mno=0;
		logger.info("Logic sns_del() 호출");
		smVO = new SNSMessageVO();
		
		if(pMap.get("mno")!=null) {
			logger.info("mnojmfsdofsd======="+pMap.get("mno"));
			mno=Integer.parseInt(pMap.get("mno").toString());
			smVO.setMno(mno);
		}
		result=snsDao.snsDel(pMap);
		return result;
	}
	public int favcnt(SNSMessageVO smVO) {
		logger.info("Logic favcnt() 호출");
		
		int result=0;
		int mno=0;
		int favcnt=0;
		
		mno=smVO.getMno();
		favcnt=smVO.getFavcnt();
		
		snsDao.getFavcnt(mno);
	
		logger.info("logic mno==========>"+mno);
		//logger.info("logic pMap.getmno==========>"+pMap.get("mno"));
		
		
		return result;
	}
	public int snsUpd(Map<String, Object> pMap) {
		int result=0;
		int mno=0;
		logger.info("Logic Write() 호출");
		
		SNSMessageVO smVO = new SNSMessageVO();
		mno=snsDao.getMno();
		logger.info("mno=========>"+mno);
		
		if(pMap.get("mno").equals(mno)) {
			smVO.setMno(mno);
			smVO.setMem_id(pMap.get("mem_id").toString());
			smVO.setMem_pw(pMap.get("mem_pw").toString());
			smVO.setMsg(pMap.get("msg").toString());
		}
		result=snsDao.snsUpd(smVO);
		return result;
	}
}
