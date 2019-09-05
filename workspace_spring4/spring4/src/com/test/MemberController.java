package com.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController {

	Logger logger = Logger.getLogger(MemberController.class);
	//sevlet.xml에 설정한 property name과 동일해야 함.
	//	<property name="memberLogic" ref="member-logic"/>
	public MemberLogic memberLogic = null;

	public void setMemberLogic(MemberLogic memberLogic) {
		this.memberLogic = memberLogic;
	}

	public ModelAndView memberList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("memberList 호출 성공");
		ModelAndView mav = new ModelAndView();
		List<Map<String,Object>> memList=null;
		memList = memberLogic.MemberList();
		mav.addObject("memberList",memList);
		mav.setViewName("member/memberList");
		return mav;
	}
	public void memberList2(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("POJO 방식memberList2 호출 성공");
		List<Map<String,Object>> memList=null;
		memList = memberLogic.MemberList();
		req.setAttribute("memberList", memList);
		RequestDispatcher view 
							= req.getRequestDispatcher("./memberList.jsp");
		view.forward(req, res);
	}
	public void memberList3(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("memberList3 호출 성공");
		List<Map<String,Object>> memList=null;
		memList = memberLogic.MemberList();
		req.setAttribute("memberList", memList);
		try {
			res.sendRedirect("./memberList.jsp");//유지 안됨. WebContent로 감!
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void memberAdd(HttpServletRequest req, HttpServletResponse res) {
		logger.info("memberAdd 호출 성공");	
		
		
	}
	
	public void memberUpd(HttpServletRequest req, HttpServletResponse res) {
		logger.info("memberUpd 호출 성공");	
	}
	
	public void memberDel(HttpServletRequest req, HttpServletResponse res) {
		logger.info("memberDel 호출 성공");	
	}
}
