package Rental;

import java.util.List;

import Rental.RentalVO;

public class RentalCtrl {
	
	private static final String _SEL = "select";
	private static final String _DET = "detail";
	private static final String _INS = "insert";
	private static final String _UPD = "update";
	private static final String _DEL = "delete";
	private static final String _SEA = "search";
	
	
	public RentalVO send(RentalVO paVO) throws Exception { //p:조건이나 입력한 값을 받아올 때 
		RentalVO rVO = null; //r: 반환값
		String command = paVO.getCommand();
		
		if(_INS.equals(command)) { //입력
			System.out.println("입력 호출 성공");
			R_RegisterLogic regLogic = new R_RegisterLogic(); //paVO로 insert가 너어온다.
			rVO = regLogic.RentalInsert(paVO);
		}
		else if(_UPD.equals(command)) { //수정버튼을 누른거야?
			R_ModifyLogic modLogic = new R_ModifyLogic();
			rVO = modLogic.RentalUpdate(paVO);
		}
		else if(_DEL.equals(command)) { //삭제하니? 
			//equals 메소드 : 값을 비교
			R_DeleteLogic delLogic = new R_DeleteLogic();	//equals 메소드 : 값을 비교
			rVO = delLogic.RentalDelete(paVO);
		}
		else if(_DET.equals(command)) { //상세조회 
			R_ModifyLogic modLogic = new R_ModifyLogic();	//equals 메소드 : 값을 비교
			rVO = modLogic.RentalDetail(paVO);
		}else {
			throw new Exception("잘못된 command명 입니다.");
		}
		return rVO;
	}
	
	public List<RentalVO> send(String command){
		List<RentalVO> rentalList = null;
		if(_SEL.equals(command)) {
			R_RetrieveLogic retLogic = new R_RetrieveLogic();
			rentalList = retLogic.getRentalAll();
		}
		return rentalList; //전체조회 가능~
	}
	
	public List<RentalVO> send(String command,RentalVO paVO){
		List<RentalVO> rentalList = null;
		if(_SEA.equals(command)) {//삭제
			R_searchLogic seaLogic = new R_searchLogic();
			rentalList = seaLogic.getRentalSearch(paVO);
		}
		return rentalList;
	}


	
}

