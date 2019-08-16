package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//추상메소드 =>구현체 클래스를 통해 추상 메소드가 아니게 됨.
	public abstract String execute(HttpServletRequest req
					,HttpServletResponse res)
	throws Exception;
	//추상메소드라서 오버라이딩 해주지 않으면 오류나기 떄문에 주석으로 막아놓음
	/*
	 * public abstract ModelAndView execute(HttpServletRequest req
	 * ,HttpServletResponse res, String crud) throws Exception;
	 */
}
