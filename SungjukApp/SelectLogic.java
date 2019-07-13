package SungjukApp;

import java.util.List;

public class SelectLogic {
	SJAppDao dao = new SJAppDao();
	public List<SJAppVO> SJAppSelect() {
		List<SJAppVO> listAll = null;
		listAll = dao.sjSelect(); //paVO 지우면 왜 오류가 날까?
		return listAll;
		
	}
}
