package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vo.MemberVO;

public class Member2Controller implements Controller {
	Logger logger = Logger.getLogger(Member2Controller.class);
	String requestName = null;
	String crud		   = null;
	String path 	   = null;
	MemberLogic memLogic = null;
	
	public Member2Controller(String requestName, String crud) {
		this.requestName = requestName;
		this.crud		 = crud;
		memLogic		 = new MemberLogic();
	}
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공");
		if("login".equals(crud)) {
			MemberVO pmVO = new MemberVO();
			pmVO.setMem_id(req.getParameter("mem_id"));
			pmVO.setMem_pw(req.getParameter("mem_pw"));
			MemberVO rmVO = memLogic.proc_login(pmVO);
			HttpSession session = req.getSession();
			session.setAttribute("rmVO", rmVO);
			logger.info("이름 :" +rmVO.getMem_name());
			path = "redirect:/onlineTestVer2/loginAccount.jsp";
		}
		else if("index".equals(crud)) {
			path = "redirect:/onlineTestVer2/index.jsp";
		}
		return path;
	}

}
