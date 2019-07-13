package SungjukApp;

import java.util.List;

public class SJAppCtrl {
	
	private static final String _INS = "insert"; //입력
	private static final String _SEL = "select"; //조회
	
	public SJAppVO send(SJAppVO paVO) throws Exception {
		SJAppVO raVO = null;
		String command = paVO.getCommand(); //insert
		System.out.println(command);
		if(_INS.equals(command)) {
			//System.out.println("컨트롤 클래스 호출");
			RegisterLogic regLogic = new RegisterLogic();
			raVO = regLogic.SJAppInsert(paVO);
		}
		return raVO;
	}
	public List<SJAppVO> send(String command){
		List<SJAppVO> listAll = null;
		if(_SEL.equals(command)) {
			SelectLogic selLogic = new SelectLogic();
			listAll = selLogic.SJAppSelect();
		}return listAll;
	}
}
