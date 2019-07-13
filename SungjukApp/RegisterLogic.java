package SungjukApp;

public class RegisterLogic {
	SJAppDao dao = new SJAppDao();
	
	public SJAppVO SJAppInsert(SJAppVO paVO) {
		SJAppVO raVO = new SJAppVO();
		raVO= dao.sjInsert(paVO);
		System.out.println(raVO);
		return raVO;
	}
	
}
