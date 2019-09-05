package com.sts3.sample;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**************************************************************
 * 달라진 점들..
 * 1)MultiActionController를 상속받지 않았다.
 * 2)메소드의 파라미터 자리가 비어있어도 잘 처리된다.
 * 3)ModelAndView없이도 WEB-INF 아래에 페이지를 배포가능함.
 **************************************************************/
@Controller
public class MemberController {

	Logger logger = Logger.getLogger(MemberController.class);
	
	//객체주입 어노테이션
	@Autowired
	public MemberLogic memLogic  = null;
	
	//회원 등록 구현
	@RequestMapping(value="/member/memberAdd.do")
	//bind 메소드 사용할 필요 없이 파라미터에 어노테이션 써주면 알아서 다 담김. 개꿀!!
	
	public String memberAdd(@RequestParam Map<String,Object> pMap) {
		logger.info("Controller memberAdd 호출 성공");
		logger.info("pMap.get(mem_id)=====>"+pMap.get("mem_id"));
		logger.info("pMap.get(mem_pw)=====>"+pMap.get("mem_pw"));
		memLogic.memberAdd(pMap);
		return "member/memberAddOk"; //어느 경로를 바라보는거지?
	}
	//회원 리스트 
	@RequestMapping(value="/member/memberList.do")
	public String memberList(@RequestParam Map<String,Object> pMap){
		logger.info("멤버 리스트 호출 성공");
		List<Map<String,Object>> memList=null;
		memList=memLogic.memberList(pMap);
		logger.info("memList.size()==========>"+memList.size());
		return "member/memberList";
		
	}
}
