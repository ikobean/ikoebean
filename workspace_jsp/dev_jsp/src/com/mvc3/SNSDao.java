package com.mvc3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.MemberVO;
import com.vo.SNSMessageSet;
import com.vo.SNSMessageVO;
import com.vo.SNSRepleVO;

public class SNSDao {
	Logger logger = Logger.getLogger(SNSDao.class);
	//MyBatis연결시 커넥션을 맺는데 필요한 정보를 읽기
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	public SNSDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public List<SNSMessageSet> smsgList() {
		//상태글에 대한 댓글 묶음 처리
		List<SNSMessageSet> smsgList = new ArrayList<>();
		//상태글 정보를 담기
		List<SNSMessageVO> msgList = new ArrayList<>();
		try {
			sqlSession = sqlSessionFactory.openSession();
			msgList = sqlSession.selectList("msgList");
			if(msgList.size()>0) {
				for(int i=0;i<msgList.size();i++) {
					SNSMessageSet smSet = new SNSMessageSet();
					SNSMessageVO smVO = msgList.get(i);
					int mno = smVO.getMno();
					List<SNSRepleVO> reList = getReple(mno);
					smSet.setMsgVO(smVO);
					smSet.setReList(reList);
					smsgList.add(smSet);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return smsgList;
	}
	private List<SNSRepleVO> getReple(int mno) {
		List<SNSRepleVO> repleList = new ArrayList<>();
		try {
			sqlSession = sqlSessionFactory.openSession();
			repleList = sqlSession.selectList("getReple",mno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession !=null) sqlSession.close();
		}
		return repleList;
	}
	public int write(SNSMessageVO smVO) {
		logger.info("SNSDao-write 호출 성공");
		int result=0;
		try {
			 sqlSession 
				= sqlSessionFactory.openSession();
			result = sqlSession.update("write", smVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession !=null) sqlSession.close();
		}
		return result;
	}
	public int insRep(SNSRepleVO srVO) {
		logger.info("SNSDao-insRep 호출 성공");
		int result=0;
		try {
			 sqlSession 
				= sqlSessionFactory.openSession();
			result = sqlSession.update("insRep", srVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession !=null) sqlSession.close();
		}
		return result;
	}
	public int getMno() {
		logger.info("getMno 호출 성공");
		int mno=0;
		try {
			 sqlSession = sqlSessionFactory.openSession();
									   //xml에 있는 아이디랑 맞춰주기
			 mno = sqlSession.selectOne("getMno");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return mno;
	}
	public int getFavcnt(int mno) {
		logger.info("getFavcnt 호출 성공");
		int result=0;
		try {
			 sqlSession = sqlSessionFactory.openSession();
									   //xml에 있는 아이디랑 맞춰주기
			 result = sqlSession.update("getFavcnt",mno);
			 sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return result;
	}
	public int snsDel(SNSMessageVO smVO) {
		logger.info("snsDel 호출 성공");
		int result=0;
		try {
			 sqlSession 
				= sqlSessionFactory.openSession();
			result = sqlSession.delete("snsDel", smVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		logger.info("snsDel 삭제 결과 :"+result);
		return result;
	}
	public int snsUpd(SNSMessageVO smVO) {
		logger.info("SNSDao-snsUpd 호출 성공");
		int result=0;
		try {
			 sqlSession 
				= sqlSessionFactory.openSession();
			result = sqlSession.update("snsUpd", smVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession !=null) sqlSession.close();
		}
		return result;
	}
	

	public int getUMno() {
		logger.info("getUMno 호출 성공");
		int umno=0;
		try {
			 sqlSession = sqlSessionFactory.openSession();
									   //xml에 있는 아이디랑 맞춰주기
			 umno = sqlSession.selectOne("getUMno");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return umno;
	}
	public int getRno() {
		logger.info("getMno 호출 성공");
		int rno=0;
		try {
			 sqlSession = sqlSessionFactory.openSession();
									   //xml에 있는 아이디랑 맞춰주기
			 rno = sqlSession.selectOne("getRno");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return rno;
	}
	public int signIn(MemberVO mVO) {
		logger.info("SNSDao-write 호출 성공");
		int result=0;
		try {
			 sqlSession 
				= sqlSessionFactory.openSession();
			result = sqlSession.update("signIn", mVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession !=null) sqlSession.close();
		}
		return result;
	}
	public MemberVO proc_login(MemberVO pmVO) {
		/*
		 * 저장 프로시저의 특이사항은 파라미터로 넘긴 주소번지의 OUT 속성의 값이 담긴다는 사실이다.
		 */
		logger.info("dao proc_login 호출");
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectOne("proc_login",pmVO);
			//logger.info("이름:"+pmVO.getMem_name());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pmVO;	
		
	}
	public MemberVO proc_signin(MemberVO pmVO) {
		/*
		 * 저장 프로시저의 특이사항은 파라미터로 넘긴 주소번지의 OUT 속성의 값이 담긴다는 사실이다.
		 */
		logger.info("dao proc_signin 호출");
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectOne("proc_signin",pmVO);
			//logger.info("이름:"+pmVO.getMem_name());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pmVO;	
		
	}
	public MemberVO isID(MemberVO pmVO) {
		
		logger.info("dao isID 호출");
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectOne("isID",pmVO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pmVO;	
		
	}
}













