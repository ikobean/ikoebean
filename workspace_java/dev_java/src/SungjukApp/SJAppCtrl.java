package SungjukApp;

public class SJAppCtrl {
	
	private static final String _INS = "insert"; //입력
	
	public SJAppVO send(SJAppVO paVO) throws Exception {
		SJAppVO raVO = null;
		String command = paVO.getCommand(); //insert
		if(_INS.equals(command)) {
			System.out.println("컨트롤 클래스 호출");
			RegisterLogic regLogic = new RegisterLogic();
			raVO = regLogic.
		}return raVO;
	}
}
