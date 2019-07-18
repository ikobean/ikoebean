package com.basic;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
/*
 * 웹서비스를 제공하기 위해서는 서블릿이 되어야 함.
 * 왜냐하면 통신을 지원(누가:톰캣[WAS : Web Application Server])받아야하고
 * 서블릿이 생성될 때 마다 스레드 지원이 필요함.
 * 한 사람이 서버에 접속하여 여러 페이지를 이동하고 때로는 결재를 때로는 동영상을 시청하는 것을 관리해야 함.
 * 작업에 대한 순서, 경합 상황이 계속 발생하게 됨.
 * 이렇게 생성된 서블릿 객체는 싱글톤으로 관리됨.
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class HelloServlet extends HttpServlet {
	
	//Get방식으로 요청이 들어올 때
	/****************************************************************
	 * @return : void
	 * 질문 : 리턴타입이 void인데 처리결과를 어떻게 html 문서에서 받을 수 있는걸까?
	 * @param1 : request 요청객체 - 사용자 화면에 입력한 아이디를 받아올 때
	 * @param2 : response 응답객체 - mime type, charset 지정
	 * 자바는 요청객체와 응답객체 없다.
	 * 오라클 연동은 자바로 함.
	 * 파라미터 객체 주입은 톰캣이 함.
	 * doGet메소드는 시스템에서 자동 호출(콜백메소드)
	 * 사용자 호출에는 브라우저 url주소 필요
	 * 이 주소는 배치 서술자에 등록되어야 함.
	 * 배치서술자는 db(deploy discript) web.xml입니다.
	 * web.xml 문서에 서블릿 클래스 이름을 등록하고 대응하는 url 주소를 미리 정합니다.
	 * http://localhost:8000/hello.do
	 * hello.do 이름으로 HelloServlet 클래스를 찾아야 합니다.
	 * 그 방법은?
	 * 질문2:파라미터 객체는 누가제공하나요?
	****************************************************************/
	Logger logger = Logger.getLogger(HelloServlet.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	
	throws ServletException,IOException{
		/*
		 * JSP 에서는 내장 객체로 지원되지만 서블릿ㅅ에서는 내장객체 지원 없으므로 다음과 같이
		 * 생성한 후 사용함
		 */
		
		HttpSession session = req.getSession();
		//세션에 값을 담기
		session.setAttribute("name", "내복이");
		//세션에 있는 값 꺼내기
		//getAttribute 메소드는 세션객체가 지원하는 메소드로 
		//리턴타입은 Object
		//따라서 List 같은 자료구조도 담을 수 있음.
		//그러나 cache 메모리 공간에 한계로 조회 결과를 담는데 사용하지 않음.
		//일반적으로 이런 경우는 request를 사용함.
		String s_name = (String)session.getAttribute("name");
		//System.out.println("doGet호출");
		//logger.info("doGet");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//hello.do?command=insert
		String command = req.getParameter("command");
		
		if("insert".equals(command)) {//입력이니?
			logger.info("입력선택하였음");			
		}
		else if("update".equals(command)) {//수정이니?
			logger.info("수정선택하였음");
		}
		else if("delete".equals(command)) {//삭제이니?
			logger.info("삭제선택하였음");
		}
		else if("select".equals(command)) {//조회이니?
			logger.info("조회선택하였음");
		}
		}
	//Post방식으로 요청이 들어올 때
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
				System.out.println("doPost");
			}
}