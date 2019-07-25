package onlineTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc1.Action;
import com.mvc1.ActionForward;
import com.util.HashMapBinder;

public class TestController extends HttpServlet implements Action {
		Logger logger = Logger.getLogger(TestController.class);
		TestLogic testLogic = new TestLogic();
		@Override
		public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException {
			
			ActionForward forward = new ActionForward();
			String viewName		  = null;
			boolean isRedirect    = false;
			//command="/onlineTest/subjectList.kos?work=onlineTest
			//command.substring(0,end);
			String crud = (String)req.getAttribute("crud");
			//==>/onlineTest/subjectList.kos?work=onlineTest
			if("onlineTest/examReceipt".equals(crud)) {
				logger.info("시험 접수 호출 성공");
				int result = -1; //시험 접수 성공 여부
				//사용자가 입력한 값 받아오기
				Map<String,Object> pMap = new HashMap<>();
				HashMapBinder hmb = new HashMapBinder(req);
				hmb.bind(pMap);
				//화면에서 받아올 것들 - 아이디, 과목, 응시일자
				
				//서버에서 새로 채번할 것들 - 수험번호
				result = testLogic.examReceipt(pMap);
				viewName="index.jsp";
				isRedirect = true;
				forward.setRedirect(isRedirect);
				forward.setviewName(viewName);
			}else if("onlineTest/subjectList".equals(crud)) {
				logger.info("testCntrl 호출 성공");
				List<Map<String,Object>> subList = null;
				subList = testLogic.subjectList();//조건절필요없으니까 파라미터 out
				//조회된 결과를 변수에 담음. request 저장소
				//request 저장소는 forward 일 때만 유지
				req.setAttribute("subList", subList);
				viewName = "jsonSubjectList.jsp";
				isRedirect = false; //redirect니? 아니! ==>forward
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
