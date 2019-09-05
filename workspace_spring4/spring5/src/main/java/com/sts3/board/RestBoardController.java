package com.sts3.board;
//http 응답에 바로 내보낸다?

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vo.BoardMasterVO;

@RestController
@RequestMapping(value="/board", produces="text/plain;charset=UTF-8")
public class RestBoardController {
	Logger logger = Logger.getLogger(RestBoardController.class);
	int tot=0;
	@Autowired
	public BoardLogic boardLogic=null;
	
	@RequestMapping(value="total.mvc", method=RequestMethod.GET)
	public String total(BoardMasterVO bmVO, Model mod) {
			tot=boardLogic.getTotal(bmVO);
			return tot+"";
	}
	@GetMapping(value="jsonBoardList",produces="application/json;charset=UTF-8")
	public String jsonBoardList() {
		logger.info("jsonBoardList 호출 성공");
		String text = "funckin HUNGRYYYYYYYYYYYYYYYYYYYYYY 배고파ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ";
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
		
		Gson g = new Gson();
		String meminfo = g.toJson(memList);
		
		return meminfo;
	}
}
