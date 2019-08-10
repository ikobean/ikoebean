package com.mvc2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class ActionServlet extends HttpServlet{
	Logger logger = Logger.getLogger(ActionServlet.class);
	public void doService(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException,IOException{
			
			//=> dev_jsp/onlineTest/test.nb?crud=select
			//=> /onlineTest/test.nb?crud=select
			String requestURI = req.getRequestURI();
			String contextPath = req.getContextPath(); // => /dev_jsp or /
			// 아래 코드에서 경로 앞에 /가 빠짐
			//	onlineTest/test.nb?crud=select
			String command = requestURI.substring(contextPath.length()+1);
			Controller controller = null;
			//crud=>select
			String crud = req.getParameter("crud");
			logger.info("requestURI:" +requestURI);
			logger.info("contextPath: "+contextPath);
			logger.info("command: "+command);
			logger.info("crud:" +crud);
			/*
			 * controller의 type은 Controller interface이지만
			 * ControllerMapping의 get Controller 메소드가 호출되면
			 * Controller의 구현체 클래스가 객체 생성되므로 controller는 더이상 null이 아니다.
			 * 그 구현체 클래스가 어떤 타입인지는 ControllerMapping클래스에서 확인하면 된다.
			 * 인터페이스의 execute는 추상메소드 이지만 구현체 클래스를 통해서 execute는 더이상
			 * 추상메소드가 아니다.
			 * 
			 * 컨트롤 버튼을 눌러 execute메소드를 따라가보자.
			 * onlineTest이면 Test2Controller의 execute 메소드가 호출될 것이고
			 * member 이면 Member2Controller의 execute 메소드가 호출될 것이다
			 * 이렇게 설계하면 
			 * 서블릿은 ActionServlet 하나만 생성되므로 
			 * 버전1에서처럼 업무 처리 클래스가 모두 서블릿이 될 필요가 없으므로
			 * 톰캣 서버 입장에서는 단일 서블릿을 관리하면 되고 나머지 클래스는 JVM을 통해서 
			 * 객체의 라이프 사이클 관리가 이루어 지니까 동시 접속자 수가 많은 서비스의 경우에도 안전하게
			 * 서버를 운영할 수 있다.
			 * 
			 * 버전 1의 경우 업무마다 서블릿이 생성되게 되어서 서버의 부담을 가중시키게 되므로
			 * 실제 운영서버에는 사용불가한 설계임.
			 */
			try {
				//==>onlineTest/test.nb?crud=select
				controller = ControllerMapping.getController(command, crud);
			} catch (Exception e) {
				// TODO: handle exception
			}
			//============= [여기는 응답페이지] ===============
			if(controller!=null) {
				//return "redirect:xxx.jsp";
				String pageMove[] = null; //return "forward:xxx.jsp"
				try {
					String ret = controller.execute(req, res);
					logger.info("ret ==="+ret);
					pageMove = ret.split(":");
					logger.info("pageMove ==="+pageMove[0]);
					//pageMove[0]= redirect or forward
					//pageMove[1]= 실제 요청 이름
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(pageMove!=null) {
					String path = pageMove[1];
					if("redirect".equals(pageMove[0])) {//sendRedirect일 때
						res.sendRedirect(path);
						
					}else {//forward일 때
						if("forward".equals(pageMove[0])) {
							RequestDispatcher view = 
								req.getRequestDispatcher(path);
							view.forward(req, res);
						}else {
							res.sendRedirect("/error/pageMoveFail.jsp");
						}
					}
				}
				else if(pageMove==null) {
					logger.info(pageMove[0]+pageMove[1]);
				}
			}
		}
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException,IOException{
				doService(req,res);
	}
		
		public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException,IOException{
				doService(req,res);
	}	
}
