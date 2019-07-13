package rental;

import java.util.List;

import com.address.AddressVO;

public class RentalCtrl {
	
	private static final String _SEL = "select";
	private static final String _DET = "detail";
	private static final String _INS = "insert";
	private static final String _UPD = "update";
	private static final String _DEL = "delete";
	
	public RentalVO send(RentalVO paVO) throws Exception { //p:조건이나 입력한 값을 받아올 때 
		RentalVO raVO = null; //r: 반환값
		String command = paVO.getCommand();
		if(_INS.equals(command)) { //입력
			
		}
		else if(_UPD.equals(command)) { //수정버튼을 누른거야?
			
		}
		else if(_DEL.equals(command)) { //삭제하니? 
										//equals 메소드 : 값을 비교
			
		}
		else if(_DET.equals(command)) { //상세조회 
			
		}else {
			throw new Exception("잘못된 command명 입니다.");
		}
		return raVO;
	}



public List<RentalVO> send(String command){
	List<RentalVO> rentalList = null;
	if(_SEL.equals(command)) {
		
	}
	return rentalList; //전체조회 가능~
}

}

