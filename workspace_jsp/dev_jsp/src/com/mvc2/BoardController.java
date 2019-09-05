package com.mvc2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.vo.BoardMasterVO;

public class BoardController implements Controller {
	Logger logger = Logger.getLogger(BoardController.class);
	BoardMasterVO bmVO = new BoardMasterVO();
	String requestName = null;
	String crud		   = null;
	String path		   = null;
	BoardLogic bLogic  = null;
	int total=0;
	
	public BoardController(String requestName, String crud) {
		this.requestName = requestName;
		this.crud		 = crud;
		bLogic = new BoardLogic();
		BoardMasterVO bmVO = new BoardMasterVO();
		total=bLogic.getTotal(bmVO);
	}
	
	/*
	 * 현재 게시판 목록을 조회할 때 boardList.jsp를 호출하였다.
	 * 이렇게 호출하면 ActionServlet을 경유하지 않는 것이다. - 세션값이 없다.
	 * 그럼 어떻게 경유하도록 할 것인가? jsp가 아니라 test.nb로 요청 -> boardList.jsp 호출
	 * 위와 같이 하면 객체 주입이 일어남. (생성자 호출이 일어남)
	 * 생성자 안에서 전체 레코드를 가져오자. -> 세션 미리 담기
	 * 생성자 안에 없는게 뭐지?
	 * 페이지 요청을 표준 서블릿으로 처리를 받아서는 세션값에 사용이 불가함.
	 * ->ActionServlet 경유하라!
	 * 	 
	 */

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공");
		HttpSession session = req.getSession();
		session.setAttribute("s_tot", total);
		logger.info("총레코드수:"+session.getAttribute("s_tot"));
		/**************************************************************************************
		 * myBatis 트랜잭션처리 실습 코드
		 * 
		 * 테스트 시나리오
		 * BoardController에서 테스트하므로 폴더명은 반드시 board로 할 것.
		 * crud는 반드시 tr로 처리해야 transactionTest 메소드 호출 가능함.
		 * 
		 * http://192.168.0.244:8000/board/test.nb?crud=tr
		 * 
		 **********************************************************************************/
		if("tr".equals(crud)) {
			String msg = bLogic.transactionTest();
			req.setAttribute("msg", msg);
			path="forward:testResult.jsp";//나는 꼭 ㅍㅔ이지를 통해서 메시지를 봐야되겠다!!!할 때.
		}
		
		else if("boardView".equals(crud)) {
			path="redirect:boardList.jsp";
		}
		/*
		 * 아래 조건은 전체 레코드 수가 아닌 검색 결과에 대한 레코드 수를 채번하기 위한 코드임.
		 * 주의:pageSize나 pageNumber를 넘기게 되면 total값에 영향을 주는 인자니까
		 * 		배제함.		 
		 */
		else if("total".equals(crud)) {
			//이거 왜 set해줘야돼?
		/*	String cb_search = req.getParameter("cb_search");
			bmVO.setCb_search(cb_search);
			//사용자가 입력한 문자열
			String keyword = req.getParameter("keyword");
			bmVO.setKeyword(keyword);
		*/	
			total=bLogic.getTotal(bmVO);
			req.setAttribute("rTot", total);
			path="forward:jsonTotal.jsp";
		}
		else if("boardList".equals(crud)) {
			logger.info("목록조회");
			List<Map<String,Object>> boardList=null;
			//조회시 검색 조건에 해당하는 값을 담을 변수
			//콤보박스에서 선택한 value 값이 담김 - bm_title, bm_content, bm_writer
			String cb_search = req.getParameter("cb_search");
			bmVO.setCb_search(cb_search);
			//사용자가 입력한 문자열
			String keyword = req.getParameter("keyword");
			bmVO.setKeyword(keyword);
			//페이지처리 초기값 담기
			int pageNumber = 0;
			int pageSize = 0;
			if(req.getParameter("pageNumber")!=null) {
				pageNumber = Integer.parseInt(req.getParameter("pageNumber").toString());
			}
			if(req.getParameter("pageSize")!=null) {
				pageSize = Integer.parseInt(req.getParameter("pageSize").toString());
			}
			//logger.info(pageNumber);
			//logger.info(pageSize);
			bmVO.setPageNumber(pageNumber);
			bmVO.setPageSize(pageSize);
			boardList=bLogic.boardList(bmVO);
			req.setAttribute("boardList", boardList);
			//아래는 json포맷으로 값을 넘겨서 목록처리하는 코드
		    //path ="forward:jsonBoardList.jsp";
			//아래는 json을 사용하지 않고 스크립트 요소로 처리하는 코드
			//댓글처리에 대한 차수 정렬과 끼어드는 글에 대한 상수값들의 변화를 관찰해서
			//기존에 설계한 값들에 유효성 체크를 하기 위함.
			path ="forward:boardListVer2.jsp";
//			path ="redirect:boardListVer2.jsp";
		}
		
