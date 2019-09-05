package com.sts3.board;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.BoardMasterVO;
@Service
public class BoardLogic {

	Logger logger = Logger.getLogger(BoardLogic.class);
	
	/*
	 * @Autowired private BoardMasterVO boardMasterVo=null;
	 */
	@Autowired
	private BoardDao boardDao = null;
	int total=0;
	public int getTotal(BoardMasterVO bmVO) {
		logger.info("logic getTotal 호출 성공");
		total=0;
		total=boardDao.getTotal(bmVO);
		return total;
	}
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("baordList 호출 성공");
		List<Map<String,Object>> boardList = null;
		BoardMasterVO bmVO = new BoardMasterVO();
		total= getTotal(bmVO);
		int pageNumber = 0; //2
		//한 페이지에 뿌려질 수
		int pageSize = 0; //2
		//시작 번호
		int start = 0;
		//끝 번호
		int end = 0;
		
		/*********************************************************************
		 * VO로 값을 받아서 전달할 땐 타입체크를 따로 하지 않아도 되지만
		 * Map으로 받아서 처리할 땐 타입체크를 해야함.
		 * 조인시에는 Map을 사용하는 것이 좋겠고 (왜냐하면 파라미터에 주소번지 하나만 넘기면 되니까)
		 * 테이블이 한 개일 경우엔 VO를 사용하는 게 좋을 것이다.
		 * 
		*********************************************************************/
		String spageNumber="";
		if(pMap.get("pageNumber")!=null) {
			spageNumber=pMap.get("pageNumber").toString();
			pageNumber=Integer.parseInt(spageNumber);
		}
		String spageSize="";
		if(pMap.get("pageSize")!=null) {
			spageSize=pMap.get("pageSize").toString();
			pageSize=Integer.parseInt(spageNumber);
		}

		if(pageNumber>0) {
			start = ((pageNumber-1)*pageSize)+1;
			end	  = pageNumber*pageSize;
			pMap.put("start", start);
			if(end>total) {
				pMap.put("end", total);
			}else {
				pMap.put("end", end);
			}
		}
		boardList=boardDao.boardList(pMap);
		
