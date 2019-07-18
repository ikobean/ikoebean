package com.mvc1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	MemberController memCtrl = new MemberController();
	GoodsController goodCtrl = new GoodsController();
	OrderController orderCtrl = new OrderController();

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
			 //command ==> member/memberInsert.kos
			 int end =command.lastIndexOf('.'); //19
			 logger.info(command+" , "+end);
			 command = command.substring(0,end);	
			 logger.info(command); //command = member/memberInsert							//★여기까지
			 
			 /* 요청하는 이름.kos 로 되게 해라~
			 * 테스트 할 때 어떤 이름이든 상관없이 ?work=member를 넘겨주면 됨
			 * work 정보는 사용자가 요청시 결정해서 넘겨주고
			 * crud의 경우는 같은 회원관리 업무 중에서도 입력인지 수정건인지 삭제 건인지 
			 * 조회 건인지 식별할 수 있어야 함.
			 */
//			StringBuffer url = req.getRequestURL();
//			String url2 = url.toString();
//			if(url2.contains("shdrn")) {
//				
//			}
//			else if(url2.contains("qoemalsxjs")) {
//				
//			}
			String work = req.getParameter("work");
			ActionForward forward = null;
			if("member".equals(work)) {
				req.setAttribute("crud", command);//crud속성에 select를 담아라
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
			}
			
			if(forward!=null) {
				if(forward.isRedirect()) {
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