		else if("boardDetail".equals(crud)) {
			logger.info("상세보기");
			/*
			 * 전체조회 혹은 조건조회와 같은 로직을 타도 되지만
			 * 응답이 나가는 페이지가 다르므로 로직과 Dao는 같이 사용하고 컨트롤 계층만 따로 분리하였다.
			 * if문을 사용해서 같은 로직을 태워도 되겠지만 유지보수를 생각했을 때
			 * 1:1로 대응하는 방법이 유리하기 때문에 컨트롤 계층만 분리함.
			 */
			List<Map<String,Object>> boardDetail=null;
			bmVO = null;
			bmVO = new BoardMasterVO();
			if(req.getParameter("bm_no")!=null) {
				bmVO.setBm_no(Integer.parseInt(req.getParameter("bm_no")));
			}
			bmVO.setGubun("detail");
			boardDetail=bLogic.boardList(bmVO);
			req.setAttribute("boardDetail", boardDetail);
			path ="forward:read.jsp";
		}
		else if("updateForm".equals(crud)) {
			logger.info("수정기본내용");
			List<Map<String,Object>> updateForm = null;
			bmVO = null;
			bmVO = new BoardMasterVO();
			if(req.getParameter("bm_no")!=null) {
				bmVO.setBm_no(Integer.parseInt(req.getParameter("bm_no")));
			}
			updateForm=bLogic.boardList(bmVO);
			req.setAttribute("updateForm", updateForm);
			path ="forward:updateForm.jsp";
		}
		else if("boardAdd".equals(crud)) {
			int result = 0;
			logger.info("입력");
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.multiBind(pMap); //enctype
			//hmb.bindPost(pMap);
			//logger.info("제목: "+pMap.get("bm_title"));
			result = bLogic.boardAdd(pMap);
			if(result==1) {
				path ="redirect:/board/test.nb?crud=boardList"; //여기로 보내겠다.
			}else if(result==0){
				path ="redirect:/board/boardAddFail.jsp";
			}
		
			}
		else if("boardUpd".equals(crud)) {
			int result=0;
			logger.info("수정");
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.multiBind(pMap);
			logger.info("왜그래용:"+pMap.get("bs_file"));//원래 파일이름. imsi가 " "
			//if(pMap.get("imsi")!=null)logger.info("pMap:"+pMap.get("imsi"));
			//넘길 때는 map으로 받을 때는 vo로 
			result = bLogic.boardUpd(pMap);
			if(result==1) {
				path ="redirect:/board/test.nb?crud=boardList"; //여기로 보내겠다.
			}else if(result==0){
				path ="redirect:/board/boardAddFail.jsp";
			}
			/*
			 * 입력일 때는 dialog로 처리하였으므로 부모창에 변경된 페이지가 직접 적용이 됨.
			 * 수정일 때는 window.open() 팝업창을 새로 열은 경우 수정에 대한 action을 태운 후에
			 * xxx.mo 액션을 요청하더라도 
			 * 자식창에 반영될 페이지가 닫히게 되어서 사용자가 화면을 볼 수 없다.
			 * 결함 - 페이지 이동처리에 대한 flow chart에 따라 적절하게 팝업창을 관리해야함.
			 * 
			 */
		}
		else if("boardDel".equals(crud)) {
			logger.info("삭제");
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			int result=0;
			//넘길 때는 map으로 받을 때는 vo로 
			result = bLogic.boardDel(pMap);
			if(result==1) {
				path ="redirect:/board/test.nb?crud=boardList"; //여기로 보내겠다.
			}else if(result==0){
				path ="redirect:/board/boardAddFail.jsp";
			}
		}
		return path;
		//return ""; ArrayIndexOutofBoundException
		//return null; NullPointerException
	}

}