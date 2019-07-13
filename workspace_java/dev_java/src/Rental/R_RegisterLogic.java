package Rental;
//인서트 입력
import java.util.List;
public class R_RegisterLogic {
	
	RentalInterface rDao = new RentalDao();
	
	public RentalVO RentalInsert(RentalVO paVO) {
		RentalVO rVO = null;
		System.out.println(" R_ModifyLogic Insert 호출 성공");
		rVO = rDao.RentalInsert(paVO);
		return rVO;
	}
}


