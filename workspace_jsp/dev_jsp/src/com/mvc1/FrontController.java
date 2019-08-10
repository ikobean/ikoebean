package com.mvc1;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	MemberController memCtrl 	= new MemberController();
	GoodsController	 goodCtrl	= new GoodsController();
	OrderController  orderCtrl	= new OrderController();
	TestController 	 testCtrl  	= new TestController();

	public void doService(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException,IOException{
			logger.info("doService 호출 성공"+"word=member,order,goods");
			/*
			 * 요청하는 이름에 따라 구체적인 업무를 구분하고 싶다면 호출하는 이름을 별도로 처리해야 한다.
			 * 어떡하면 될까?
			 */ 
	
			 String uri = req.getRequestURI(); //   	/member/memberList.kos ★중요 코드
			 String context = req.getContextPath();//   /
			 String command = uri.substring(context.length()+1);
			 logger.info(uri); //uri=>/member/login.kos
			 //command ==> member/memberInsert.kos
			 int end =command.lastIndexOf('.'); //19
			 logger.info(command+" , "+end);//command = member/memberInsert		
			 command = command.substring(0,end); //command  onlineTest/subjectLIst	
			 
			 /* 요청하는 이름.kos 로 되게 해라~
			 * 테스트 할 때 어떤 이름이든 상관없이 ?work=member를 넘겨주면 됨
			 * work 정보는 사용자가 요청시 결정해서 넘겨주고
			 * crud의 경우는 같은 회원관리 업무 중에서도 입력인지 수정건인지 삭제 건인지 
			 * 조회 건인지 식별할 수 있어야 함.
			 */
//			StringBuffer url = req.getRequestURL();
//			String url2 = url.toString();
//			if(url2.contains("shdrn")) {
//			}
//			else if(url2.contains("qoemalsxjs")) {
//				
//			}
			String work = req.getParameter("work"); //work에 member담김-회원관리 //mgr클래스에  name work 변수의 값을  내놔라!
			ActionForward forward = null;
			if("member".equals(work)) { //work에 member 들어있음
				//work정보 쿼리스트링으로 처리하고
				//상세업무 정보는 request 객체 담기
				req.setAttribute("crud", command);//crud속성에 select를 담아라 //member/memberInsert
				//req.setAttribute("command", command);
				forward = memCtrl.execute(req, res);//보냈어 
				//req.setAttribute("crud", "insert");
				//req.setAttribute("crud", "update");
				//req.setAttribute("crud", "delete");
			}
			else if("goods".equals(work)) {
				forward = goodCtrl.execute(req, res);
			}
			else if("order".equals(work)) {
				forward = orderCtrl.execute(req, res);
				
			}else if("onlineTest".equals(work))	{
				/*
				 * FrontController가 실제 업무를 처리하는 클래스가 아니다.
				 * 요청건에 따라 해당 업무를 처리하는 클래스(MemberController,TestController)를 배정
				 * 이 때 필요한 정보가 work에 담겨 있는 정보 임.
				 * TestController의 execute 메소드가 호출되야함.
				 * TestController의 메소드는 하나뿐임.
				 * 처리해야 하는 업무는 4가지이다.
				 * 분기를 해야함.
				 * 기준되는 값이 crud의 담긴 값			
				 */		
				req.setAttribute("crud", command);
				forward = testCtrl.execute(req, res);
			}
			if(forward!=null) {
				if(forward.isRedirect()) {//새창열기 이전의 리퀘스트가 없어짐.
					res.sendRedirect(forward.getviewName());
				}else {
					RequestDispatcher view = req.getRequestDispatcher(forward.getviewName());
					view.forward(req, res);

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