		if(boardList.size()==1) {
			if(pMap.get("bm_no")!=null) {
			int bm_no = Integer.parseInt(pMap.get("bm_no").toString());
				boardDao.hitCount(bm_no);
				logger.info(bm_no);
			}
		}
		logger.info("boardList.size()================"+boardList.size());
		logger.info("start"+start+", end"+end);
		return boardList;
	}
	
	public int boardAdd(Map<String, Object> pMap) {
		int mresult=0;
		int sresult=0;
		int bm_no=0;
		int bm_group=0;
		int bm_pos=0;
		int bm_step=0;
		String bs_file = "";
		String bs_size = "";
		logger.info("boardAdd 호출 성공");
		
		if(pMap.get("bm_group")!=null) {
			bm_group = Integer.parseInt(pMap.get("bm_group").toString());
		}
		List<Map<String,Object>> boardAdd=null;
		bm_no = boardDao.getBmno();
		pMap.put("bm_no", bm_no);
		
		if(bm_group>0) { //너 댓글이니?
			boardDao.bmStepUpdate(pMap);
			int pos=0;
			if(pMap.get("bm_pos")!=null) {
				pos = Integer.parseInt(pMap.get("bm_pos").toString());
			}
			pMap.put("bm_pos",pos+1);
			
			int step=0;
			if(pMap.get("bm_step")!=null) {
				step = Integer.parseInt(pMap.get("bm_step").toString());
			}
			pMap.put("bm_step",step+1);
		}
		else { //너 새글이지?
			bm_group = boardDao.getBmgroup();
			pMap.put("bm_group",bm_group);
			pMap.put("bm_pos",0);
			pMap.put("bm_step",0);
		}
		//공통 처리 부분
		mresult=boardDao.boardAdd(pMap);
		//첨부파일이 있을 때
		if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length()>1) {
			sresult = boardDao.boardSAdd(pMap);
				}
		//첨부파일이 없을 때
		return mresult;
	}
	
	public int boardUpd(BoardMasterVO bmVO) {
		int mresult=0;
		//공통 처리 부분
		mresult=boardDao.boardUpd(bmVO);
		return mresult;
	}
	public int boardDel(Map<String, Object> pMap) {
		logger.info("boardDel 호출 성공");
		int result = 0;
		int mresult = 0;
		int sresult = 0;
		String filePath="D:\\workspace_spring4\\srping5\\src\\main\\webapp\\pds";
		//File 객체 생성시 경로정보가 필수이므로
		String filename = null;
		
		if(pMap.get("bm_no")!=null) {
			int bm_no=Integer.parseInt(pMap.get("bm_no").toString());
			logger.info("bm_no 널이니????"+bm_no);
			pMap.put("bm_no", bm_no);
			pMap.put("bs_seq", 1);
		}
		if(pMap.get("delAll").equals("delAll")) {
			logger.info("전체ㅔㅔㅔㅔㅔ삭제ㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔ");
			String msg="삭제";
			boardDao.delAll(msg);
		}
		logger.info("pMap.get(bs_file)==============================="+pMap.get("bs_file"));
		logger.info("pMap.get(\"bs_file\").toString().length()==============================="+pMap.get("bs_file").toString().length());
		//첨부파일이 있을 때
		if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length()>1) {
			logger.info("여긴타니?????????????????????????????????");
			filename = pMap.get("bs_file").toString();
			String fullPath = filePath+"\\"+filename;
			File file = new File(fullPath);
			if(file.exists()) { //그 파일이 서버에 존재하니?
				boolean isOk = file.delete();
				logger.info("삭제유무==>"+isOk);
				int ibm_no=0;
			}
			sresult = boardDao.boardSDel(pMap);
		}
		//첨부파일이 없을 때

		
		//공통 처리 부분
		mresult = boardDao.boardMDel(pMap);
		return mresult;
	}
	public int boardDELALL(Map<String, Object> pMap) {
		logger.info("boardDELALL호출");
		//문자열을 토큰을 기준으로 썰어주는 클래스
		String bmnos = pMap.get("bmnos").toString();
		String bsfiles = pMap.get("bsfiles").toString();
		String bsfileArr[] = null;
		StringTokenizer st = new StringTokenizer(bmnos,",");
		//썰어진 문자열 갯수를 가지고 배열생성
		String emnoArr[] = new String[st.countTokens()];
		for(int i=0;i<emnoArr.length;i++) {
			//배열의 원소갯수만큼 초기화
			emnoArr[i] = st.nextToken();
		}
		if(bsfiles.length()>0) {
			String filePath = "D:\\workspace_spring4\\spring5\\src\\main\\webapp\\pds\\";
			StringTokenizer st2 = new StringTokenizer(bsfiles,",");
			bsfileArr = new String[st2.countTokens()];
			//첨부파일에 대한 배열 초기화하는 코드
			for(int i=0;i<bsfileArr.length;i++) {
				//배열의 원소갯수만큼 초기화
				bsfileArr[i] = st2.nextToken();
			}
			///////// 첨부파일 삭제 처리하기 //////////
			String fullPath = null;
			for(int i=0;i<bsfileArr.length;i++) {
				fullPath = filePath+bsfileArr[i];
				File file = new File(fullPath);
				if(file.exists()) {//그 파일이 서버에 존재하니?
					boolean isOk = file.delete();
					logger.info("삭제유무:"+isOk);
					boardDao.boardSDELALL(emnoArr);			
				}
			}	
			//////// 첨부파일 삭제 처리 끝 /////////////
		}///////////end of if - 첨부파일이 있을 경우 처리
		boardDao.boardMDELALL(emnoArr);
		return 0;
	}
	
}
