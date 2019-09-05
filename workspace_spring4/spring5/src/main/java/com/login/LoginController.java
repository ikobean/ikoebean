package com.login;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//이건 왜 어노테이션 씀?? 아까 쓰지 말자고 했던 거 아닌감??==>넘어가자
@Controller
@RequestMapping("/security/*")
public class LoginController {
	Logger logger = Logger.getLogger(LoginController.class);
	
	public LoginLogic loginLogic = null;
	public void setLoginLogic(LoginLogic loginLogic) {
		this.loginLogic = loginLogic;
	}
	
	@PostMapping("login")
	public String Login(@RequestParam Map<String,Object> pMap
						,HttpSession session) {
		logger.info(pMap.get("mem_id"));
		String mem_name=loginLogic.login(pMap);
		session.setAttribute("smem_name",mem_name);
		logger.info("컨트롤러 호출성공");
		return "redirect:/index5.jsp";
	}
	
}