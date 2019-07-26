package com.mvc1;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.vo.MemberVO;
import com.vo.ZipCodeVO;

public class MemberController extends HttpServlet implements Action {
	Logger logger = Logger.getLogger(MemberController.class);
	MemberLogic memLogic = new MemberLogic();
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String viewName = null;
		boolean isRedirect = false;
		String crud =(String) req.getAttribute("crud");
		System.out.println(crud); //select
		
		if("member/zipcodeList".equals(crud)) {
			logger.info("우편번호 조회 호출 성공");
			List<ZipCodeVO> zipList = null;
			ZipCodeDao zDao = new ZipCodeDao();
			ZipCodeVO zVO = new ZipCodeVO();
			zVO.setDong(req.getParameter("dong"));
			zipList = memLogic.zipcodeList(zVO);
			req.setAttribute("zipList", zipList);
			viewName = "jsonZipcodeList.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setviewName(viewName);
			
		}
		else if("member/memberList".equals(crud)) {
			logger.info("회원 목록 조회 호출 성공");
			List<Map<String,Object>> memList = null;
			memList = memLogic.memberList();
			req.setAttribute("memList", memList);
			viewName = "jsonMemberList.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setviewName(viewName);
		}		 
		else if("member/memberInsert".equals(crud)) {
			logger.info("회원 가입 호출 성공");
			int result=0;
			Map<String,Object> pMap = new HashMap<>();
			//req.getpParameter 대신 해주는 클래스
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			result = memLogic.memberInsert(pMap);
			viewName = "memberMgr.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setviewName(viewName);
			
		}
		else if("update".equals(crud)) {
			
		}
		else if("member/memberDelete".equals(crud)) {
			logger.info("회원 삭제 호출 성공");
			int result=0;
			Map<String,Object> pMap = new HashMap<>();
			//req.getpParameter 대신 해주는 클래스
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			result = memLogic.memberDelete(pMap);
			viewName = "memberMgr.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setviewName(viewName);
			
		}
		else if("member/login".equals(crud)) {
			logger.info("mem_name");
			String mem_name= null;
			MemberVO pmVO = new MemberVO();
			//사용자가 입력한 아이디 받기
			pmVO.setMem_id(req.getParameter("mem_id"));
			//사용자가 입력한 비번 받기
			pmVO.setMem_pw(req.getParameter("mem_pw"));
			//req.getpParameter 대신 해주는 클래스
			//프로시저 사용 안할 때
			//mem_name = memLogic.login(pmVO);
			
			//프로시저 사용할 때
			MemberVO rmVO = null;
			rmVO = memLogic.proc_login(pmVO);
			//사용자 정보 세션에 담기
			HttpSession session = req.getSession();
			//프로시저 사용 안 할 떄
			//session.setAttribute("mem_name", mem_name);
			//프로시저 사용시 리턴 타입을 vo로 함.
			session.setAttribute("rmVO", rmVO);
			//로그인 성공시 보여줄 화면 선언
			viewName = "/onlineTest/loginAccount.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setviewName(viewName);
		}
		
		return forward;
	}
	@Override
	public List<Map<String, Object>> test(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res, String crud)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
