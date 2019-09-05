package com.sts3.board;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.util.HangulConversion;
import com.vo.BoardMasterVO;
import com.vo.MemberVO;
/***********************************
 * 	리턴타입 설정
 *	redirect forward : String
 *	mav 사용 =>없이 가면 됨
 ***********************************/
@Controller
@RequestMapping(value="/board")
public class BoardController {
	/*
	 * Autowired 어노테이션 안에 파라미터로 required 옵션을 사용할 수 있음.
	 * 만일 BoardLogic.java가 없을 경우 Exception을 일으키게 됨.
	 * 그러나 false를 두게 되면 해당 객체가 없더라고 Exception을 던지지 않음
	 */
	@Autowired
	private BoardLogic boardLogic = null;
	
	Logger logger = Logger.getLogger(BoardController.class);
	//WEB-INF/views/board 아래에서 찾음
/****************************************************************
 * @param pMap
 * @param mod
 * @param req
 * @return
 ****************************************************************/
	@RequestMapping(value="boardList.mvc", method=RequestMethod.GET)
	public String boardList(@RequestParam Map<String,Object> pMap,Model mod	,HttpServletRequest req) {
		logger.info("boardList 호출 성공");
		logger.info(pMap.get("pageNumber"));
		logger.info(pMap.get("pageNumber"));
		logger.info("목록조회");
		int tot = 0;
		tot = boardLogic.getTotal(null);
		HttpSession session = req.getSession();
		session.setAttribute("s_tot", tot);
		
		List<Map<String,Object>> boardList=null;
		int pageNumber = 0;
		int pageSize = 0;
		
		if(pMap.containsKey("pageNumber")) {
			pageNumber = Integer.parseInt(pMap.get("pageNumber").toString());
		}
		if(pMap.containsKey("pageSize")) {
			pageSize = Integer.parseInt(pMap.get("pageSize").toString());
		}
		boardList=boardLogic.boardList(pMap);
		//request에 담는 거랑 비슷
		mod.addAttribute("boardList", boardList);
		return "forward:boardListVer2.jsp";
	}
	@RequestMapping(value="boardDetail.mvc", method=RequestMethod.GET)
	public String boardDetail(@RequestParam Map<String,Object> pMap,Model mod	,HttpServletRequest req) {
		logger.info("boardDetail 호출 성공");

		List<Map<String,Object>> boardDetail=null;
		int pageNumber = 0;
		int pageSize = 0;

		boardDetail=boardLogic.boardList(pMap);
		//request에 담는 거랑 비슷
		mod.addAttribute("boardDetail", boardDetail);
		return "forward:read.jsp";
	}
	/*
	 * @RequestParma 안에 파라미터로 required 옵션을 사용할 수 있음.
	 * 디폴트는 true로 되어 있어서 무조건 bs_file이름을 스프링이 찾게 되므로 없으면 즉 null이 들어오면 에러를 발생함. 
	 * 그러니 false를 두게 되면 해당 객체가 없더라도 Exception을 던지지 않음.
	 */
	@RequestMapping(value="boardAdd.mvc", method=RequestMethod.POST)
	public String boardAdd(@RequestParam Map<String,Object> pMap 
						  ,@RequestParam(value="bs_file",required=false) MultipartFile bs_file) {
		logger.info("boardAdd 호출 성공");
		logger.info("bm_group :"+ pMap.get("bm_group"));
		logger.info("bm_pos :"+ pMap.get("bm_pos"));
		logger.info("bm_step :"+ pMap.get("bm_step"));
		//logger.info("bs_file"+bs_file.getOriginalFilename());
		String filename=null;
		String fullPath=null;
		String savePath = "D:\\workspace_spring4\\spring5\\src\\main\\webapp\\pds";
		if(bs_file!=null) {
			 filename = bs_file.getOriginalFilename();
			 fullPath = savePath+"\\"+filename;
		}
		//HangulConversion korean = new HangulConversion();
		//첨부파일이 존재하나?
		if(bs_file!=null && !bs_file.isEmpty()) {
			try {
				File file = new File(fullPath);//파일명만 존재하고 내용은 없는
				
				byte[] bytes = bs_file.getBytes();
				BufferedOutputStream bos = 
						new BufferedOutputStream(new FileOutputStream(file));
				//52번에서 생성된 File 객체에 내용 쓰기
				bos.write(bytes);
				bos.close();
				//파일크기
				long size = file.length();
				double d_size= Math.floor(size/1024.0);
				pMap.put("bs_file",filename);
				pMap.put("bs_size",d_size);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		int result=0;
		String path="";
		logger.info("boardAdd 호출 성공");
		List<Map<String,Object>> boardAdd=null;
		result=boardLogic.boardAdd(pMap);
		if(result==1) {
			path ="redirect:boardList.mvc"; //여기로 보내겠다.
		}else if(result==0){
			path ="redirect:/board/boardAddFail.jsp";
		}
		return path;
	}
	@RequestMapping(value="boardUpd.mvc", method=RequestMethod.POST)
	public String boardUpd(BoardMasterVO bmVO) {
		logger.info("boardUpd 호출 성공");
		//HangulConversion korean = new HangulConversion();
		int result=0;
		String path="";
		List<Map<String,Object>> boardUpd=null;
		result=boardLogic.boardUpd(bmVO);
		if(result==1) {
			path ="redirect:boardList.mvc?nowPage=0"; //여기로 보내겠다.
		}else if(result==0){
			path ="redirect:/board/boardAddFail.jsp";
		}
		return path;
	}
	

	@RequestMapping(value="boardDELALL.mvc", method=RequestMethod.GET)
	public String boardDELALL(@RequestParam Map<String,Object> pMap) {
		logger.info("boardDELALL 호출 성공");
		int result=0;
		result=boardLogic.boardDELALL(pMap);
		return "redirect:boardList.mvc";
	}
			
	
	
	@RequestMapping(value="boardDel.mvc", method=RequestMethod.GET)
	public String boardDel(@RequestParam Map<String,Object> pMap,Model mod) {
		int result=0;
		logger.info("boardDel 호출 성공");
		logger.info(pMap.get("bm_no"));
		result=boardLogic.boardDel(pMap);
		return "redirect:boardList.mvc";
	}
	
	
	
	@RequestMapping(value="boardUpd.mvc", method=RequestMethod.GET)
	public String boardUpd(@RequestParam Map<String,Object> pMap,Model mod) {
		logger.info("boardUpd 호출 성공");

		List<Map<String,Object>> boardUpd=null;
		int pageNumber = 0;
		int pageSize = 0;

		boardUpd=boardLogic.boardList(pMap);
		//request에 담는 거랑 비슷
		mod.addAttribute("boardUpd", boardUpd);
		return "forward:updateForm.jsp";
	}
	
	//req, res 방법
	//webapp -> board 아래에서 찾음
	//ViewResolver 사용하지 않는 경우
	@GetMapping("boardList2")
	public String boardList2(MemberVO mVO) {
		//http://localhost:8080/sample/board/boardList2.do?mem_id=mm&mem_name=%EC%8B%9C%EC%84%B1%EC%9D%B4
		logger.info(mVO.getMem_id());
		logger.info(mVO.getMem_name());
		logger.info(mVO.getMem_addr());
		
		logger.info("webapp/baord-redirect 호출 성공");
		return "redirect:boardList.jsp";
	}
	
	//webapp -> board 아래에서 찾음
	//ViewResolver 사용하지 않는 경우
	@PostMapping("boardList3")
	public String boardList3(Model mod) {
		logger.info("webapp/baord-forward 호출 성공");
		
		List<Map<String,Object>> memList = new ArrayList<>();
		Map<String,Object> rMap = new HashMap<>();
		
		rMap.put("mem_id", "test");
		rMap.put("mem_name", "내복이");
		rMap.put("mem_address", "서울시 강북구");
		memList.add(rMap);
		
		rMap = new HashMap<>();
		rMap.put("mem_id", "막냉이");
		rMap.put("mem_name", "시성이");
		rMap.put("mem_address", "경기도 토당동");
		memList.add(rMap);
		
		rMap = new HashMap<>();
		
		rMap.put("mem_id", "mm");
		rMap.put("mem_name", "김뽕구");
		rMap.put("mem_address", "경기도 수원");
		
		memList.add(rMap);
		
		mod.addAttribute("memList",memList);
		
		return "forward:boardList.jsp";
	}
	
	//WEB-INF/views/board 아래에서 찾음
	//ViewResolver 사용하는 경우
	public ModelAndView boardList4() {
		
		logger.info("ModelAndView 호출 성공");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/boardList");
		return mav;
	}
	
}
