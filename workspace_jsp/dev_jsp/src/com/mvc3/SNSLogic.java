package com.mvc3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.MemberVO;
import com.vo.SNSMessageSet;
import com.vo.SNSMessageVO;
import com.vo.SNSRepleVO;

public class SNSLogic {
	Logger logger = Logger.getLogger(SNSLogic.class);
	SNSDao snsDao = null;
	SNSMessageVO smVO = null;
	SNSRepleVO srVO =null;
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
		
		smVO = new SNSMessageVO();
		mno=snsDao.getMno();
		logger.info("mno=========>"+mno);
		
		smVO.setMno(mno);
		smVO.setMem_id(pMap.get("mem_id").toString());
		smVO.setMem_pw(pMap.get("mem_pw").toString());
		smVO.setMsg(pMap.get("msg").toString());
		
		result=snsDao.write(smVO);
		return result;
	}
	public int insRep(Map<String, Object> pMap) {
		logger.info("Logic insRep() 호출");
		int    rno      =0;// 
		int    umno      =0;// 
		int    mno      =0;// 
		String mem_id   ="";// 
		String msg      ="";// 
		String msg_date ="";// 
		String mem_pw  ="";
		int result=0;

		smVO = new SNSMessageVO();
		srVO = new SNSRepleVO();
		umno=snsDao.getUMno();
		rno=snsDao.getRno();
		logger.info("mno=========>"+mno);
		logger.info("umno=========>"+umno);
		logger.info("mem_id=========>"+pMap.get("mem_id"));
		logger.info("pMap.get(mno)=========>"+pMap.get("mno"));
		
		if(pMap.get("mno")!=null) {
			logger.info("umno==>"+umno+"mno==>"+mno+"pmap"+pMap.get("mno"));
			srVO.setRno(rno);
			srVO.setMno(Integer.parseInt(pMap.get("mno").toString()));
			srVO.setMem_id(pMap.get("mem_id").toString());
			srVO.setMem_pw(pMap.get("mem_pw").toString());
			srVO.setMsg(pMap.get("msg").toString());
			srVO.setMsg_date(msg_date);
			result=snsDao.insRep(srVO);
		}
		return result;
	}
	public int snsDel(Map<String, Object> pMap) {
		int result=0;
		int mno=0;
		String mem_pw="";
		logger.info("Logic sns_del() 호출");
		
		//db에 있는 mno 가져오기
		SNSMessageVO smVO = new SNSMessageVO();
		smVO.setMno(Integer.parseInt(pMap.get("mno").toString()));
		mno=smVO.getMno();
		
		smVO.setMem_pw(pMap.get("mem_pw").toString());
		mem_pw= smVO.getMem_pw();
		
		
		logger.info("mem_pw============"+mem_pw);
		logger.info("mno============"+mno);
		logger.info("pMap.getmno======="+pMap.get("mno"));
		
		if(pMap.get("mno")!=null && Integer.parseInt(pMap.get("mno").toString())==mno) {
			logger.info("pMap.getmno======="+pMap.get("mno"));
			logger.info("mno============"+mno);
			
			
			smVO.setMno(mno);
			smVO.setMem_pw(pMap.get("mem_pw").toString());
			result=snsDao.snsDel(smVO);
		}
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
			result=snsDao.snsUpd(smVO);
		}
		return result;
	}
	public int signIn(Map<String, Object> pMap) {
		logger.info("Logic signIn() 호출");
		
		int result=0;
		String mem_id="";
		String mem_pw="";
		String mem_email="";
		String mem_name="";
		
		MemberVO mVO = new MemberVO();
		
		mVO.setMem_id(pMap.get("mem_id").toString());
		mVO.setMem_email(pMap.get("mem_email").toString());
		mVO.setMem_name(pMap.get("mem_name").toString());
		mVO.setMem_pw(pMap.get("mem_pw").toString());
		
		result=snsDao.signIn(mVO);
		return result;
	}
	public MemberVO proc_signin(MemberVO pmVO) {
		logger.info("Logic signIn() 호출");
		MemberVO mVO = new MemberVO();
		mVO.setMem_id(snsDao.proc_signin(pmVO).toString());
		snsDao.proc_signin(pmVO);
		return pmVO;
	}
	
	public MemberVO login(MemberVO pmVO) {
		snsDao.proc_login(pmVO);
		
		return pmVO;
	}
}
