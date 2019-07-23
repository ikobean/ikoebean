package onlineTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc1.Action;
import com.mvc1.ActionForward;
import com.mybatis.ZipCodeDao;
import com.vo.ZipCodeVO;

public class TestController extends HttpServlet implements Action {
		Logger logger = Logger.getLogger(TestController.class);
		TestLogic testlogic = new TestLogic();
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
			
			if("onlineTest/subjectList".equals(crud)) {
				logger.info("testCntrl 호출 성공");
				List<Map<String,Object>> subList = null;
				subList = testlogic.subjectList();//조건절필요없으니까 파라미터 out
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